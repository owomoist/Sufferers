import mayflower.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FactoringProblem extends World
{
    private boolean started;
    
    private Button nextButton;
    private Button showAnswerButton;
    private PomodoroTimer timer;
    private Button breakButton;
    
    private int numCoins;
    private double duration;
    
    private Scanner sc;
    
    public FactoringProblem(int coinTransfer)
    {
        showText("Factoring", 50, 50, Color.MEGENTA);
        sc = new Scanner("factoring.txt");
        duration = 0.05;
        timer = new PomodoroTimer(duration);
        numCoins = coinTransfer + (int)(Math.ceil(duration));
    }
    
    private void addObjects()
    {
        nextButton = new Button("img/mouse cursor.png", "Next", 50, 100);
        addObject(nextButton, nextButton.getX(), nextButton.getY());
        
        showAnswerButton = new Button("img/mouse cursor.png", "Show Answer", 50, 150);
        addObject(showAnswerButton, showAnswerButton.getX(), showAnswerButton.getY());
        
        breakButton = new Button("img/mouse cursor.png", "Take a Break", 50, 200, Color.GRAY);
        addObject(breakButton, breakButton.getX(), breakButton.getY());
        breakButton.active = false;
    }
    
    public void updateTimer()
    {
        if(timer.getSecondsLeft() > 10)
            showText(timer.getFormattedTime(), 850, 50, Color.MEGENTA);
        else
        {
            if(timer.getSecondsLeft() >= 0)
                showText(timer.getFormattedTime(), 850, 50, Color.RED);
            else
            {
                showText("Time's Up >:D", 750, 100, Color.MEGENTA);
                showText("You got " + (int)(Math.ceil(duration)) + " coins!", 700, 150, Color.MEGENTA);
                breakButton.changeColor(Color.BLACK);
                breakButton.setActive(true);
            }
        }
    }
    
    
    public void act()
    {
        if(!started)
        {
            addObjects();
            started = true;
        }
        
        updateTimer();
        
        if(breakButton.clicked())
            WorldTracker.setCurrentWorld(new Darts(numCoins));
    }
}
