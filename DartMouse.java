import mayflower.*;

public class DartMouse extends Actor
{
    MouseInfo mouse;
    
    public DartMouse()
    {
        setImage("img/dart.png");
        mouse = Mayflower.getMouseInfo();
    }
    
    public void act()
    {
        mouse = Mayflower.getMouseInfo();
        setLocation(mouse.getX(), mouse.getY());
    }
}