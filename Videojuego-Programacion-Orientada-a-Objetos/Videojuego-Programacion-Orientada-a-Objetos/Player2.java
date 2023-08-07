import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player2 extends Actor
{
    int vSpeed = 0;
    int acceleration = 1;
    int speed = 5;
    private int jumpHeight = -20;
    
    private int damage = 1;
    private int health, maxHealth;
    
    private int angle = 0;
    private boolean triggerReleased;
    
    private boolean dmgTaken = false;
    private int dmgTakenTimer = 0;
    private final int MAX_TRANS = 255;
    public Player2()
    {
        maxHealth = 5;
        health = maxHealth;
    }
    public void act()
    {
        checkFalling();
        processKeys();
        //fireProjectile();
        checkBulletContact(Projectile1.class);
        avoidGroundCollision();
    }
    private void fall()
    {
        setLocation(getX(), getY() + vSpeed);
        vSpeed = vSpeed + acceleration;
    }
    public void processKeys()
    {
        if(Greenfoot.isKeyDown("left"))
        {
            setLocation(getX() - speed, getY());
            angle = 180;
        }
        if(Greenfoot.isKeyDown("right"))
        {
            setLocation(getX() + speed, getY());
            angle = 0;
        }
        if(Greenfoot.isKeyDown("up")&&(onGround()== true))
        {
            vSpeed = jumpHeight;
            fall();
        }
        if(Greenfoot.isKeyDown("g"))
        {
            shoot();
            triggerReleased = false; //bullet dejara de disparar hasta soltar el boton
        }
        else if (!Greenfoot.isKeyDown("g")) 
        {
            triggerReleased = true; // bullet se podrá volver a disparar
        }
    }
    public void shoot()
    {
        if(triggerReleased)
        {
            Projectile2 projectile2 = new Projectile2();
            projectile2.setRotation(angle);
            getWorld().addObject(projectile2,getX(),getY());
            triggerReleased = false;
        }
    }
    
    boolean onGround()
    {
        Actor under = getOneObjectAtOffset(0, getImage().getHeight()/2, Ground.class);
        return under != null;
    }
    
    public void checkFalling()
    {
        if (onGround() == false)
        {
            fall();
        }
        if (onGround() == true)
        {
            vSpeed = 0;
        }
    }
    
    public void fireProjectile()
    {
        if(Greenfoot.mousePressed(null))
        {
            Projectile2 projectile2 = new Projectile2();
            getWorld().addObject(projectile2, getX(), getY());
            
            projectile2.turnTowards(Greenfoot.getMouseInfo().getX(), Greenfoot.getMouseInfo().getY());        
        }
    }
    
    public void checkBulletContact(Class<?> projectileClass)
    {
        //ckeck if zombie is in contact with bullet and then take damage
        if (isTouching(projectileClass) && dmgTaken == false)
        {
            Actor projectile = getOneIntersectingObject(projectileClass);
            if (projectile instanceof Projectile1) {
                health -= ((Projectile1) projectile).getDamage(); // Decrementar la vida por el daño de Projectile
                getWorld().removeObject(projectile);
            }
            dmgTaken = true;
            dmgTakenTimer = 100;
            changeTransparency(MAX_TRANS/2);
        }
        if (dmgTaken == true)
        {
            dmgTakenTimer --;
            if(dmgTakenTimer <= 0)
            {
                dmgTaken = false;
                changeTransparency(MAX_TRANS);
            }
        }
        if(health <= 0)
        {
            BlueWin blueWin = new BlueWin();
            Greenfoot.setWorld(blueWin);
        }
    }
    public void changeTransparency(int transparency)
    {
        GreenfootImage tempImage = getImage();
        tempImage.setTransparency(transparency);
    }
    
    //Parte del codigo sacada de CHAT-GPT
    public void avoidGroundCollision() {
        // Verificar si el actor está tocando un objeto de la clase Ground
        Actor ground = getOneIntersectingObject(Ground.class);
        if (ground != null) {
            // Si hay colisión, ajustar la posición para evitar la superposición
            int overlap = (getImage().getHeight() + ground.getImage().getHeight()) / 2;
            if (getY() < ground.getY()) {
                setLocation(getX(), ground.getY() - overlap);
            } else {
                setLocation(getX(), ground.getY() + overlap);
            }
        }
    }
}            

