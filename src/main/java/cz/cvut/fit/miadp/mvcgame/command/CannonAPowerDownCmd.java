package cz.cvut.fit.miadp.mvcgame.command;

import cz.cvut.fit.miadp.mvcgame.proxy.IGameModel;

public class CannonAPowerDownCmd extends AbstractGameCommand {

    public CannonAPowerDownCmd(IGameModel model) {
        this.subject = model;
    }

    @Override
    protected void execute() {
        this.subject.cannonAPowerDown();
    }
}
