package cz.cvut.fit.miadp;

import cz.cvut.fit.miadp.mvcgame.abstractfactory.GameObjectFactory_A;
import cz.cvut.fit.miadp.mvcgame.builder.BuildLevel2;
import cz.cvut.fit.miadp.mvcgame.builder.Director;
import cz.cvut.fit.miadp.mvcgame.model.GameModel;
import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.proxy.IGameModel;
import cz.cvut.fit.miadp.mvcgame.strategy.SimpleMovingStrategy;
import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CannonShootTest {

    @Test
    public void cannonShoot( ){
        IGameModel model = mock( GameModel.class );
        when( model.getGoFactoryA()).thenReturn( new GameObjectFactory_A(model));
        BuildLevel2 bl2 = new BuildLevel2(model.getGoFactoryA());
        bl2.buildLevel2(model.getGoFactoryA());
        Assert.assertNotNull(bl2.getResult());
    }
}
