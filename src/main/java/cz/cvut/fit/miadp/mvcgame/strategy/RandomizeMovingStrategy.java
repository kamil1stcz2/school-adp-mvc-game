package cz.cvut.fit.miadp.mvcgame.strategy;

import cz.cvut.fit.miadp.mvcgame.model.Vector;
import cz.cvut.fit.miadp.mvcgame.model.objects.AbstractMissile;

import java.util.Random;

public class RandomizeMovingStrategy implements IMovingStrategy {

    @Override
    public void updatePosition(AbstractMissile missile) {
        Random r = new Random();
        double modifier = r.nextDouble() * 2; //random number between 0 and 2

        double initAngle = modifier * missile.getInitAngle( );
        double initVelocity = modifier * missile.getInitVelocity( );
        missile.setInitVelocity((int)(initVelocity+1));
        missile.setInitAngle((int)(initAngle+1));

        int dX = ( int )( initVelocity *  Math.abs(Math.cos( initAngle )) );
        int dY = ( int )( initVelocity *  Math.sin( initAngle ) );

        missile.move( new Vector( dX, dY ) );
    }

    @Override
    public String getStrategyName() {
        return "RandomizeMovingStrategy";
    }
}
