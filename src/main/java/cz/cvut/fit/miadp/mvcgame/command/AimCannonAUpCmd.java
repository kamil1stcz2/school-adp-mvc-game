package cz.cvut.fit.miadp.mvcgame.command;

import cz.cvut.fit.miadp.mvcgame.proxy.IGameModel;

public class AimCannonAUpCmd extends AbstractGameCommand {

    public AimCannonAUpCmd(IGameModel model) {
        this.subject = model;
    }

    @Override
    protected void execute() {
        this.subject.aimCannonAUp();
    }
}
