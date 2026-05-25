package cz.cvut.fit.miadp.mvcgame.config;

public class MvcGameConfig
{
    public static final int MAX_X = 1280;
    public static final int MAX_Y = 720;
    public static final int MOVE_STEP = 10;
    public static final int CANNON_POSITION_X = 50;
    public static final int CANNON_POSITION_Y = MAX_Y/2;
    public static final int DIMENSIONS = 2;

    //2 player mode constants
    public static final int CANNON_A_DELAY = 100;
    public static final int CANNON_B_DELAY = 700;

    //cviceni 4 - upravit?
    public static final int INIT_POWER = 10;
    public static final double INIT_ANGLE = 0;
    public static final double ANGLE_STEP = Math.PI / 18;
    public static final int POWER_STEP = 10;
    public static final double GRAVITY = 9.8;

    public static final int MAX_SHOTS = 20;

    public static final int LEFT_TOP_ENEMY_SPAWN_X = 250;
    public static final int LEFT_TOP_ENEMY_SPAWN_Y = 50;

    public static final int RIGHT_BOT_ENEMY_SPAWN_X = 1230;
    public static final int RIGHT_BOT_ENEMY_SPAWN_Y = 670;

    public static final int ENEMY_MOVING_LIMIT = 100;
}