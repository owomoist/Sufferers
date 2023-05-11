import mayflower.*;

public class Darts extends World
{
    private int numCoins;
    private Button target;
    //private DartMouse mouse;
    private boolean started = false;
    
    private int ranX;
    private int ranY;
    
    private PomodoroTimer timer;
    
    public Darts(int coinTransfer)
    {
        numCoins = coinTransfer;
        showText("Coins: " + numCoins, 50, 950, Color.MEGENTA);
        showText("MOVING DARTS", 50, 50, Color.MEGENTA);
        showText("Hit the target to earn coins", 50, 100, Color.MEGENTA);
        ranX = (int)(Math.random() * 900 + 50);
        ranY = (int)(Math.random() * 900 + 50);
        timer = new PomodoroTimer(1);
    }
    
    private void addObjects()
    {
        target = new Button("img/target.jpg", 50, 150);
        addObject(target, target.getX(), target.getY());
    }
    
    public void act()
    {
        if(!started)
        {
            addObjects();
            started = true;
        }
        
        if(target.clicked())
        {
            ranX = (int)(Math.random() * 900 + 50);
            ranY = (int)(Math.random() * 900 + 50);
            target.setLocation(ranX, ranY);
            numCoins++;
        }
        
        showText("Coins: " + numCoins, 50, 950, Color.MEGENTA);
        
        if(timer.getSecondsLeft() > 10) // transfer this if statement to method in timer class
            showText(timer.getFormattedTime(), 850, 50, Color.MEGENTA);
        else
        {
            if(timer.getSecondsLeft() >= 0)
                showText(timer.getFormattedTime(), 850, 50, Color.RED);
            else
            {
                showText("Time's Up >:(", 750, 100, Color.MEGENTA);
            }
        }
    }
}
