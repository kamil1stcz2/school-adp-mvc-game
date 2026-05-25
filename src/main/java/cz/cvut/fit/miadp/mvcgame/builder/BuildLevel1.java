package cz.cvut.fit.miadp.mvcgame.builder;

import cz.cvut.fit.miadp.mvcgame.abstractfactory.IGameObjectFactory;
import cz.cvut.fit.miadp.mvcgame.model.objects.AbstractEnemy;

import java.util.ArrayList;
import java.util.List;

public class BuildLevel1 implements Builder {

    private Level1 result;

    public BuildLevel1(IGameObjectFactory factory) {
        this.buildLevel1(factory);
    }

    @Override
    public void reset() {

    }

    @Override
    public void buildLevel1(IGameObjectFactory factory) {
        this.result = new Level1(factory);
    }

    @Override
    public void buildLevel2(IGameObjectFactory factory) {

    }

    @Override
    public List<AbstractEnemy> getEnemiesList() {
        return this.result.getEnemies();
    }

    @Override
    public String getLevelName() {
        return "Level 1";
    }

    public Level1 getResult() {
        return this.result;
    }
}
