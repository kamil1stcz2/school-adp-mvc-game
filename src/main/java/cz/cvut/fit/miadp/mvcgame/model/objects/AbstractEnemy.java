package cz.cvut.fit.miadp.mvcgame.model.objects;

import cz.cvut.fit.miadp.mvcgame.abstractfactory.IGameObjectFactory;
import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.Position;

import java.util.Random;

public abstract class AbstractEnemy extends LifetimeLimitedGameObject {

    protected IGameObjectFactory igoFactory;

    protected AbstractEnemy(Position position) {
        super(position);
    }

    public int getRandomNumberInRange(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }

    public Position getNewPosition() {
        int x = getRandomNumberInRange(MvcGameConfig.LEFT_TOP_ENEMY_SPAWN_X,MvcGameConfig.RIGHT_BOT_ENEMY_SPAWN_X);
        int y = getRandomNumberInRange(MvcGameConfig.LEFT_TOP_ENEMY_SPAWN_Y,MvcGameConfig.RIGHT_BOT_ENEMY_SPAWN_Y);
        return new Position(x,y);
    }

    public void changePosition(Position pos) {
        this.position = pos;
    }

}
