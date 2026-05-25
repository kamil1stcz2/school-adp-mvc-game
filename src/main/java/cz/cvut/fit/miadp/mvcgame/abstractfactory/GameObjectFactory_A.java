package cz.cvut.fit.miadp.mvcgame.abstractfactory;

import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.model.objects.AbstractEnemy;
import cz.cvut.fit.miadp.mvcgame.model.objects.enemies.EnemyVertical;
import cz.cvut.fit.miadp.mvcgame.model.objects.enemies.EnemyHorizontal;
import cz.cvut.fit.miadp.mvcgame.model.objects.enemies.StaticEnemy;
import cz.cvut.fit.miadp.mvcgame.model.objects.modelA.Cannon_A;
import cz.cvut.fit.miadp.mvcgame.model.objects.modelA.Missile_A;
import cz.cvut.fit.miadp.mvcgame.prototype.PositionCloner;
import cz.cvut.fit.miadp.mvcgame.proxy.IGameModel;

public class GameObjectFactory_A implements IGameObjectFactory {

    private IGameModel model;
    private PositionCloner positionCloner;

    public GameObjectFactory_A( IGameModel model ){
        this.model = model;
        this.positionCloner = null;
    }

    @Override
    public Cannon_A createCannon() {
        return new Cannon_A(new Position(MvcGameConfig.CANNON_POSITION_X,MvcGameConfig.CANNON_POSITION_Y - 50),this);
    }

    @Override
    public Missile_A createMissile(double initAngle, int initSpeed) {
        this.positionCloner = new PositionCloner(this.model.getCannonAPosition());
        Position missilePosition = positionCloner.Clone();
        return new Missile_A(
                missilePosition,
                initAngle,
                initSpeed,
                this.model.getCannonAMovingStrategy()
        );
    }

    @Override
    public AbstractEnemy createStaticEnemy(int x, int y) {
        this.positionCloner = new PositionCloner(new Position(x,y));
        Position enemyPosition = positionCloner.Clone();
        return new StaticEnemy(enemyPosition,this);
    }

    @Override
    public AbstractEnemy createMovingEnemy(int x, int y) {
        this.positionCloner = new PositionCloner(new Position(x,y));
        Position enemyPosition = positionCloner.Clone();
        return new EnemyVertical(enemyPosition,this);
    }

    @Override
    public AbstractEnemy createMovingEnemy2(int x, int y) {
        this.positionCloner = new PositionCloner(new Position(x,y));
        Position enemyPosition = positionCloner.Clone();
        return new EnemyHorizontal(enemyPosition,this);
    }
}
