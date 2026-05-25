package cz.cvut.fit.miadp.mvcgame.abstractfactory;

import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.GameModel;
import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.model.Vector;
import cz.cvut.fit.miadp.mvcgame.model.objects.AbstractCannon;
import cz.cvut.fit.miadp.mvcgame.model.objects.AbstractEnemy;
import cz.cvut.fit.miadp.mvcgame.model.objects.AbstractMissile;
import cz.cvut.fit.miadp.mvcgame.model.objects.modelA.Cannon_A;
import cz.cvut.fit.miadp.mvcgame.model.objects.modelA.Missile_A;
import cz.cvut.fit.miadp.mvcgame.model.objects.modelB.Cannon_B;
import cz.cvut.fit.miadp.mvcgame.model.objects.modelB.Missile_B;
import cz.cvut.fit.miadp.mvcgame.prototype.PositionCloner;
import cz.cvut.fit.miadp.mvcgame.proxy.IGameModel;

public class GameObjectFactory_B implements IGameObjectFactory {

    private IGameModel model;
    private PositionCloner positionCloner;

    public GameObjectFactory_B( IGameModel model ){
        this.model = model;
        this.positionCloner = null;
    }

    @Override
    public Cannon_B createCannon() {
        return new Cannon_B(new Position(MvcGameConfig.CANNON_POSITION_X,MvcGameConfig.LEFT_TOP_ENEMY_SPAWN_Y),this);
    }

    @Override
    public Missile_B createMissile(double initAngle, int initSpeed) {
        this.positionCloner = new PositionCloner(this.model.getCannonB().getPosition());
        Position missilePosition = positionCloner.Clone();
        return new Missile_B(missilePosition, initAngle, initSpeed, this.model.getCannonB().getMovingStrategy());
    }

    @Override
    public AbstractEnemy createStaticEnemy(int x, int y) {
        return null;
    }

    @Override
    public AbstractEnemy createMovingEnemy(int x, int y) {
        return null;
    }

    @Override
    public AbstractEnemy createMovingEnemy2(int x, int y) {
        return null;
    }
}