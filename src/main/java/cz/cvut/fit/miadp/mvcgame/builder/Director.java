package cz.cvut.fit.miadp.mvcgame.builder;

import cz.cvut.fit.miadp.mvcgame.abstractfactory.IGameObjectFactory;

public class Director {

    private Builder builder;

    public Director (Builder builder) {
        this.builder = builder;
    }

    public void changeBuilder(Builder builder) {
        this.builder = builder;
    }

    public void make(String type) {

    }

    public Builder getBuilder() {
        return this.builder;
    }

}
