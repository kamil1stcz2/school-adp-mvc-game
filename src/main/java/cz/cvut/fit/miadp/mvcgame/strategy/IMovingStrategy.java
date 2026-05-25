package cz.cvut.fit.miadp.mvcgame.strategy;

import cz.cvut.fit.miadp.mvcgame.model.objects.AbstractMissile;

public interface IMovingStrategy {

    public void updatePosition( AbstractMissile missile );

    public String getStrategyName();

}
