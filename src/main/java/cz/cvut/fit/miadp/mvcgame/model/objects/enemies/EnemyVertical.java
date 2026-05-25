package cz.cvut.fit.miadp.mvcgame.model.objects.enemies;

import cz.cvut.fit.miadp.mvcgame.abstractfactory.IGameObjectFactory;
import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.factorymethod.MovingVertical;
import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.model.Vector;
import cz.cvut.fit.miadp.mvcgame.model.objects.AbstractEnemy;
import cz.cvut.fit.miadp.mvcgame.visitor.IVisitor;

public class EnemyVertical extends AbstractEnemy {

    MovingVertical moving;

    public EnemyVertical(Position position, IGameObjectFactory factory) {
        super(position);
        this.igoFactory = factory;
        this.moving = new MovingVertical(this);
    }

    public void makeStep() {
        this.moving.planPath();
    }

    @Override
    public Position getNewPosition() {
        int x = getRandomNumberInRange(MvcGameConfig.LEFT_TOP_ENEMY_SPAWN_X,MvcGameConfig.RIGHT_BOT_ENEMY_SPAWN_X);
        int y = getRandomNumberInRange(MvcGameConfig.LEFT_TOP_ENEMY_SPAWN_Y+MvcGameConfig.ENEMY_MOVING_LIMIT,MvcGameConfig.RIGHT_BOT_ENEMY_SPAWN_Y-MvcGameConfig.ENEMY_MOVING_LIMIT);
        return new Position(x,y);
    }


    @Override
    public void acceptVisitor(IVisitor visitor) {
        visitor.visitEnemy(this);
    }
}
