package cz.cvut.fit.miadp.mvcgame.model;

import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Position  {

	private int posX = 0;
	private int posY = 0;

	public Position( ){

	}

	public Position( int posX, int posY ){
		this.posX = posX;
		this.posY = posY;
	}

	public int getX( ) {
		return posX;
	}

	public int getY( ) {
		return posY;
	}

	public void setY( int y ) {
		this.posY = y;
	}

	public void setX( int x ) {
		this.posX = x;
	}

	public void add( Vector vector ) {
		this.setX( this.getX( ) + vector.getX( ) );
		this.setY( this.getY( ) + vector.getY( ) );
	}

}