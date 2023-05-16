import mayflower.*;
/**
 * Write a description of class MyMayflower here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MyMayflower extends Mayflower
{
    private static World world = null;
    public MyMayflower()
    {
        super("IXL", 1000, 1000, true);
    }
    
    public void init()
    {
        // change this to true to run this program in fullscreen mode
        Mayflower.setFullScreen(false);
        World w =  new TitleScreen();
        Mayflower.setWorld(w);
    }
    
    public void act()
    {
        
        
    }
}