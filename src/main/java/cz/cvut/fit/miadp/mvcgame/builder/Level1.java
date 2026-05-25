package cz.cvut.fit.miadp.mvcgame.builder;

import com.sun.javafx.collections.ArrayListenerHelper;
import cz.cvut.fit.miadp.mvcgame.abstractfactory.IGameObjectFactory;
import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.objects.AbstractEnemy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Level1 {

    AbstractEnemy staticEnemy;

    private int getRandomNumberInRange(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }

    public Level1(IGameObjectFactory factory) {
        int x = getRandomNumberInRange(MvcGameConfig.LEFT_TOP_ENEMY_SPAWN_X,MvcGameConfig.RIGHT_BOT_ENEMY_SPAWN_X);
        int y = getRandomNumberInRange(MvcGameConfig.LEFT_TOP_ENEMY_SPAWN_Y,MvcGameConfig.RIGHT_BOT_ENEMY_SPAWN_Y);
        this.staticEnemy = factory.createStaticEnemy(x,y);
    }

    public List<AbstractEnemy> getEnemies() {
        List<AbstractEnemy> list = new ArrayList<>();
        list.add(staticEnemy);
        return list;
    }

}
