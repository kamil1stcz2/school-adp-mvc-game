package cz.cvut.fit.miadp.mvcgame.factorymethod;

import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.Vector;
import cz.cvut.fit.miadp.mvcgame.model.objects.AbstractEnemy;

public class MovingVertical extends EnemyMoving {

    private boolean returning;
    private int limit;
    private int currentlyMoved;

    public MovingVertical(AbstractEnemy enemy) {
        super(enemy);
        this.currentlyMoved = 0;
        this.limit = MvcGameConfig.ENEMY_MOVING_LIMIT;
        this.returning = false;
    }

    @Override
    public void planPath() {
        if (!this.returning && this.currentlyMoved < limit) {
            this.enemy.move(new Vector(0,1));
            currentlyMoved++;
        }

        if (this.currentlyMoved == limit) {
            this.returning = true;
        }
        if (this.returning && this.currentlyMoved > 0) {
            currentlyMoved--;
            this.enemy.move(new Vector(0,-1));
        }
        if (this.returning && this.currentlyMoved == 0) {
            this.returning = false;
        }
    }
}
