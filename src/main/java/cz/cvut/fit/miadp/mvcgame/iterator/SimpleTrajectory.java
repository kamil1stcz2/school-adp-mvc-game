package cz.cvut.fit.miadp.mvcgame.iterator;

import cz.cvut.fit.miadp.mvcgame.abstractfactory.IGameObjectFactory;
import cz.cvut.fit.miadp.mvcgame.bridge.IGameGraphics;
import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.model.objects.AbstractCannon;
import cz.cvut.fit.miadp.mvcgame.model.objects.AbstractMissile;
import cz.cvut.fit.miadp.mvcgame.proxy.IGameModel;
import cz.cvut.fit.miadp.mvcgame.strategy.IMovingStrategy;

import java.util.ArrayList;
import java.util.List;

public class SimpleTrajectory implements ITrajectory {

    private List<Position> trajectory;
    private AbstractCannon cannon;
    private long counter;

    public SimpleTrajectory (AbstractCannon cannon) {
        this.cannon = cannon;
        this.trajectory = new ArrayList<>();
        this.counter = 0;
    }


    @Override
    public void drawTrajectory(IGameGraphics gr) {
        for(Position pos: trajectory) {
            gr.drawRectangle(new Position(pos.getX()+5,pos.getY()+5),pos);
        }
    }

    @Override
    public int getTrajectoryStep() {
        return trajectory.size();
    }

    @Override
    public void constructTrajectory(IMovingStrategy strategy) {
        this.trajectory.clear();
        this.counter = 0;
        AbstractMissile testingMissile = this.cannon.getIgoFactory().createMissile(this.cannon.getAngle(),this.cannon.getPower());
        while (testingMissile.getPosition().getX() < MvcGameConfig.MAX_X &&
                testingMissile.getPosition().getY() < MvcGameConfig.MAX_Y &&
                testingMissile.getPosition().getX() > 0 &&
                testingMissile.getPosition().getX() > 0) {
            this.counter++;
            if (this.counter % 100000 == 0) {
                this.trajectory.add(testingMissile.getPosition());
            }
            strategy.updatePosition(testingMissile);
        }
    }
}
