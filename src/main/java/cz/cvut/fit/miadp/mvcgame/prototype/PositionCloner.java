package cz.cvut.fit.miadp.mvcgame.prototype;

import cz.cvut.fit.miadp.mvcgame.command.AbstractGameCommand;
import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.model.objects.GameObject;

import java.util.Arrays;
import java.util.List;

public class PositionCloner implements Cloner {

    Position position;

    @Override
    public Position Clone() {
        return new Position(position.getX(),position.getY());
    }

    public PositionCloner(Position position) {
        this.position = position;
    }

}
