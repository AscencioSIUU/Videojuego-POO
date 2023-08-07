import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Projectile2 extends Actor
{
    int speed = 10;
    private int damage;
    public Projectile2()
    {
        getImage().scale(30,30);
        this.damage = 1;
    }
    public int getDamage()
    {
        return damage;
    }
    public void act()
    {
        move(speed);
        if(isTouching(Ground.class))
        {
           getWorld().removeObject(this); 
        }else if(isAtEdge())
        {
            getWorld().removeObject(this);
        }
    }
}
