package cz.cvut.fit.miadp;

import cz.cvut.fit.miadp.mvcgame.abstractfactory.GameObjectFactory_A;
import cz.cvut.fit.miadp.mvcgame.abstractfactory.GameObjectFactory_B;
import cz.cvut.fit.miadp.mvcgame.abstractfactory.IGameObjectFactory;
import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.GameModel;
import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.model.objects.AbstractCannon;
import cz.cvut.fit.miadp.mvcgame.model.objects.AbstractMissile;
import cz.cvut.fit.miadp.mvcgame.proxy.IGameModel;
import cz.cvut.fit.miadp.mvcgame.strategy.SimpleMovingStrategy;
import org.junit.Assert;
import org.junit.Test;


public class CreateCannonTest {

    @Test
    public void createCannon( ){
        IGameModel model = new GameModel( );
        IGameObjectFactory goFact = new GameObjectFactory_B( model );
        AbstractCannon cannon = goFact.createCannon();
        Assert.assertEquals( cannon.getPosition( ).getX( ), MvcGameConfig.CANNON_POSITION_X );
        Assert.assertEquals( cannon.getPosition( ).getY( ), MvcGameConfig.LEFT_TOP_ENEMY_SPAWN_Y );
    }
}
