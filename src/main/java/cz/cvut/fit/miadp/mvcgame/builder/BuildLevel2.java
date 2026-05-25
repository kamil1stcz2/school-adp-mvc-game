package cz.cvut.fit.miadp.mvcgame.builder;

import cz.cvut.fit.miadp.mvcgame.abstractfactory.IGameObjectFactory;
import cz.cvut.fit.miadp.mvcgame.model.objects.AbstractEnemy;

import java.util.List;

public class BuildLevel2 implements Builder {

    private Level2 result;

    public BuildLevel2(IGameObjectFactory factory) {
        this.buildLevel2(factory);
    }

    @Override
    public void reset() {

    }

    @Override
    public void buildLevel1(IGameObjectFactory factory) {

    }

    @Override
    public void buildLevel2(IGameObjectFactory factory) {
        this.result = new Level2(factory);
    }

    @Override
    public List<AbstractEnemy> getEnemiesList() {
        return this.result.getEnemies();
    }

    @Override
    public String getLevelName() {
        return "Level 2";
    }

    public Level2 getResult() {
        return this.result;
    }
}
