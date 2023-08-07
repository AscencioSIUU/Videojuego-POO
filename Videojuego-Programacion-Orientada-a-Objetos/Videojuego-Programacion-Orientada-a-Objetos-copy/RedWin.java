import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RedWin here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RedWin extends World
{

    /**
     * Constructor for objects of class RedWin.
     * 
     */
    public RedWin()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 676, 1); 
        prepare();
    }
    public void prepare()
    {
        GreenfootImage logo = new GreenfootImage("RedWin1.png");
        Picture logoPic = new Picture(logo);
        addObject(logoPic, getWidth()/2, getHeight()/2);  
    }
}
