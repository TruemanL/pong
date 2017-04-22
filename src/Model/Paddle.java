package Model;

/**
 * Created by c2a1b on 2017-04-22.
 */
public class Paddle {
    private static int WIDTH = 2;
    private static int HEIGHT = 10;
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
    public int getSpeed() {return SPEED;}
    public Direction getDirection() {return dir;}

}
