import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import java.util.*;
/**
 * Write a description of class Map here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Map extends World
{

    /**
     * Constructor for objects of class Map.
     * 
     */
    public Map()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(38, 25, 16); 
        setPaintOrder(Tower.class, Cell.class);
        
        for(int y=0; y<27; y++){
            for(int x=0; x<38; x++){
                addObject(new Cell(),x,y);
            }
        }
        
    }
}
        /**addObject(new Cell(),0,0);
        addObject(new Cell(),0,1);
        addObject(new Cell(),0,2);
        addObject(new Cell(),0,3);
        addObject(new Cell(),0,26);
        
        addObject(new Cell(),1,0);
        addObject(new Cell(),1,1);
        addObject(new Cell(),1,2);
        addObject(new Cell(),1,3);*/
        

    


