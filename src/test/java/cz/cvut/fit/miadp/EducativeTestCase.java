package cz.cvut.fit.miadp;

import cz.cvut.fit.miadp.mvcgame.command.MoveCannonAUpCmd;
import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.GameModel;
import cz.cvut.fit.miadp.mvcgame.proxy.IGameModel;
import org.junit.Assert;
import org.junit.Test;


public class EducativeTestCase {
    @Test
    public void undoCommandTest( ){
        IGameModel model = new GameModel( );
        int positionBeforeUndoX = model.getCannonAPosition( ).getX( );
        int positionBeforeUndoY = model.getCannonAPosition( ).getY( );
        model.registerCommand( new MoveCannonAUpCmd( model ) );
        model.update( );
        int positionAfterExcecution = model.getCannonAPosition( ).getY( );
        model.undoLastCommand( );
        int positionAfterUndoX = model.getCannonAPosition( ).getX( );
        int positionAfterUndoY = model.getCannonAPosition( ).getY( );
        Assert.assertEquals( positionBeforeUndoY, positionAfterExcecution + MvcGameConfig.MOVE_STEP );
        Assert.assertEquals( positionBeforeUndoX, positionAfterUndoX );
        Assert.assertEquals( positionBeforeUndoY, positionAfterUndoY );
    }
}
