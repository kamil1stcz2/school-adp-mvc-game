package cz.cvut.fit.miadp.mvcgame.strategy;

import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.Vector;
import cz.cvut.fit.miadp.mvcgame.model.objects.AbstractMissile;

public class RealisticMovingStrategy implements IMovingStrategy {
    @Override
    public void updatePosition(AbstractMissile missile) {
        double initAngle = missile.getInitAngle();
        int initVelocity = missile.getInitVelocity();
        long time = missile.getAge() / 100;

        int dX = ( int )( initVelocity * time * Math.cos( initAngle ) );
        int dY = ( int )( initVelocity * time * Math.sin( initAngle ) + ( 0.5 * MvcGameConfig.GRAVITY * time * time) );

        missile.move( new Vector( dX, dY ) );
    }

    @Override
    public String getStrategyName() {
        return "RealisticMovingStrategy";
    }
}
