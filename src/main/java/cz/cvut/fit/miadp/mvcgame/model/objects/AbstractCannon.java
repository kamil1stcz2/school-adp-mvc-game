package cz.cvut.fit.miadp.mvcgame.model.objects;

import cz.cvut.fit.miadp.mvcgame.abstractfactory.IGameObjectFactory;
import cz.cvut.fit.miadp.mvcgame.state.DoubleShootingMode;
import cz.cvut.fit.miadp.mvcgame.state.DynamicShootingMode;
import cz.cvut.fit.miadp.mvcgame.state.IShootingMode;
import cz.cvut.fit.miadp.mvcgame.state.SingleShootingMode;
import cz.cvut.fit.miadp.mvcgame.strategy.*;
import java.util.List;

public abstract class AbstractCannon extends GameObject {

    protected List<AbstractMissile> shootingBatch;
    protected IGameObjectFactory igoFactory;

    public IGameObjectFactory getIgoFactory() {
        return igoFactory;
    }

    protected int delay;
    protected long lastShotMs;

    protected boolean movingDown;

    public boolean isMovingDown() {
        return movingDown;
    }

    public void setMovingDown(boolean movingDown) {
        this.movingDown = movingDown;
    }

    protected double angle;
    protected int power;

    public void setAngle(double angle) {
        this.angle = angle;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public double getAngle() {
        return angle;
    }

    public int getPower() {
        return power;
    }

    public abstract void moveUp();

    public abstract void moveDown();

    public abstract void aimUp( );
    public abstract void aimDown( );
    public abstract void powerUp( );
    public abstract void powerDown( );
    public abstract List<AbstractMissile> shoot( );
    public abstract void primitiveShoot();

    /*==========================================================*/

    protected IShootingMode shootingMode;
    protected IShootingMode SINGLE_SHOOTING_MODE = new SingleShootingMode( );
    protected IShootingMode DOUBLE_SHOOTING_MODE = new DoubleShootingMode( );
    protected DynamicShootingMode DYNAMIC_SHOOTING_MODE_TEMP = new DynamicShootingMode( );
    protected IShootingMode DYNAMIC_SHOOTING_MODE = DYNAMIC_SHOOTING_MODE_TEMP;

    public IShootingMode getShootingMode() {
        return shootingMode;
    }

    public void setShootingModeByName(String name, int shotCount) {
        switch (name) {
            case "SingleShootingMode":
                this.shootingMode = SINGLE_SHOOTING_MODE;
                break;
            case "DoubleShootingMode":
                this.shootingMode = DOUBLE_SHOOTING_MODE;
                break;
            case "DynamicShootingMode":
                DYNAMIC_SHOOTING_MODE_TEMP.setShotsCount(shotCount);
                this.shootingMode = DYNAMIC_SHOOTING_MODE_TEMP;
                break;
        }
    }

    public void toggleShootingMode( ) {
        if( this.shootingMode instanceof SingleShootingMode ){
            this.shootingMode = DOUBLE_SHOOTING_MODE;
        }
        else if( this.shootingMode instanceof DoubleShootingMode ) {
            this.shootingMode = DYNAMIC_SHOOTING_MODE;
        }
        else if (this.shootingMode instanceof DynamicShootingMode) {
            this.shootingMode = SINGLE_SHOOTING_MODE;
        }
    }

    public void increaseDynamicShoot() {
        DYNAMIC_SHOOTING_MODE_TEMP.increaseShot();
        DYNAMIC_SHOOTING_MODE = DYNAMIC_SHOOTING_MODE_TEMP;
    }

    public void decreaseDynamicShoot() {
        DYNAMIC_SHOOTING_MODE_TEMP.decreaseShot();
        DYNAMIC_SHOOTING_MODE = DYNAMIC_SHOOTING_MODE_TEMP;
    }

    /*==========================================================*/

    protected IMovingStrategy movingStrategy;
    public IMovingStrategy getMovingStrategy() {
        return movingStrategy;
    }

    /*protected ITrajectory trajectory;
    public ITrajectory getTrajectory() { return trajectory; }*/

    public void setMovingStrategyByName(String name) {
        switch (name) {
            case "RealisticMovingStrategy":
                this.movingStrategy = new RealisticMovingStrategy( );
                break;
            case "SinusMovingStrategy":
                this.movingStrategy = new SinusMovingStrategy( );
                break;
            case "RandomizeMovingStrategy":
                this.movingStrategy = new RandomizeMovingStrategy( );
                break;
            case "SimpleMovingStrategy":
                this.movingStrategy = new SimpleMovingStrategy( );
                //this.trajectory = new SimpleTrajectory(this);
                break;
        }
    }

    public void toggleMovingStrategy( ) {
        if ( this.movingStrategy instanceof SimpleMovingStrategy) {
            this.movingStrategy = new RealisticMovingStrategy( );
        }
        else if ( this.movingStrategy instanceof RealisticMovingStrategy ){
            this.movingStrategy = new SinusMovingStrategy( );
        }
        else if ( this.movingStrategy instanceof SinusMovingStrategy ){
            this.movingStrategy = new RandomizeMovingStrategy( );
        }
        else if ( this.movingStrategy instanceof RandomizeMovingStrategy ){
            this.movingStrategy = new SimpleMovingStrategy( );
            //this.trajectory = new SimpleTrajectory(this);
        }
    }

}
