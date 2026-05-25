package cz.cvut.fit.miadp.mvcgame.model;

import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;

import java.util.ArrayList;
import java.util.List;

public class Vector {

    private int dX = 0;
    private int dY = 0;

    public Vector( ) {
    }

    public Vector( int dX, int dY ) {
        this.dX = dX;
        this.dY = dY;
    }

    public int getX( ) {
        return this.dX;
    }

    public int getY( ) {
        return this.dY;
    }

}
