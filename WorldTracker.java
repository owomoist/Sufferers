import mayflower.*;

public class WorldTracker
{
    private static World world;
    
    public WorldTracker(World w)
    {
        world = w;
    }
    
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
