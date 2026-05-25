package cz.cvut.fit.miadp.mvcgame.iterator;

import cz.cvut.fit.miadp.mvcgame.bridge.IGameGraphics;
import cz.cvut.fit.miadp.mvcgame.strategy.IMovingStrategy;

public interface ITrajectory {

    public void drawTrajectory(IGameGraphics gr);
    public int getTrajectoryStep();
    public void constructTrajectory(IMovingStrategy strategy);
}
