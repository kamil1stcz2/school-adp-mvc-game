package cz.cvut.fit.miadp.mvcgame.model.objects.modelA;

import cz.cvut.fit.miadp.mvcgame.MvcGame;
import cz.cvut.fit.miadp.mvcgame.abstractfactory.GameObjectFactory_A;
import cz.cvut.fit.miadp.mvcgame.abstractfactory.IGameObjectFactory;
import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.model.Vector;
import cz.cvut.fit.miadp.mvcgame.model.objects.AbstractCannon;
import cz.cvut.fit.miadp.mvcgame.model.objects.AbstractMissile;
import cz.cvut.fit.miadp.mvcgame.strategy.SimpleMovingStrategy;
import cz.cvut.fit.miadp.mvcgame.visitor.IVisitor;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalField;
import java.util.ArrayList;
import java.util.List;

public class Cannon_A extends AbstractCannon {

    public Cannon_A(Position initPosition, IGameObjectFactory factory) {
        this.position = initPosition;
        this.igoFactory = factory;
        this.delay = MvcGameConfig.CANNON_A_DELAY;
        this.lastShotMs = System.currentTimeMillis() - delay - 1;
        this.power = MvcGameConfig.INIT_POWER;
        this.angle = MvcGameConfig.INIT_ANGLE;
        this.shootingBatch = new ArrayList<AbstractMissile>();
        this.shootingMode = SINGLE_SHOOTING_MODE;
        this.movingStrategy = new SimpleMovingStrategy( );
    }

    @Override
    public void acceptVisitor(IVisitor visitor) {
        visitor.visitCannonA(this);
    }

    @Override
    public void moveUp() {
        if (position.getY() > 0) {
            this.move(new Vector(0, -1 * MvcGameConfig.MOVE_STEP));
        }
    }

    @Override
    public void moveDown() {
        if (position.getY() < 670) {
            this.move(new Vector(0, MvcGameConfig.MOVE_STEP));
        }
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
        if (this.power < 200) {
            this.power += MvcGameConfig.POWER_STEP;
        }
    }

    @Override
    public void powerDown() {
        if (this.power > 0) {
            this.power -= MvcGameConfig.POWER_STEP;
        }
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

}
