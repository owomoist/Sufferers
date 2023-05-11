import mayflower.*;
import java.util.HashMap;
import java.util.ArrayList;

public class MainMenu extends World
{
    private ArrayList<Button> buttonArray;
    private int numCoins = 50;
    
    private boolean started = false;
    private PomodoroTimer timer;
    
    public MainMenu(int coinTransfer)
    {
        //setBackground(new MayflowerImage(1000, 1000));
        showText("choose your topic", 50, 50, Color.MEGENTA);
        numCoins += coinTransfer;
        showText("coins: " + numCoins, 50, 950, Color.MEGENTA);
        buttonArray = new ArrayList<Button>();
    }
    
    public void addObjects()
    {
        buttonArray.add(new Button("img/mouse cursor.png", "factoring", 50, 100));
        buttonArray.add(new Button("img/mouse cursor.png", "solve for x", 50, 150));
        buttonArray.add(new Button("img/mouse cursor.png", "quadratic formula", 50, 200));
        buttonArray.add(new Button("img/mouse cursor.png", "expanding polynomials", 50, 250));
        
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
        {
            World w = new FactoringProblem(numCoins);
            WorldTracker.setCurrentWorld(w);
        }
        else if(buttonArray.get(1).clicked())
        {
            System.out.println(buttonArray.get(1).toString() + " was clicked");
            // World w = new SolveForXProblem(numCoins);
            // WorldTracker.setCurrentWorld(w);
            // Mayflower.setWorld(w);
        }
        else if(buttonArray.get(2).clicked())
        {   
            System.out.println(buttonArray.get(2).toString() + " was clicked");
            // World w = new QuadraticFormulaProblem(numCoins);
            // WorldTracker.setCurrentWorld(w);
            // Mayflower.setWorld(w);
        }
        else if(buttonArray.get(3).clicked())
        {
            System.out.println(buttonArray.get(3).toString() + " was clicked");
            // World w = new ExpandingPolynomialsProblem(numCoins);
            // WorldTracker.setCurrentWorld(w);
            // Mayflower.setWorld(w);
        }
    }
}
