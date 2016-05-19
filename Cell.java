import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import java.util.List;

/**
 * Area of the map that indicates distance from radio towers.
 */
public class Cell extends Actor
{
    /**
     * Set the color of the cell based on the environment.
     */
    public void act() 
    {
        
        List<Tower> towers = getWorld().getObjects(Tower.class);
        double dist = 0;
        for( Tower t: towers) {
            dist = dist + findDistance(t);
        }
        
        // TODO Set color based on signal strength, not just the distance
        // Set color based on 'dist'
       GreenfootImage pic = new GreenfootImage(16, 16);
       int red = (int)scale(dist/towers.size());
       pic.setColor(new Color(red, 0,0));
       pic.fill();
       setImage(pic);
    }    
    
    /** Find the hypotenuse of the right triangle with the given side lengths. */
    private double findDistance(double a, double b) {
        return Math.sqrt((a*a) + (b*b));
    }
    
    /** Find distance from this object to the given Actor. */
    private double findDistance(Actor other) {
        double a, b;
        a = other.getX() - this.getX();
        b = other.getY() - this.getY();
        return findDistance(a,b);
    }
    
    /** Scale from 0-46 range to 255-0 for color calculation. */
    private double scale(double value) {
        // TODO use world size to scale
        return 255- (value / 46 * 255);
    }
}
