package cz.cvut.fit.miadp.mvcgame.command;

import cz.cvut.fit.miadp.mvcgame.proxy.IGameModel;

public class IncreaseDynamicShootCounterCmd extends AbstractGameCommand {

    public IncreaseDynamicShootCounterCmd(IGameModel model) {
        this.subject = model;
    }

    @Override
    protected void execute() {
        this.subject.increaseDynamicShootCounterA();
    }
}
