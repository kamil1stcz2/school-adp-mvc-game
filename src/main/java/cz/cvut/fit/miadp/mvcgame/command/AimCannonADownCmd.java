package cz.cvut.fit.miadp.mvcgame.command;

import cz.cvut.fit.miadp.mvcgame.proxy.IGameModel;

public class AimCannonADownCmd extends AbstractGameCommand {

    public AimCannonADownCmd (IGameModel model) {
        this.subject = model;
    }

    @Override
    protected void execute() {
        this.subject.aimCannonADown();
    }
}
