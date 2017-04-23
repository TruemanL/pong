package Model;

import static Model.Direction.UP;

/**
 * Created by Trueman on 2017-04-22.
 */
public class PongGame {
    public static final int WIDTH = 1000;
    public static final int HEIGHT = 600;
    public static final int BUFFER_SPACE = 20;

    private Paddle p1;
    private Paddle p2;
    private Ball ball;
    private int initialDX = (int) Math.round(Math.random()*5);
    private int initialDY = (int) Math.round(Math.random()*5);

    /// creates ball and paddles
    public PongGame() {
        p1 = new Paddle(BUFFER_SPACE,HEIGHT/2, UP);
        p2 = new Paddle(WIDTH - BUFFER_SPACE, HEIGHT/2, UP);
        ball = new Ball(WIDTH/2, HEIGHT/2, initialDX, initialDY);
    }

    public void update() {
        p1.move();
        p2.move();
        ball.move();
    }

    public Paddle getPaddle1() {return p1;}
    public Paddle getPaddle2() {return p2;}
    public Ball getBall() {return ball;}

}
