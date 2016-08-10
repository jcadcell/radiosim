import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class House here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class House extends Actor
{
     /** How many images should be used in the animation of the wave */
    private static final int NUMBER_IMAGES= 30;
    
    /** 
     * The images of the wave. This is static so the images are not
     * recreated for every object (improves performance significantly).
     */
    private static GreenfootImage[] images;
    
    /** Current size of the wave */
    private int imageCount = 0;
    
    /**
     * Create a new proton wave.
     */
    public House() 
    {
        initializeImages();
        setImage(images[0]);
        //Greenfoot.playSound("proton.wav");
    }
    
    /** 
     * Create the images for expanding the wave.
     */
    public static void initializeImages() 
    {
        if (images == null) 
        {
            GreenfootImage baseImage = new GreenfootImage("wave.png");
            images = new GreenfootImage[NUMBER_IMAGES];
            for (int i = 0; i < NUMBER_IMAGES; i++) 
            {
                int size = (i+1) * ( baseImage.getWidth() / NUMBER_IMAGES );
                images[i] = new GreenfootImage(baseImage);
                images[i].scale(size, size);
            }
        }
    }
    
    /**
     * Act for the proton wave is: grow and check whether we hit anything.
     */
    public void act()
    { 
        checkReceived();
        grow();
    }
    
    /**
     * Check if the signal is being received by a radio.
     */
    private void checkReceived()
    {
        int range = getImage().getWidth() / 2;
        List<House> houses = getObjectsInRange(range, House.class);     
        
        for (House h : houses) {
            //a.hit (DAMAGE);
            Greenfoot.playSound("radio.wav");
        }
    }

    /**
     * Grow this wave. If we get to full size, remove.
     */
    private void grow()
    {
        if (imageCount >= NUMBER_IMAGES) 
        {
            getWorld().removeObject(this);
        }
        else 
        {
            setImage(images[imageCount]);
            imageCount++;
        }
    }
    
}
