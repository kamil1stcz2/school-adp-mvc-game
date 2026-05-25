package cz.cvut.fit.miadp.mvcgame.visitor;

import cz.cvut.fit.miadp.mvcgame.model.objects.AbstractCannon;
import cz.cvut.fit.miadp.mvcgame.model.objects.AbstractEnemy;
import cz.cvut.fit.miadp.mvcgame.model.objects.AbstractMissile;

public interface IVisitor {

    public void visitCannonA(AbstractCannon cannon);
    public void visitMissileA(AbstractMissile missile);
    public void visitCannonB(AbstractCannon cannon);
    public void visitMissileB(AbstractMissile missile);
    public void visitEnemy(AbstractEnemy enemy);

}
