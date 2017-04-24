package UI;

import Model.Ball;
import Model.Paddle;
import Model.PongGame;
import Model.Wall;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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
        addTimer();
        setFocusable(true);
        addKeyListener(new KeyHandler());
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

    // key handler to handle key events
    private class KeyHandler extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) { pg.keyPressed(e.getKeyCode());}
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawGame(g);
    }

    // draw game onto g
    private void drawGame(Graphics g) {
        drawWalls(g);
        drawPaddles(g);
        drawBall(g);
    }

    // draws walls onto g
    private void drawWalls(Graphics g) {
        Wall tW = pg.getTopWall();
        Wall bW = pg.getBotWall();
        Color savedCol = g.getColor();
        g.setColor(Wall.COLOR);
        g.fillRect(tW.getDisplayX(), tW.getDisplayY(), tW.getWidth(), tW.getHeight());
        g.fillRect(bW.getDisplayX(), bW.getDisplayY(), bW.getWidth(), bW.getHeight());
        g.setColor(savedCol);
    }

    // draws paddles onto g
    private void drawPaddles(Graphics g) {
        Paddle p1 = pg.getPaddle1();
        Paddle p2 = pg.getPaddle2();
        Color savedCol = g.getColor();
        g.setColor(Paddle.COLOR);
        g.fillRect(p1.getDisplayX(), p1.getDisplayY(), p1.getWidth(), p1.getHeight());
        g.fillRect(p2.getDisplayX(), p2.getDisplayY(), p2.getWidth(), p2.getHeight());
        g.setColor(savedCol);
    }

    private void drawBall(Graphics g) {
        Ball b = pg.getBall();
        Color savedCol = g.getColor();
        g.setColor(Ball.COLOR);
        g.fillOval(b.getDisplayX(), b.getDisplayY(), b.getWidth(), b.getHeight());
        g.setColor(savedCol);
    }

    public void update() {
        pg.update();
        repaint();
    }
}
