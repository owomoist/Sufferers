import mayflower.*;
/**
 * Write a description of class Spinner here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Spinner extends Actor
{
    MayflowerImage[] imgArray;
    MayflowerImage image;
    /**
     * Constructor for objects of class Spinner
     */
    public Spinner()
    {
        image = new MayflowerImage("img/spinner2.png");
        image.rotate(Math.random() * 360);
        this.setImage(image);
    }

    public void act()
    {
        
    }
}
