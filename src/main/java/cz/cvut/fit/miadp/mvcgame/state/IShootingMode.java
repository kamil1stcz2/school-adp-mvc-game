package cz.cvut.fit.miadp.mvcgame.state;

import cz.cvut.fit.miadp.mvcgame.model.objects.AbstractCannon;

public interface IShootingMode {

    public void shoot( AbstractCannon cannon );
    public String getName( );

}
