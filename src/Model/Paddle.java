package Model;

import Physics.Collidable;
import Physics.Movable;

import java.awt.*;

/**
 * Created by Trueman on 2017-04-22.
 */
public class Paddle implements Movable {
    public static final Color COLOR = new Color(0,0,0);
    private static int TOL = 2;
    private static int SPEED = 5;
    private int width;
    private int height;
    private int x;
    private int y;
    private Direction dir;

    // Constructor for Paddle with x, y as center of paddle and dir as initial direction
    public Paddle(int x, int y, int width, int height, Direction dir) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.dir = dir;
    }

    public void move() {
        switch (dir) {
            case UP:
                y -= SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
            case LEFT:
                x -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            case STOP:
                break;
        }
        //checkBounds();
    }

    public void changeDirection(Direction d) {
        dir = d;
    }

    private void checkBounds() {
        if (y - height/2 < 0) {
            y = height/2;
        } else if (y + height/2 > PongGame.HEIGHT) {
            y = PongGame.HEIGHT - height/2;
        }
    }

    public int getX() {return x;}
    public int getY() {return y;}
    public int getDisplayX() {return x - width/2;}
    public int getDisplayY() {return y - height/2;}
    public int getWidth() {return width;}
    public int getHeight() {return height;}
    public int getSpeed() {return SPEED;}
    public Direction getDirection() {return dir;}

    // returns true if point is between top and bot (inclusive)
    private boolean isBetween(int point, int top, int bot) {
        return ((bot - TOL <= point) && (point <= top + TOL));
    }

    @Override
    public boolean detectCollision(Collidable other) {
        int otherTop = other.returnTop();
        int otherBot = other.returnBot();
        int otherLeft = other.returnLeft();
        int otherRight = other.returnRight();
        if (isBetween(returnTop(), otherTop, otherBot) || isBetween(returnBot(), otherTop, otherBot))
            return (isBetween(returnLeft(), otherRight, otherRight) || isBetween(returnRight(), otherLeft, otherLeft));
        return false;
    }

    @Override
    public int returnTop() {
        return y - height/2;
    }

    @Override
    public int returnBot() {
        return y + height/2;
    }

    @Override
    public int returnLeft() {
        return x - width/2;
    }

    @Override
    public int returnRight() {
        return x + width/2;
    }


}
