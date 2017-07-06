package Test;

import Model.Sprite;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Trueman on 2017-04-23.
 */
public class SpriteTest {
    Sprite testSpriteRef;
    Sprite testSpriteOther;

    private int refX = 0;
    private int refY = 0;
    private int refWidth = 20;
    private int refHeight = 40;

    @Before
    public void setUp() {
        testSpriteRef = new Sprite(refX, refY, refWidth, refHeight);
    }

    @Test
    public void testGetters() {
        assertEquals(refX, testSpriteRef.getX());
        assertEquals(refY, testSpriteRef.getY());
        assertEquals(refWidth, testSpriteRef.getWidth());
        assertEquals(refHeight, testSpriteRef.getHeight());
        assertEquals(refX - refWidth/2, testSpriteRef.getDisplayX());
        assertEquals(refY - refHeight/2, testSpriteRef.getDisplayY());
    }

    @Test
    public void detectCollisionNoCollision() {
        testSpriteOther = new Sprite(refX + refWidth, refY + refHeight, refWidth/2, refHeight/2);
        assertFalse(testSpriteRef.detectCollision(testSpriteOther));
    }

    @Test
    public void detectCollisionCollideLeft() {
        testSpriteOther = new Sprite(refX - refWidth, refY, refWidth, refHeight);
        assertTrue(testSpriteRef.detectCollision(testSpriteOther));
    }

    @Test
    public void detectCollisionCollideBot() {
        testSpriteOther = new Sprite(refX, refY + refHeight, refWidth, refHeight);
        assertTrue(testSpriteRef.detectCollision(testSpriteOther));
    }
}