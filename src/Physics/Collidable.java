package Physics;

/**
 * Created by Trueman on 2017-04-23.
 */
public interface Collidable {
    // Returns true if this has collided with other
    public boolean detectCollision(Collidable other);

    // Returns y value of top of object
    public int returnTop();

    // Returns y value of bottom of object
    public int returnBot();

    // Returns x value of left of object
    public int returnLeft();

    // Returns x value of right of object
    public int returnRight();

}
