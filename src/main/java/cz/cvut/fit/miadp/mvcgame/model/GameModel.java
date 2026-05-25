package cz.cvut.fit.miadp.mvcgame.model;

import cz.cvut.fit.miadp.mvcgame.abstractfactory.GameObjectFactory_A;
import cz.cvut.fit.miadp.mvcgame.abstractfactory.GameObjectFactory_B;
import cz.cvut.fit.miadp.mvcgame.abstractfactory.IGameObjectFactory;
import cz.cvut.fit.miadp.mvcgame.builder.BuildLevel1;
import cz.cvut.fit.miadp.mvcgame.builder.BuildLevel2;
import cz.cvut.fit.miadp.mvcgame.builder.Director;
import cz.cvut.fit.miadp.mvcgame.command.AbstractGameCommand;
import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.objects.AbstractCannon;
import cz.cvut.fit.miadp.mvcgame.model.objects.AbstractEnemy;
import cz.cvut.fit.miadp.mvcgame.model.objects.AbstractMissile;
import cz.cvut.fit.miadp.mvcgame.model.objects.GameObject;
import cz.cvut.fit.miadp.mvcgame.model.objects.enemies.EnemyVertical;
import cz.cvut.fit.miadp.mvcgame.model.objects.enemies.EnemyHorizontal;
import cz.cvut.fit.miadp.mvcgame.observer.Aspect;
import cz.cvut.fit.miadp.mvcgame.observer.IObservable;
import cz.cvut.fit.miadp.mvcgame.observer.IObserver;
import cz.cvut.fit.miadp.mvcgame.proxy.IGameModel;
import cz.cvut.fit.miadp.mvcgame.state.DynamicShootingMode;
import cz.cvut.fit.miadp.mvcgame.strategy.IMovingStrategy;
import cz.cvut.fit.miadp.mvcgame.visitor.GameObjectSoundPlayer;
import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

public class GameModel implements IGameModel, IObservable {

    private AbstractCannon cannonA;
    private IGameObjectFactory goFactoryA;

    private AbstractCannon cannonB;
    private IGameObjectFactory goFactoryB;

    private List<AbstractMissile> missiles;
    private Map<IObserver,Aspect> observers;
    private GameObjectSoundPlayer soundPlayer;

    private Queue<AbstractGameCommand> unexecutedCommands;
    private Stack<AbstractGameCommand> executedCommands;

    private Director director;

    private int score;

    public GameModel() {
        this.observers = new HashMap<IObserver,Aspect>();
        this.goFactoryA = new GameObjectFactory_A(this);
        this.goFactoryB = new GameObjectFactory_B(this);
        this.cannonA = this.goFactoryA.createCannon();
        this.cannonB = this.goFactoryB.createCannon();
        this.missiles = new ArrayList<AbstractMissile>();
        this.soundPlayer = new GameObjectSoundPlayer();
        this.unexecutedCommands = new LinkedBlockingQueue<AbstractGameCommand>();
        this.executedCommands = new Stack<AbstractGameCommand>();
        this.director = new Director(new BuildLevel1(this.goFactoryA));
        this.score = 0;
    }

    public void update() {
        this.moveCannonB();
        this.executeCommands();
        this.moveMissiles();
        this.checkCollisions();
    }

    private void executeCommands() {
        while(!this.unexecutedCommands.isEmpty()) {
            AbstractGameCommand cmd = this.unexecutedCommands.poll();
            cmd.doExecute();
            this.executedCommands.push(cmd);
        }
    }

    public void moveCannonB() {
        if (this.cannonB.isMovingDown() && this.cannonB.getPosition().getY() < MvcGameConfig.RIGHT_BOT_ENEMY_SPAWN_Y) {
            this.cannonB.move(new Vector(0,2));
        }

        if (this.cannonB.getPosition().getY() == MvcGameConfig.RIGHT_BOT_ENEMY_SPAWN_Y) {
            this.cannonB.setMovingDown(false);
        }
        if (!this.cannonB.isMovingDown() && this.cannonB.getPosition().getY() > MvcGameConfig.LEFT_TOP_ENEMY_SPAWN_Y) {
            this.cannonB.move(new Vector(0,-2));
        }
        if (!this.cannonB.isMovingDown() && this.cannonB.getPosition().getY() == MvcGameConfig.LEFT_TOP_ENEMY_SPAWN_Y) {
            this.cannonB.setMovingDown(true);
        }
    }

    private void checkCollisions() {
        List<AbstractEnemy> enemies = this.director.getBuilder().getEnemiesList();
        for(AbstractEnemy enemy : enemies) {
            if (enemy instanceof EnemyVertical) {
                ((EnemyVertical) enemy).makeStep();
            }
            if (enemy instanceof EnemyHorizontal) {
                ((EnemyHorizontal) enemy).makeStep();
            }
            for (AbstractMissile missile : missiles) {
                if (checkCollision(enemy,missile)) {
                    this.soundPlayer.visitEnemy(enemy);
                    enemy.changePosition(enemy.getNewPosition());
                    score++;
                    missiles.remove(missile);
                    break;
                }
            }
        }
        checkLevel();
    }

    private void moveMissiles() {
        for (AbstractMissile missile : missiles) {
            missile.move();
        }
        this.destroyMissiles();
        this.notifyObserver(Aspect.ASPECT.MISSILE);
    }

    public void checkLevel() {
        if (score < 5 && director.getBuilder() instanceof BuildLevel2) {
            this.director.changeBuilder(new BuildLevel1(this.goFactoryA));
        }

        if (score >= 5 && director.getBuilder() instanceof BuildLevel1) {
            this.director.changeBuilder(new BuildLevel2(this.getGoFactoryA()));
        }
    }

    private void destroyMissiles() {
        List<AbstractMissile> missilesAToRemove = new ArrayList<AbstractMissile>();
        for (AbstractMissile missile : missiles) {
            if (missile.getPosition().getX() > MvcGameConfig.MAX_X ||
                missile.getPosition().getY() > MvcGameConfig.MAX_Y ||
                missile.getPosition().getX() < 0 ||
                missile.getPosition().getY() < 0)
            {
                missilesAToRemove.add(missile);
                missile.acceptVisitor(soundPlayer);
            }
        }
        this.missiles.removeAll(missilesAToRemove);
    }

    public AbstractCannon getCannonA() {
        return cannonA;
    }

    public AbstractCannon getCannonB() {
        return cannonB;
    }

    @Override
    public Position getCannonAPosition() {
        return this.cannonA.getPosition();
    }

    @Override
    public Position getCannonBPosition() {
        return this.cannonB.getPosition();
    }

    public IGameObjectFactory getGoFactoryA() { return this.goFactoryA; }

    public Director getDirector() { return director; }

    public int getScore() {
        return score;
    }

    @Override
    public void registerObserver(IObserver obs, Aspect aspect) {
        if (!this.observers.containsKey(obs)) {
            this.observers.put(obs,aspect);
        }
        else {
            this.observers.get(obs).addAdditionalAspects(aspect.getAspectSet());
        }
    }

    @Override
    public void unregisterObserver(IObserver obs, Aspect aspect) {
        this.observers.remove(obs);
    }

    @Override
    public void notifyObserver(Aspect.ASPECT... aspects) {
        for (Map.Entry<IObserver, Aspect> pair : this.observers.entrySet()) {

            if (pair.getValue().containsAny(aspects)) {
                pair.getKey().update();
            }
        }
    }


    public void cannonAShoot() {
        this.soundPlayer.visitCannonA(this.cannonA);
        this.missiles.addAll( cannonA.shoot( ) ) ;
        this.notifyObserver(Aspect.ASPECT.MISSILE, Aspect.ASPECT.CANNON);

    }

    public void cannonBShoot() {
        this.soundPlayer.visitCannonB(this.cannonB);
        this.missiles.addAll( cannonB.shoot( ) ) ;
        this.notifyObserver(Aspect.ASPECT.MISSILE, Aspect.ASPECT.CANNON);
    }


    public List<GameObject> getGameObjects() {
        List<GameObject> go = new ArrayList<>();
        go.add(cannonA);
        go.add(cannonB);
        go.addAll(missiles);
        go.addAll(director.getBuilder().getEnemiesList());
        return go;
    }

    public void moveCannonAUp() {
        this.cannonA.moveUp();
        this.notifyObserver(Aspect.ASPECT.CANNON);
    }

    public void moveCannonADown() {
        this.cannonA.moveDown();
        this.notifyObserver(Aspect.ASPECT.CANNON);
    }


    public void aimCannonAUp( ) {
        this.cannonA.aimUp( );
        this.notifyObserver(Aspect.ASPECT.CANNON);
    }

    public void aimCannonADown( ) {
        this.cannonA.aimDown( );
        this.notifyObserver(Aspect.ASPECT.CANNON);
    }

    public void cannonAPowerUp( ) {
        this.cannonA.powerUp( );
        this.notifyObserver(Aspect.ASPECT.CANNON);
    }

    public void cannonAPowerDown( ) {
        this.cannonA.powerDown( );
        this.notifyObserver(Aspect.ASPECT.CANNON);
    }

    public void toggleShootingModeA( ){
        this.cannonA.toggleShootingMode( );
    }

    public void increaseDynamicShootCounterA( ){
        this.cannonA.increaseDynamicShoot();
    }

    public void decreaseDynamicShootCounterA( ){
        this.cannonA.decreaseDynamicShoot();
    }

    public void toggleMovingStrategyA() {
        this.cannonA.toggleMovingStrategy();
    }

    @Override
    public IMovingStrategy getCannonAMovingStrategy() {
        return cannonA.getMovingStrategy();
    }

    private class Memento {
        private int score;
        private int cannonAPositionX;
        private int cannonAPositionY;
        private double cannonAAngle;
        private int cannonAPower;
        private String cannonAMovingStrategy;
        private String cannonAShootingMode;
        private int cannonADynamicShootingCounter;
    }

    public Object createMemento( ) {
        Memento m = new Memento( );
        m.score = this.score;
        m.cannonAPositionX = this.cannonA.getPosition().getX();
        m.cannonAPositionY = this.cannonA.getPosition().getY();
        m.cannonAAngle = this.cannonA.getAngle();
        m.cannonAPower = this.cannonA.getPower();
        m.cannonAMovingStrategy = this.cannonA.getMovingStrategy().getStrategyName();
        m.cannonAShootingMode = this.cannonA.getShootingMode().getName();
        if (this.cannonA.getShootingMode() instanceof DynamicShootingMode) {
            m.cannonADynamicShootingCounter = ((DynamicShootingMode) this.cannonA.getShootingMode()).getShotsCount();
        }
        else {
            m.cannonADynamicShootingCounter = 0;
        }
        return m;
    }

    public void setMemento( Object memento ) {
        Memento m = ( Memento ) memento;
        this.cannonA.getPosition().setX(m.cannonAPositionX);
        this.cannonA.getPosition().setY(m.cannonAPositionY);
        this.score = m.score;
        this.cannonA.setAngle(m.cannonAAngle);
        this.cannonA.setPower(m.cannonAPower);
        this.cannonA.setMovingStrategyByName(m.cannonAMovingStrategy);
        this.cannonA.setShootingModeByName(m.cannonAShootingMode,m.cannonADynamicShootingCounter);
    }


    @Override
    public void registerCommand(AbstractGameCommand command) {
        this.unexecutedCommands.add(command);
    }

    @Override
    public void undoLastCommand() {
        if (!this.executedCommands.isEmpty()) {
            AbstractGameCommand cmd = this.executedCommands.pop();
            cmd.unExecute();
        }
        this.notifyObserver();
    }

    public boolean checkCollision(AbstractEnemy enemy, AbstractMissile missile) {
        Image imageEnemy = new Image("images/enemy1.png");
        Image imageMissile = new Image("images/missile1B_shrink.png");

        Rectangle rectangleEnemy = new Rectangle();
        rectangleEnemy.setX(enemy.getPosition().getX());
        rectangleEnemy.setY(enemy.getPosition().getY());
        rectangleEnemy.setHeight(imageEnemy.getHeight());
        rectangleEnemy.setWidth(imageEnemy.getWidth());

        Rectangle rectangleMissile = new Rectangle();
        rectangleMissile.setX(missile.getPosition().getX());
        rectangleMissile.setY(missile.getPosition().getY());
        rectangleMissile.setHeight(imageMissile.getHeight());
        rectangleMissile.setWidth(imageMissile.getWidth());

        return rectangleEnemy.getBoundsInParent().intersects(rectangleMissile.getBoundsInParent());
    }
}
