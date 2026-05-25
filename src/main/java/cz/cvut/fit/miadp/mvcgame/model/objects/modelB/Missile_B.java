package cz.cvut.fit.miadp.mvcgame.model.objects.modelB;

import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.model.Vector;
import cz.cvut.fit.miadp.mvcgame.model.objects.AbstractMissile;
import cz.cvut.fit.miadp.mvcgame.strategy.IMovingStrategy;
import cz.cvut.fit.miadp.mvcgame.visitor.IVisitor;

public class Missile_B extends AbstractMissile {

    public Missile_B(Position initPosition ,double initAngle, int initSpeed, IMovingStrategy strategy) {
        super(initPosition,initAngle,initSpeed,strategy);
        this.position = initPosition;
    }

    @Override
    public void acceptVisitor(IVisitor visitor) {
        visitor.visitMissileB(this);
    }

}
