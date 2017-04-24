package Model;

import Physics.Fixed;

import java.awt.*;

/**
 * Created by Trueman on 2017-04-23.
 */
public class Wall extends Sprite implements Fixed {
    public static final Color COLOR = new Color(0,0,0);

    public Wall(int x, int y, int width, int height) {
        super(x, y, width, height);
    }
}
