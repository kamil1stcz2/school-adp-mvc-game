package cz.cvut.fit.miadp;

import cz.cvut.fit.miadp.mvcgame.abstractfactory.GameObjectFactory_A;
import cz.cvut.fit.miadp.mvcgame.abstractfactory.IGameObjectFactory;
import cz.cvut.fit.miadp.mvcgame.command.MoveCannonAUpCmd;
import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.GameModel;
import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.model.objects.AbstractMissile;
import cz.cvut.fit.miadp.mvcgame.proxy.IGameModel;
import cz.cvut.fit.miadp.mvcgame.strategy.SimpleMovingStrategy;
import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MoveCannonTest {

    @Test
    public void moveCannon( ){
        IGameModel model = new GameModel( );
        int positionBeforeUndoX = model.getCannonAPosition( ).getX( );
        int positionBeforeUndoY = model.getCannonAPosition( ).getY( );
        model.moveCannonAUp();
        int positionAfterUndoX = model.getCannonAPosition( ).getX( );
        int positionAfterUndoY = model.getCannonAPosition( ).getY( );
        Assert.assertEquals( positionBeforeUndoX, MvcGameConfig.CANNON_POSITION_X);
        Assert.assertEquals( positionBeforeUndoY, MvcGameConfig.CANNON_POSITION_Y - 50 );
        Assert.assertEquals( positionAfterUndoX, MvcGameConfig.CANNON_POSITION_X );
        Assert.assertEquals( positionAfterUndoY, (MvcGameConfig.CANNON_POSITION_Y - 50) + (-1 * MvcGameConfig.MOVE_STEP) );
    }
}
