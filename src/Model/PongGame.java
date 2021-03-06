package Model;

import java.awt.event.KeyEvent;

import static Model.Direction.*;

/**
 * Created by Trueman on 2017-04-22.
 * A Pong Game.
 */
public class PongGame {
    public static final int WIDTH = 800;
    public static final int HEIGHT = 500;
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
    private int initialDX;
    private int initialDY;

    /// creates ball and paddles
    public PongGame() {
        newGame();
    }

    public void newGame() {
        generateBallVelocity();
        p1 = new Paddle(BUFFER_SPACE,HEIGHT/2, paddleWidth, paddleHeight, STOP);
        p2 = new Paddle(WIDTH - BUFFER_SPACE, HEIGHT/2, paddleWidth, paddleHeight, STOP);
        ball = new Ball(WIDTH/2, HEIGHT/2, ballDiameter, ballDiameter, initialDX, initialDY);
        topWall = new Wall(WIDTH/2, WALL_THICKNESS/2, WIDTH, WALL_THICKNESS);
        botWall = new Wall(WIDTH/2, HEIGHT - WALL_THICKNESS/2, WIDTH, WALL_THICKNESS);
    }

    public void generateBallVelocity() {
        initialDX = 0;
        initialDY = 0;
        while (initialDX < 2)
            initialDX = (int) Math.round(Math.random() * 5);

        if (Math.random() > 0.5)
            initialDX = -initialDX;

        while (initialDY < 2)
            initialDY = (int) Math.round(Math.random() * 4);

        if (Math.random() > 0.5)
            initialDY = -initialDY;
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
                if (!p2.detectCollision(topWall))
                    p2.changeDirection(UP);
                break;
            case KeyEvent.VK_DOWN:
                if (!p2.detectCollision(botWall))
                    p2.changeDirection(DOWN);
                break;
            case KeyEvent.VK_W:
                if (!p1.detectCollision(topWall))
                    p1.changeDirection(UP);
                break;
            case KeyEvent.VK_S:
                if (!p1.detectCollision(botWall))
                    p1.changeDirection(DOWN);
                break;
            case KeyEvent.VK_R:
                newGame();
                break;
        }
    }

    private void checkCollision() {
        if ((p1.detectCollision(topWall)) || (p1.detectCollision(botWall)))
            p1.changeDirection(STOP);
        if ((p2.detectCollision(topWall)) || (p2.detectCollision(botWall)))
            p2.changeDirection(STOP);
        if (ball.detectCollision(topWall))
            ball.bounce(DOWN);
        if (ball.detectCollision(botWall))
            ball.bounce(UP);
        if (ball.detectCollision(p1))
            ball.bounce(RIGHT);
        if (ball.detectCollision(p2))
            ball.bounce(LEFT);
    }

    public Wall getTopWall() {return topWall;}
    public Wall getBotWall() {return botWall;}
    public Paddle getPaddle1() {return p1;}
    public Paddle getPaddle2() {return p2;}
    public Ball getBall() {return ball;}

}
