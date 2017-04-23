package Model;

import java.awt.event.KeyEvent;

import static Model.Direction.DOWN;
import static Model.Direction.UP;

/**
 * Created by Trueman on 2017-04-22.
 * A Pong Game.
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
        checkCollision();
    }

    public void keyPressed(int keyCode) {
        switch (keyCode) {
            case KeyEvent.VK_UP:
                p2.changeDirection(UP);
                break;
            case KeyEvent.VK_DOWN:
                p2.changeDirection(DOWN);
                break;
            case KeyEvent.VK_W:
                p1.changeDirection(UP);
                break;
            case KeyEvent.VK_S:
                p1.changeDirection(DOWN);
                break;
        }
    }

    private void checkCollision() {
        if (sameX(ball, p1) && sameY(ball, p1))
            ball.bounce();
        if (sameX(ball, p2) && sameY(ball, p2))
            ball.bounce();
    }

    private boolean sameX(Ball b, Paddle p) {
        return ((b.getX() - Ball.DIAMETER/2 == p.getX() + Paddle.WIDTH/2) ||
                (b.getX() + Ball.DIAMETER/2 == p.getX() - Paddle.WIDTH/2));
    }

    private boolean sameY(Ball b, Paddle p) {
        int bY = b.getY();
        int pY = p.getY();

        return ((bY <= pY + Paddle.HEIGHT/2) && bY >= pY - Paddle.HEIGHT/2);
    }

    public Paddle getPaddle1() {return p1;}
    public Paddle getPaddle2() {return p2;}
    public Ball getBall() {return ball;}

}
