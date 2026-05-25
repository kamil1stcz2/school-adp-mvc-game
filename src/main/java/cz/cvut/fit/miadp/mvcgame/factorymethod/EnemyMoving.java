package cz.cvut.fit.miadp.mvcgame.factorymethod;

import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.model.objects.AbstractEnemy;

public abstract class EnemyMoving {

    AbstractEnemy enemy;

    public EnemyMoving (AbstractEnemy enemy) {
        this.enemy = enemy;
    }

    public abstract void planPath();

}
