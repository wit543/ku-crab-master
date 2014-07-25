import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)

/**
 * A superclass for specific actor classes that add smooth movement.
 * 
 * Movement uses doubles (instead of int) for smooth motion.
 * A SmoothMover remembers its velocity (speed and direction)
 * and moves automatically.
 * Requires Vector class.
 * 
 * @author Poul Henriksen
 * @author James Brucker modified code
 * @version 2014.07.23
 */
public abstract class SmoothMover extends Animal
{
    private Vector speed;
    
    private double x = 0;
    private double y = 0;
    
    public SmoothMover()
    {
		speed = new Vector(); // speed 0
    }
    
    /**
     * Create new thing initialised with given speed.
     */
    public SmoothMover(Vector speed)
    {
        this.speed = speed;
    }
    
    /**
     * Move forward one step.
     */
    public void move() 
    {
        x = x + speed.getX();
        y = y + speed.getY();
		// wrap around the edge of world
        if(x >= getWorld().getWidth()) {
            x = 0;
        }
        if(x < 0) {
            x = getWorld().getWidth() - 1;
        }
        if(y >= getWorld().getHeight()) {
            y = 0;
        }
        if(y < 0) {
            y = getWorld().getHeight() - 1;
        }
        setLocation(x, y);
    }
    
    /**
     * Providing 'setLocation' based on double x, y. 
	 * This will eventually call the Actor (superclass) 
	 * setLocation method.
     */
    public void setLocation(double x, double y) 
    {
        this.x = x;
        this.y = y;
        super.setLocation((int) x, (int) y);
    }
    
    /**
     * Override the Actor setLocation method to keep 
	 * our own coordinates up-to-date.
     */
    public void setLocation(int x, int y) 
    {
        setLocation((double) x, (double) y);
    }

    /**
     * Increase the speed with the given vector.
     */
    public void increaseSpeed(Vector s) 
    {
        speed.add(s);
    }
    
    /**
     * Return the current speed.
     */
    public Vector getSpeed() 
    {
        return speed;
    }
    
	/**
	 * Test if this actor is at the edge of world.
	 * @return true if at world's edge
	 */
    public boolean atWorldEdge() {
		// how close to edge of world? (you can set this to 0)
		final int EDGESIZE = 1;
        World world = getWorld();
        int x = getX();
        int y = getY();
        return x <= EDGESIZE || x >= world.getWidth() - EDGESIZE-1 ||
               y <= EDGESIZE || y >= world.getHeight() - EDGESIZE-1 ;
    }
}
