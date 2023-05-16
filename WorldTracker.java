import mayflower.*;

public class WorldTracker
{
    private static World world;
    
    public WorldTracker(World w)
    {
        world = w;
    }
    
    // issues with staticness when overriding setWorld() in MyMayflower
    public static void setCurrentWorld(World w)
    {
        world = w;
        Mayflower.setWorld(w);
    }
    
    public static World getCurrentWorld()
    {
        return world;
    }
}