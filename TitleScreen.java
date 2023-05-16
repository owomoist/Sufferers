import mayflower.*;

public class TitleScreen extends World
{
    Button startButton;

    public TitleScreen()
    {
        //setBackground(new MayflowerImage(1000, 1000));
        showText("ixl", 50, 50, Color.MEGENTA);
        startButton = new Button("img/start.jpg", 50, 100);
        addObject(startButton, 500, 510);
    }
    
    public void act()
    {
        if(startButton.clicked())
        {
            World w = new MainMenu(0);
            WorldTracker.setCurrentWorld(w);
            Mayflower.setWorld(w);
        }
    }
}