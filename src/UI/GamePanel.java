package UI;

import Model.Ball;
import Model.Paddle;
import Model.PongGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Trueman on 2017-04-22.
 * Panel that displays the game.
 */

public class GamePanel extends JPanel {

    private static final int INTERVAL = 20;
    private PongGame pg;

    // sets up panel size, background colour, and loads game
    public GamePanel() {
        setPreferredSize(new Dimension(PongGame.WIDTH, PongGame.HEIGHT));
        setBackground(Color.gray);
        this.pg = new PongGame();

    }

    // initialize a timer to update the game every INTERVAL milliseconds
    private void addTimer() {
        Timer timer = new Timer(INTERVAL, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                update();
            }
        });

        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawGame(g);
    }

    // draw game onto g
    private void drawGame(Graphics g) {
        drawPaddles(g);
        drawBall(g);
    }

    // draws paddles onto g
    private void drawPaddles(Graphics g) {
        Paddle p1 = pg.getPaddle1();
        Paddle p2 = pg.getPaddle2();
        Color savedCol = g.getColor();
        g.setColor(Paddle.COLOR);
        g.fillRect(p1.getX(), p1.getY(), Paddle.WIDTH, Paddle.HEIGHT);
        g.fillRect(p2.getX(), p2.getY(), Paddle.WIDTH, Paddle.HEIGHT);
        g.setColor(savedCol);
    }

    private void drawBall(Graphics g) {
        Ball b = pg.getBall();
        Color savedCol = g.getColor();
        g.setColor(Ball.COLOR);
        g.fillOval(b.getX(), b.getY(), Ball.DIAMETER, Ball.DIAMETER);
        g.setColor(savedCol);
    }

    public void update() {
        pg.update();
        repaint();
    }
}
