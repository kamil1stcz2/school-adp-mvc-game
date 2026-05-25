package cz.cvut.fit.miadp.mvcgame.state;

import cz.cvut.fit.miadp.mvcgame.model.objects.AbstractCannon;

public class SingleShootingMode implements IShootingMode  {
    @Override
    public void shoot(AbstractCannon cannon) {
        cannon.primitiveShoot( );
    }

    @Override
    public String getName() {
        return "SingleShootingMode";
    }
}
