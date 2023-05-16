import mayflower.*;
import java.util.HashMap;
import java.util.ArrayList;

public class MainMenu extends World
{
    private ArrayList<Button> buttonArray;
    private HashMap<Button, World> buttonHash;;
    private int numCoins = 50;
    
    private boolean started = false;
    private PomodoroTimer timer;
    
    public MainMenu(int coinTransfer)
    {
        showText("choose your topic", 50, 50, Color.MEGENTA);
        numCoins += coinTransfer;
        showText("Coins: " + numCoins, 50, 950, Color.MEGENTA);
        buttonArray = new ArrayList<Button>();
        buttonHash = new HashMap<Button, World>();
    }
    
    public void addObjects()
    {
        buttonArray.add(new Button("img/mouse cursor.png", "factoring", 50, 100));
        buttonArray.add(new Button("img/mouse cursor.png", "expanding polynomials", 50, 150));
        buttonArray.add(new Button("img/mouse cursor.png", "quadratic formula", 50, 200));
        buttonArray.add(new Button("img/mouse cursor.png", "solve for x", 50, 250));
        
        // connect each button with world it should lead to
        try
        {
            for(int i = 0; i < 4; i++)
            {
                buttonHash.put(buttonArray.get(i), new MathProblem(2, numCoins, buttonArray.get(i).toString(), 0));
            }
        }
        catch(Exception e)
        {
            
        }
        
        for(int i = 0; i <= 3; i++)
        {
            addObject(buttonArray.get(i), buttonArray.get(i).getX(), buttonArray.get(i).getY());
        }
    }
    
    public void act()
    {
        if(!started)
        {
            addObjects();
            started = true;
        }
        
        if(buttonArray.get(0).clicked())
            WorldTracker.setCurrentWorld(buttonHash.get(buttonArray.get(0)));
        else if(buttonArray.get(1).clicked())
            WorldTracker.setCurrentWorld(buttonHash.get(buttonArray.get(1)));
        else if(buttonArray.get(2).clicked())
            WorldTracker.setCurrentWorld(buttonHash.get(buttonArray.get(2)));
        else if(buttonArray.get(3).clicked())
            WorldTracker.setCurrentWorld(buttonHash.get(buttonArray.get(3)));
    }
}