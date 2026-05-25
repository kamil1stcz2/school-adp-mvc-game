package cz.cvut.fit.miadp.mvcgame.abstractfactory;

import cz.cvut.fit.miadp.mvcgame.model.objects.AbstractCannon;
import cz.cvut.fit.miadp.mvcgame.model.objects.AbstractEnemy;
import cz.cvut.fit.miadp.mvcgame.model.objects.AbstractMissile;

public interface IGameObjectFactory {

    AbstractCannon createCannon();
    AbstractMissile createMissile(double initAngle, int initSpeed);
    AbstractEnemy createStaticEnemy(int x, int y);
    AbstractEnemy createMovingEnemy(int x, int y);
    AbstractEnemy createMovingEnemy2(int x, int y);
}
