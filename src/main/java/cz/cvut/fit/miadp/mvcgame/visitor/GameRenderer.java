package cz.cvut.fit.miadp.mvcgame.visitor;

import cz.cvut.fit.miadp.mvcgame.bridge.IGameGraphics;
import cz.cvut.fit.miadp.mvcgame.model.objects.AbstractCannon;
import cz.cvut.fit.miadp.mvcgame.model.objects.AbstractEnemy;
import cz.cvut.fit.miadp.mvcgame.model.objects.AbstractMissile;
import cz.cvut.fit.miadp.mvcgame.model.objects.enemies.EnemyVertical;
import cz.cvut.fit.miadp.mvcgame.model.objects.enemies.EnemyHorizontal;
import cz.cvut.fit.miadp.mvcgame.model.objects.enemies.StaticEnemy;

public class GameRenderer implements IVisitor {

    private IGameGraphics gr;

    public void setGr(IGameGraphics gr) {
        this.gr = gr;
    }

    public GameRenderer() {
    }

    @Override
    public void visitCannonA(AbstractCannon cannon) {
        this.gr.drawImage("images/cannonA.png",
                cannon.getPosition());
    }

    @Override
    public void visitMissileA(AbstractMissile missile) {
        this.gr.drawImage("images/missile1A_shrink.png",
                missile.getPosition());
    }

    @Override
    public void visitCannonB(AbstractCannon cannon) {
        this.gr.drawImage("images/cannonB.png",
                cannon.getPosition());
    }

    @Override
    public void visitMissileB(AbstractMissile missile) {
        this.gr.drawImage("images/missile1B_shrink.png",
                missile.getPosition());
    }

    @Override
    public void visitEnemy(AbstractEnemy enemy) {
        if (enemy instanceof StaticEnemy) {
            this.gr.drawImage("images/soldier_small.png",
                    enemy.getPosition());
        } else if (enemy instanceof EnemyVertical) {
            this.gr.drawImage("images/tank_small.png",
                    enemy.getPosition());
        } else if (enemy instanceof EnemyHorizontal) {
            this.gr.drawImage("images/ship_small.png",
                    enemy.getPosition());
        } else {
            this.gr.drawImage("images/enemy1.png",
                    enemy.getPosition());
        }
    }

    public boolean checkCollision(AbstractEnemy enemy, AbstractMissile missile) {
        return this.gr.checkCollision(enemy,missile);
    }
}
