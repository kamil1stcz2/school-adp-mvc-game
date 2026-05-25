package cz.cvut.fit.miadp.mvcgame.command;

import cz.cvut.fit.miadp.mvcgame.proxy.IGameModel;

public class MoveCannonAUpCmd extends AbstractGameCommand {


    public MoveCannonAUpCmd(IGameModel model ) {
        this.subject = model;
    }

    @Override
    protected void execute() {
        this.subject.moveCannonAUp();
    }
}
