
import mayflower.*;

public class TimedWorld extends World
{
    protected PomodoroTimer timer;
    private double mins;
    
    public TimedWorld(double duration)
    {
        timer = new PomodoroTimer(duration);
        mins = duration;
    }
    
    public void act()
    {
        if(timer.getSecondsLeft() > 10)
            showText(timer.getFormattedTime(), 850, 50, Color.MEGENTA);
        else
        {
            if(timer.getSecondsLeft() >= 0)
                showText(timer.getFormattedTime(), 850, 50, Color.RED);
            else
                showText("Time's Up >:D", 730, 100, Color.MEGENTA);
        }
    }
}