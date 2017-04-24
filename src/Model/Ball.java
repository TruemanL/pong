package Model;

import java.awt.*;

/**
 * Created by Trueman on 2017-04-22.
 */
public class Ball extends Sprite {
    public static final Color COLOR = new Color(0,0,0);

    private int dy;
    private int dx;

    public Ball(int x, int y, int width, int height, int dy, int dx) {
        super(x, y, width, height);
        this.dx = dx;
        this.dy = dy;
    }

    public void move() {
        x += dx;
        y += dy;
        checkBounds();
    }

    public void bounce() {
        dx = -dx;
    }

    private void checkBounds() {
        if (y - height/2 < 0) {
            dy = -dy;
        } else if (y + height/2 > PongGame.HEIGHT) {
            dy = -dy;
        }
    }

    public int getDX() {return dx;}
    public int getDY() {return dy;}

}
