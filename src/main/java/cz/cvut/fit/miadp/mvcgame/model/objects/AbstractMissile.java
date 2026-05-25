package cz.cvut.fit.miadp.mvcgame.model.objects;

import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.model.Vector;
import cz.cvut.fit.miadp.mvcgame.strategy.IMovingStrategy;

public abstract class AbstractMissile extends LifetimeLimitedGameObject {

    private double initAngle;
    private int initVelocity;

    private IMovingStrategy movingStrategy;

    protected AbstractMissile(Position initialPosition, double initAngle, int initVelocity, IMovingStrategy movingStrategy ) {
        super( initialPosition );
        this.initAngle = initAngle;
        this.initVelocity = initVelocity;
        this.movingStrategy = movingStrategy;
    }

    public void setInitAngle(double initAngle) {
        this.initAngle = initAngle;
    }

    public void setInitVelocity(int initVelocity) {
        this.initVelocity = initVelocity;
    }

    public int getInitVelocity( ){
        return this.initVelocity;
    }

    public double getInitAngle( ) {
        return this.initAngle;
    }

    public void move() {
        this.movingStrategy.updatePosition(this);
    }

}
