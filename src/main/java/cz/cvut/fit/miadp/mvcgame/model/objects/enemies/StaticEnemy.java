package cz.cvut.fit.miadp.mvcgame.model.objects.enemies;

import cz.cvut.fit.miadp.mvcgame.abstractfactory.IGameObjectFactory;
import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.model.objects.AbstractEnemy;
import cz.cvut.fit.miadp.mvcgame.visitor.IVisitor;

import java.util.Random;

public class StaticEnemy extends AbstractEnemy {

    public StaticEnemy(Position position,IGameObjectFactory factory) {
        super(position);
        this.igoFactory = factory;
    }

    @Override
    public void acceptVisitor(IVisitor visitor) {
        visitor.visitEnemy(this);
    }
}
