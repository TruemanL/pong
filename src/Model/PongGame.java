package Model;

import java.awt.event.KeyEvent;

import static Model.Direction.*;

/**
 * Created by Trueman on 2017-04-22.
 * A Pong Game.
 */
public class PongGame {
    public static final int WIDTH = 1000;
    public static final int HEIGHT = 600;
    public static final int BUFFER_SPACE = 20;
    public static final int WALL_THICKNESS = 10;
    public static int paddleWidth = 20;
    public static int paddleHeight = 100;
    public static int ballDiameter = 20;

    private Paddle p1;
    private Paddle p2;
    private Ball ball;
    private Wall topWall;
    private Wall botWall;
    private int initialDX = (int) Math.round(Math.random()*5);
    private int initialDY = (int) Math.round(Math.random()*5);

    /// creates ball and paddles
    public PongGame() {
        p1 = new Paddle(BUFFER_SPACE,HEIGHT/2, paddleWidth, paddleHeight, STOP);
        p2 = new Paddle(WIDTH - BUFFER_SPACE, HEIGHT/2, paddleWidth, paddleHeight, STOP);
        ball = new Ball(WIDTH/2, HEIGHT/2, ballDiameter, ballDiameter, initialDX, initialDY);
        topWall = new Wall(WIDTH/2, WALL_THICKNESS/2, WIDTH, WALL_THICKNESS);
        botWall = new Wall(WIDTH/2, HEIGHT - WALL_THICKNESS/2, WIDTH, WALL_THICKNESS);
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
        if ((p1.detectCollision(topWall)) || (p1.detectCollision(botWall)))
            p1.changeDirection(STOP);
        if ((p2.detectCollision(topWall)) || (p2.detectCollision(botWall)))
            p2.changeDirection(STOP);
        if (sameX(ball, p1) && sameY(ball, p1))
            ball.bounce();
        if (sameX(ball, p2) && sameY(ball, p2))
            ball.bounce();
    }

    private boolean sameX(Ball b, Paddle p) {
        return ((b.getX() - b.getWidth()/2 == p.getX() + p.getWidth()/2) ||
                (b.getX() + b.getWidth()/2 == p.getX() - p.getWidth()/2));
    }

    private boolean sameY(Ball b, Paddle p) {
        int bY = b.getY();
        int pY = p.getY();

        return ((bY <= pY + p.getHeight()/2) && bY >= pY - p.getHeight()/2);
    }

    public Wall getTopWall() {return topWall;}
    public Wall getBotWall() {return botWall;}
    public Paddle getPaddle1() {return p1;}
    public Paddle getPaddle2() {return p2;}
    public Ball getBall() {return ball;}

}
