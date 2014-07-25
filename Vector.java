/**
 * A utility class for Greenfoot that represents a 2-dimensional vector.
 * 
 * The vector can be used to deal with movement information (speed and
 * direction) of actors. An actor can store a vector, and then other vectors 
 * can be added to modify the current velocity and direction.
 * 
 * @author Poul Henriksen
 * @author Michael Kolling
 * 
 * @version 1.1 (July 2007)
 */
public class Vector
{
    double dx = 0;
    double dy = 0;
    int direction = 0;
    double length = 0;

	/**
	 * New vector with direction 0 and length 0.
	 */
    public Vector()
    {
		this(0, 0);
    }

	/**
	 * New vector with given length (double) and
	 * direction (in degrees, as int).
	 */
    public Vector(int direction, double length)
    {
        this.length = length;
        this.direction = direction;
        updateCartesian();
    }

//     public Vector(Location start, Location end)
//     {
//         dx = end.getX() - start.getX();
//         dy = end.getY() - start.getY();
//         updatePolar();
//     }

    /**
     * Set the direction of this vector.
	 * @param direction is direction clockwise, in degrees.
     */
    public void setDirection(int direction) {
        this.direction = direction;
        updateCartesian();
    }
   
    /**
     * Add other vector to this vector.
     */
    public void add(Vector other) {
        dx += other.dx;
        dy += other.dy;
        updatePolar();
    }
	
    /**
     * Add a constant to the length of this vector.
	 * @param amount is amount to add to vector length
     */
    public void increaseLength(double amount) {
        length = length + amount;
        updateCartesian();
    }
    
    public void reduceLength(double amount) {
        length = length - amount;
        updateCartesian();
    }
    
	/**
	 * Rescale the magnitude of vector by given
	 * scale factor.  This changes the length but
	 * not the direction.
	 * @param factor is multiplier to apply to vector size
	 */
    public void scale(double factor) {
        length = length * factor;
        updateCartesian();
    }
    
	/**
	 * Stupid method to set vector length and direction to 0,0.
	 */
    public void setNeutral() {
        dx = 0.0;
        dy = 0.0;
        length = 0.0;
        direction = 0;
    }
    
    /**
     * Update the direction and length fom the current dx, dy.
     */
    private void updatePolar() {
        this.direction = (int) Math.toDegrees(Math.atan2(dy, dx));
        this.length = Math.sqrt(dx*dx+dy*dy);
    }   
    
    /**
     * Update dx and dy from the current direction and length.
     */
    private void updateCartesian() {
        dx = length * Math.cos(Math.toRadians(direction));
        dy = length * Math.sin(Math.toRadians(direction));   
    }   

    /**
     * Get the x component of the vector.
     */
    public double getX() {
        return dx;
    }
    /**
     * Get the y component of the vector.
     */
    public double getY() {
        return  dy;
    }
    
    /**
     * Get the direction the vector is pointing, in degrees.
     * The positive x-direction is 0 degrees.
     */
    public int getDirection() {
        return direction;
    }
    
    /**
     * Get the length of the vector (double).
     */
    public double getLength() {
        return length;
    }
    
    /**
     * Create a copy of this vector.
     */
    public Vector copy() {
        Vector copy = new Vector();
        copy.dx = dx;
        copy.dy = dy;
        copy.direction = direction;
        copy.length = length;
        return copy;
    }
    
    /**
     * String representation of vector values,
     * intended for testing. Returns
     * [direction, length (x,y)]
     */
    public String toString() {
        return "[direction=" + direction + ", length=" + length + " (" + dx + "," + dy + ")]";
    }
}
