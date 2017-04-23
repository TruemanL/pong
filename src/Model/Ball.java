package Model;

import java.awt.*;

/**
 * Created by Trueman on 2017-04-22.
 */
public class Ball {
    public static final Color COLOR = new Color(0,0,0);
    public static int DIAMETER = 20;
    private int x;
    private int y;
    private int dy;
    private int dx;

    public Ball(int x, int y, int dy, int dx) {
        this.x = x;
        this.y = y;
        this.dx = dx;
        this.dy = dy;
    }

    public void move() {
        x += dx;
        y += dy;
        checkBounds();
    }

    private void checkBounds() {
        if (y - DIAMETER/2 < 0) {
            dy = -dy;
        } else if (y + DIAMETER/2 > PongGame.HEIGHT) {
            dy = -dy;
        }
    }

    public int getX() {return x;}
    public int getY() {return y;}

    public int getDisplayX() {return x - DIAMETER/2;}
    public int getDisplayY() {return y - DIAMETER/2;}

    public int getDX() {return dx;}
    public int getDY() {return dy;}

}
