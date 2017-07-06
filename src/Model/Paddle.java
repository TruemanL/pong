package Model;

import java.awt.*;

/**
 * Created by Trueman on 2017-04-22.
 */
public class Paddle extends Sprite {
    public static final Color COLOR = new Color(0,0,0);

    private static int SPEED = 5;

    private Direction dir;

    // Constructor for Paddle with x, y as center of paddle and dir as initial direction
    public Paddle(int x, int y, int width, int height, Direction dir) {
        super(x, y, width, height);
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
    }

    public void changeDirection(Direction d) {
        dir = d;
    }
}
