import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Background here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Background extends World
{
// public Ground()
//       getImage().scale(getImage().getWidth()*6,getImage().getHeight());
 //   }
    /**
     * Constructor for objects of class Background.
     * 
     */
    public Background()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 700, 1); 
        prepare();
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        GreenfootImage logo = new GreenfootImage("background-nube.png");
        Picture logoPic = new Picture(logo);
        addObject(logoPic, getWidth()/2, getHeight()/2);     

        Wide wide = new Wide();
        addObject(wide,300,649);
        Wide wide2 = new Wide();
        addObject(wide2,695,649);

        Tall tall = new Tall(300, 100);
        addObject(tall,359,419);
        tall.setLocation(714,439);

        Tall tall2 = new Tall(300, 100);
        addObject(tall2,568,426);
        tall2.setLocation(280,439);

        Tall tall3 = new Tall(200, 100);
        addObject(tall3,494,247);
        tall3.setLocation(494,247);

        Player player = new Player();
        addObject(player,71,481);

        Player2 player2 = new Player2();
        addObject(player2,914,481);
        
    }
}
