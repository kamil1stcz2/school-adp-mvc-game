package cz.cvut.fit.miadp.mvcgame.proxy;

import cz.cvut.fit.miadp.mvcgame.abstractfactory.IGameObjectFactory;
import cz.cvut.fit.miadp.mvcgame.builder.Director;
import cz.cvut.fit.miadp.mvcgame.command.AbstractGameCommand;
import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.model.objects.AbstractCannon;
import cz.cvut.fit.miadp.mvcgame.model.objects.GameObject;
import cz.cvut.fit.miadp.mvcgame.observer.Aspect;
import cz.cvut.fit.miadp.mvcgame.observer.IObserver;
import cz.cvut.fit.miadp.mvcgame.strategy.IMovingStrategy;

import java.util.List;

public class GameModelProxy implements IGameModel {

    private IGameModel subject;

    public GameModelProxy(IGameModel model) {
        this.subject = model;
    }

    @Override
    public void update() {
        this.subject.update();
    }

    @Override
    public AbstractCannon getCannonA() {
        return this.subject.getCannonA();
    }

    @Override
    public AbstractCannon getCannonB() {
        return this.subject.getCannonB();
    }

    @Override
    public void moveCannonAUp() {
        this.subject.moveCannonAUp();
    }

    @Override
    public void moveCannonADown() {
        this.subject.moveCannonADown();
    }

    @Override
    public void cannonAShoot() {
        this.subject.cannonAShoot();
    }

    @Override
    public void cannonBShoot() {
        this.subject.cannonBShoot();
    }

    @Override
    public List<GameObject> getGameObjects() {
        return this.subject.getGameObjects();
    }

    @Override
    public void aimCannonAUp() {
        this.subject.aimCannonAUp();
    }

    @Override
    public void aimCannonADown() {
        this.subject.aimCannonADown();
    }

    @Override
    public void cannonAPowerUp() {
        this.subject.cannonAPowerUp();
    }

    @Override
    public void cannonAPowerDown() {
        this.subject.cannonAPowerDown();
    }

    @Override
    public void toggleShootingModeA() {
        this.subject.toggleShootingModeA();
    }

    @Override
    public void toggleMovingStrategyA() {
        this.subject.toggleMovingStrategyA();
    }

    @Override
    public IMovingStrategy getCannonAMovingStrategy() {
        return this.subject.getCannonAMovingStrategy();
    }

    @Override
    public Object createMemento() {
        return this.subject.createMemento();
    }

    @Override
    public void setMemento(Object memento) {
        this.subject.setMemento(memento);
    }

    @Override
    public void increaseDynamicShootCounterA() {
        this.subject.increaseDynamicShootCounterA();
    }

    @Override
    public void decreaseDynamicShootCounterA() {
        this.subject.decreaseDynamicShootCounterA();
    }

    @Override
    public Position getCannonAPosition() {
        return this.subject.getCannonAPosition();
    }

    @Override
    public Position getCannonBPosition() {
        return this.subject.getCannonBPosition();
    }

    @Override
    public IGameObjectFactory getGoFactoryA() {
        return this.subject.getGoFactoryA();
    }

    @Override
    public void registerObserver(IObserver obs, Aspect aspect) {
        this.subject.registerObserver(obs,aspect);
    }

    @Override
    public void unregisterObserver(IObserver obs, Aspect aspect) {
        this.subject.unregisterObserver(obs,aspect);
    }

    @Override
    public void notifyObserver(Aspect.ASPECT... aspects) {
        this.subject.notifyObserver(aspects);
    }
    @Override
    public void registerCommand(AbstractGameCommand command) {
        this.subject.registerCommand(command);
    }

    @Override
    public void undoLastCommand() {
        this.subject.undoLastCommand();
    }

    @Override
    public int getScore() {
        return this.subject.getScore();
    }

    @Override
    public Director getDirector() {
        return this.subject.getDirector();
    }
}
