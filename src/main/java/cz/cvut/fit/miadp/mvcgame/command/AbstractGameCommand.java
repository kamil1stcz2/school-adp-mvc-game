package cz.cvut.fit.miadp.mvcgame.command;

import cz.cvut.fit.miadp.mvcgame.proxy.IGameModel;

public abstract class AbstractGameCommand {

    protected IGameModel subject;
    protected Object memento;

    protected abstract void execute();

    public void doExecute() {
        this.memento = this.subject.createMemento();
        this.execute();
    }

    public void unExecute() {
        this.subject.setMemento(memento);
    }
}
