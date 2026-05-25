package cz.cvut.fit.miadp;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import cz.cvut.fit.miadp.mvcgame.abstractfactory.IGameObjectFactory;
import cz.cvut.fit.miadp.mvcgame.model.GameModel;
import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.model.objects.AbstractMissile;
import cz.cvut.fit.miadp.mvcgame.strategy.SimpleMovingStrategy;
import org.junit.Assert;
import org.junit.Test;

import cz.cvut.fit.miadp.mvcgame.proxy.IGameModel;
import cz.cvut.fit.miadp.mvcgame.abstractfactory.GameObjectFactory_A;

public class EducativeMockTestCase {
    @Test
    public void createMissile( ){

        IGameModel model = mock( GameModel.class );
        when( model.getCannonAPosition( ) ).thenReturn( new Position( 555, 666 ) );
        when( model.getCannonAMovingStrategy() ).thenReturn( new SimpleMovingStrategy() );
        IGameObjectFactory goFact = new GameObjectFactory_A( model );
        AbstractMissile missile = goFact.createMissile(0, 0 );
        Assert.assertEquals( missile.getPosition( ).getX( ), 555 );
        Assert.assertEquals( missile.getPosition( ).getY( ), 666 );
    }


}
