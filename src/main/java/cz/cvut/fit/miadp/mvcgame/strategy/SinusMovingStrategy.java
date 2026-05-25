package cz.cvut.fit.miadp.mvcgame.strategy;

import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.Vector;
import cz.cvut.fit.miadp.mvcgame.model.objects.AbstractMissile;


public class SinusMovingStrategy implements IMovingStrategy {

    @Override
    public void updatePosition(AbstractMissile missile) {
        long time = missile.getAge() / 100;

        int dX = MvcGameConfig.MOVE_STEP;
        int dY = ( int )( 15 * Math.sin( dX*time ) );

        missile.move( new Vector( dX, dY ) );

    }

    @Override
    public String getStrategyName() {
        return "SinusMovingStrategy";
    }

}
