package Model;

import java.awt.*;

/**
 * Created by Trueman on 2017-04-22.
 */
public class Ball extends Sprite {
    public static final Color COLOR = new Color(0,0,0);

    private int dy;
    private int dx;

    public Ball(int x, int y, int width, int height, int dx, int dy) {
        super(x, y, width, height);
        this.dx = dx;
        this.dy = dy;
    }

    public void move() {
        x += dx;
        y += dy;
    }

    public void bounce(Direction dir) {
        switch (dir) {
            case UP:
                dy = -Math.abs(dy);
                break;
            case DOWN:
                dy = Math.abs(dy);
                break;
            case LEFT:
                dx = -Math.abs(dx);
                break;
            case RIGHT:
                dx = Math.abs(dx);
                break;
        }
    }
}
