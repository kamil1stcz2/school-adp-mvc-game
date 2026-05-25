package cz.cvut.fit.miadp.mvcgame.builder;

import cz.cvut.fit.miadp.mvcgame.abstractfactory.IGameObjectFactory;
import cz.cvut.fit.miadp.mvcgame.model.objects.AbstractEnemy;

import java.util.List;

public interface Builder {
    public void reset();
    public void buildLevel1(IGameObjectFactory factory);
    public void buildLevel2(IGameObjectFactory factory);
    public List<AbstractEnemy> getEnemiesList();
    public String getLevelName();
}
