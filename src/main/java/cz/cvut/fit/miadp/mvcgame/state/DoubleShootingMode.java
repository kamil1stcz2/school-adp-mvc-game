package cz.cvut.fit.miadp.mvcgame.state;

import cz.cvut.fit.miadp.mvcgame.model.objects.AbstractCannon;

public class DoubleShootingMode implements IShootingMode  {
    @Override
    public void shoot(AbstractCannon cannon) {
        cannon.aimUp( );
        cannon.primitiveShoot( );
        cannon.aimDown( );
        cannon.aimDown( );
        cannon.primitiveShoot( );
        cannon.aimUp( );
    }

    @Override
    public String getName() {
        return "DoubleShootingMode";
    }
}
