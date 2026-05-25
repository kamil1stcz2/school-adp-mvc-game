package cz.cvut.fit.miadp.mvcgame.model.objects.modelB;

import cz.cvut.fit.miadp.mvcgame.abstractfactory.IGameObjectFactory;
import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.model.Vector;
import cz.cvut.fit.miadp.mvcgame.model.objects.AbstractCannon;
import cz.cvut.fit.miadp.mvcgame.model.objects.AbstractMissile;
import cz.cvut.fit.miadp.mvcgame.strategy.SimpleMovingStrategy;
import cz.cvut.fit.miadp.mvcgame.visitor.IVisitor;

import java.util.ArrayList;
import java.util.List;

public class Cannon_B extends AbstractCannon {

    public Cannon_B(Position initPosition, IGameObjectFactory factory) {
        this.position = initPosition;
        this.igoFactory = factory;
        this.delay = MvcGameConfig.CANNON_B_DELAY;
        this.lastShotMs = System.currentTimeMillis() - delay - 1;
        this.power = MvcGameConfig.INIT_POWER;
        this.angle = MvcGameConfig.INIT_ANGLE;
        this.shootingBatch = new ArrayList<AbstractMissile>();
        this.shootingMode = DOUBLE_SHOOTING_MODE;
        this.movingStrategy = new SimpleMovingStrategy( );
        this.movingDown = true;
    }

    @Override
    public void moveUp() {
        this.move(new Vector(0, -1 * MvcGameConfig.MOVE_STEP));
    }

    @Override
    public void moveDown() {
        this.move(new Vector(0, MvcGameConfig.MOVE_STEP));
    }

    @Override
    public void aimUp() {
        this.angle -= MvcGameConfig.ANGLE_STEP;
    }

    @Override
    public void aimDown() {
        this.angle += MvcGameConfig.ANGLE_STEP;
    }

    @Override
    public void powerUp() {
        this.power += MvcGameConfig.POWER_STEP;
    }

    @Override
    public void powerDown() {
        this.power -= MvcGameConfig.POWER_STEP;
    }

    @Override
    public List<AbstractMissile> shoot( ) {
        this.shootingBatch.clear( );
        this.shootingMode.shoot( this );
        return this.shootingBatch;
    }

    @Override
    public void primitiveShoot() {
        this.shootingBatch.add(
                this.igoFactory.createMissile(
                        this.angle,
                        this.power
                )
        );
    }

    @Override
    public void acceptVisitor(IVisitor visitor) {
        visitor.visitCannonB(this);
    }

}
