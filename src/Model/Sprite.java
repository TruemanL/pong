package Model;

import Physics.Collidable;

/**
 * Created by Trueman on 2017-04-23.
 */
public class Sprite implements Collidable {
    protected int width;
    protected int height;
    protected int x;
    protected int y;
    protected static int TOL = 2;

    public Sprite(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public int getWidth() {return width;}
    public int getHeight() {return height;}
    public int getX() {return x;}
    public int getY() {return y;}
    public int getDisplayX() {return x - width/2;}
    public int getDisplayY() {return y - height/2;}

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

    // returns true if point is between top and bot (inclusive)
    private boolean isBetween(int point, int top, int bot) {
        return ((bot + TOL >= point) && (point >= top - TOL));
    }
}
