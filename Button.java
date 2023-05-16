import mayflower.*;

public class Button extends Actor
{   
    private MouseInfo mouse;
    private World w;
    
    private String description;
    private int x;
    private int y;
    
    public boolean active = true;
    
    public Button(String imgFile, int x, int y)
    {
        setImage(imgFile);
        mouse = Mayflower.getMouseInfo();
        w = WorldTracker.getCurrentWorld();
        this.x = x;
        this.y = y;
    }
    
    public Button(String imgFile, String description, int x, int y)
    {
        setImage(imgFile);
        mouse = Mayflower.getMouseInfo();
        w = WorldTracker.getCurrentWorld();
        
        this.x = x;
        this.y = y;
        this.description = description;
        
        w.showText(description, x + 50, y + 30, Color.BLACK);
    }
    
    public Button(String imgFile, String description, int x, int y, Color c)
    {
        setImage(imgFile);
        mouse = Mayflower.getMouseInfo();
        w = WorldTracker.getCurrentWorld();
        
        this.x = x;
        this.y = y;
        this.description = description;
        
        w.showText(description, x + 50, y + 30, c);
    }
    
    public void act()
    {
        mouse = Mayflower.getMouseInfo();
    }
    
    public boolean clicked()
    {
        return active && mouse.getActor() != null && mouse.getActor().equals(this)
            && Mayflower.mouseClicked(this);
    }
    
    public int getX()
    {
        return x;
    }
    
    public int getY()
    {
        return y;
    }
    
    public void changeColor(Color c)
    {
        w.showText(description, x + 50, y + 30, c);
    }
    
    public void setActive(boolean a)
    {
        active = a;
    }
    
    public boolean isActive()
    {
        return active;
    }
    
    public String toString()
    {
        //if(description != null)
        return description;
        //return "no description";
    }
}