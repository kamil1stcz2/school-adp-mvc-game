package cz.cvut.fit.miadp.mvcgame.command;

import cz.cvut.fit.miadp.mvcgame.proxy.IGameModel;

public class CannonAPowerUpCmd extends AbstractGameCommand {

    public CannonAPowerUpCmd(IGameModel model) {
        this.subject = model;
    }

    @Override
    protected void execute() {
        this.subject.cannonAPowerUp();
    }
}
