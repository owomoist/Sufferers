import mayflower.*;

public class PomodoroTimer extends Timer
{
    private int startSec;
    
    public PomodoroTimer(double startMin)
    {
        super(0);
        startSec = (int)(startMin * 60);
    }
    
    public int getSecondsElapsed()
    {
        return -(int)(super.getTimeLeft()/1000000000);
    }
    
    public int getSecondsLeft()
    {
        return startSec - getSecondsElapsed();
    }
    
    public String getFormattedTime()
    {
        int min = getSecondsLeft() / 60;
        int sec = getSecondsLeft() % 60;
        String ret = "";
        if(min != 0)
        {
            if(min < 10)
                ret += "0";
            ret += min + ":";
        }
        else
            ret += "00:";
        if(sec < 10)
            ret += "0" + sec;
        else
            ret += sec;
        return ret;
    }
}