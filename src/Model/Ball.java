package Model;

/**
 * Created by c2a1b on 2017-04-22.
 */
public class Ball {
    private static int RADIUS = 1;
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
    }

    public int getX() {return x;}
    public int getY() {return y;}
    public int getDX() {return dx;}
    public int getDY() {return dy;}

}
