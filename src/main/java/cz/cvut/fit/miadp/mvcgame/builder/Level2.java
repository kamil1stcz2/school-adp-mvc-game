package cz.cvut.fit.miadp.mvcgame.builder;

import cz.cvut.fit.miadp.mvcgame.abstractfactory.IGameObjectFactory;
import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.objects.AbstractEnemy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Level2 {

    AbstractEnemy staticEnemy;
    AbstractEnemy movingEnemyHorizontal;
    AbstractEnemy movingEnemyVertical;

    private int getRandomNumberInRange(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }

    public Level2(IGameObjectFactory factory) {
        int x1 = getRandomNumberInRange(MvcGameConfig.LEFT_TOP_ENEMY_SPAWN_X,MvcGameConfig.RIGHT_BOT_ENEMY_SPAWN_X);
        int y1 = getRandomNumberInRange(MvcGameConfig.LEFT_TOP_ENEMY_SPAWN_Y,MvcGameConfig.RIGHT_BOT_ENEMY_SPAWN_Y);
        this.staticEnemy = factory.createStaticEnemy(x1,y1);

        int x2 = getRandomNumberInRange(MvcGameConfig.LEFT_TOP_ENEMY_SPAWN_X+MvcGameConfig.ENEMY_MOVING_LIMIT,MvcGameConfig.RIGHT_BOT_ENEMY_SPAWN_X-MvcGameConfig.ENEMY_MOVING_LIMIT);
        int y2 = getRandomNumberInRange(MvcGameConfig.LEFT_TOP_ENEMY_SPAWN_Y,MvcGameConfig.RIGHT_BOT_ENEMY_SPAWN_Y);
        this.movingEnemyHorizontal = factory.createMovingEnemy2(x2,y2);

        int x3 = getRandomNumberInRange(MvcGameConfig.LEFT_TOP_ENEMY_SPAWN_X,MvcGameConfig.RIGHT_BOT_ENEMY_SPAWN_X);
        int y3 = getRandomNumberInRange(MvcGameConfig.LEFT_TOP_ENEMY_SPAWN_Y+MvcGameConfig.ENEMY_MOVING_LIMIT,MvcGameConfig.RIGHT_BOT_ENEMY_SPAWN_Y-MvcGameConfig.ENEMY_MOVING_LIMIT);
        this.movingEnemyVertical = factory.createMovingEnemy(x3,y3);
    }

    public List<AbstractEnemy> getEnemies() {
        List<AbstractEnemy> list = new ArrayList<>();
        list.add(staticEnemy);
        list.add(movingEnemyHorizontal);
        list.add(movingEnemyVertical);
        return list;
    }

}
