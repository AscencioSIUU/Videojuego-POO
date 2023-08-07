import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Button extends Actor
{
    private World link;
    public void act(String image, World link)
    {
        //setImage(new GreenfootImage(image));
        //this.link = link;       
    }
    
    public void act(){
        if(Greenfoot.mouseClicked(this)){
            Background background = new Background();
            Greenfoot.setWorld(background);
        }       
    }
}
