package UI;

import javax.swing.*;

/**
 * Created by Trueman on 2017-04-22.
 * Window frame for the game.
 */
public class Pong extends JFrame {

    // Sets up window for game
    public Pong() {
        super("Pong");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GamePanel gp = new GamePanel();
        add(gp);
        pack();
        setVisible(true);
    }

    // Starts the game
    public static void main(String[] args) {new Pong();}
}
