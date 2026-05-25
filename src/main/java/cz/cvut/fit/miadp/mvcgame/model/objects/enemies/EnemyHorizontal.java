package cz.cvut.fit.miadp.mvcgame.model.objects.enemies;

import cz.cvut.fit.miadp.mvcgame.abstractfactory.IGameObjectFactory;
import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.factorymethod.MovingHorizontal;
import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.model.Vector;
import cz.cvut.fit.miadp.mvcgame.model.objects.AbstractEnemy;
import cz.cvut.fit.miadp.mvcgame.visitor.IVisitor;

public class EnemyHorizontal extends AbstractEnemy {

    MovingHorizontal moving;

    public EnemyHorizontal(Position position, IGameObjectFactory factory) {
        super(position);
        this.igoFactory = factory;
        this.moving = new MovingHorizontal(this);
    }

    public void makeStep() {
        this.moving.planPath();
    }

    @Override
    public Position getNewPosition() {
        int x = getRandomNumberInRange(MvcGameConfig.LEFT_TOP_ENEMY_SPAWN_X+MvcGameConfig.ENEMY_MOVING_LIMIT,MvcGameConfig.RIGHT_BOT_ENEMY_SPAWN_X-MvcGameConfig.ENEMY_MOVING_LIMIT);
        int y = getRandomNumberInRange(MvcGameConfig.LEFT_TOP_ENEMY_SPAWN_Y,MvcGameConfig.RIGHT_BOT_ENEMY_SPAWN_Y);
        return new Position(x,y);
    }

    @Override
    public void acceptVisitor(IVisitor visitor) {
        visitor.visitEnemy(this);
    }
}
