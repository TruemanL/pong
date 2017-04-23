package Model;

import java.awt.*;

/**
 * Created by Trueman on 2017-04-22.
 */
public class Paddle {
    public static final Color COLOR = new Color(0,0,0);
    public static int WIDTH = 20;
    public static int HEIGHT = 100;
    private static int SPEED = 5;
    private int x;
    private int y;
    private Direction dir;

    public Paddle(int x, int y, Direction dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    public void move() {
        switch (dir) {
            case UP: y += SPEED;
            break;
            case DOWN: y -= SPEED;
            break;
            case LEFT: x -= SPEED;
            break;
            case RIGHT: x += SPEED;
        }
    }

    public void changeDirection(Direction d) {
        dir = d;
    }

    public int getX() {return x;}
    public int getY() {return y;}

    public int getDisplayX() {return x - WIDTH/2;}
    public int getDisplayY() {return y - HEIGHT/2;}

    public int getSpeed() {return SPEED;}
    public Direction getDirection() {return dir;}

}
