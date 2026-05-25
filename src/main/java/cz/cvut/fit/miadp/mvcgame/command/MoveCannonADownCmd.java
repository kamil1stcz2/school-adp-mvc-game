package cz.cvut.fit.miadp.mvcgame.command;

import cz.cvut.fit.miadp.mvcgame.proxy.IGameModel;

public class MoveCannonADownCmd extends AbstractGameCommand {

    public MoveCannonADownCmd(IGameModel model ) {
        this.subject = model;
    }

    @Override
    protected void execute() {
        this.subject.moveCannonADown();
    }
}
