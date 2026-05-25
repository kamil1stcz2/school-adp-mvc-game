package cz.cvut.fit.miadp.mvcgame.model.objects.modelA;

import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.model.Vector;
import cz.cvut.fit.miadp.mvcgame.model.objects.AbstractMissile;
import cz.cvut.fit.miadp.mvcgame.strategy.IMovingStrategy;
import cz.cvut.fit.miadp.mvcgame.visitor.IVisitor;

public class Missile_A extends AbstractMissile {

    public Missile_A(Position initialPosition, double initAngle, int initVelocity, IMovingStrategy strategy){
        super( initialPosition, initAngle, initVelocity,strategy);
        this.position = initialPosition;
    }

    @Override
    public void acceptVisitor(IVisitor visitor) {
        visitor.visitMissileA(this);
    }
}
