package cz.cvut.fit.miadp.mvcgame.command;

import cz.cvut.fit.miadp.mvcgame.proxy.IGameModel;

public class DecreaseDynamicShootCounterCmd extends AbstractGameCommand {

    public DecreaseDynamicShootCounterCmd(IGameModel model) {
        this.subject = model;
    }

    @Override
    protected void execute() {
        this.subject.decreaseDynamicShootCounterA();
    }
}
