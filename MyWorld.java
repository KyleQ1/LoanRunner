import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    private Student player;
    private int SCROLL_SPEED = 15;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 800, 1, false);
        
        Counter counter = new Counter();
        addObject(counter, 1150, 50);
        player = new Student(counter);
        addObject(player, 600, 750);
        
        Platform platform1 = new Platform();
        addObject(platform1, 600, 675);
        Platform platform2 = new Platform();
        addObject(platform2, 300, 550);
        Platform platform3 = new Platform();
        addObject(platform3, 800, 600);
        Platform platform4 = new Platform();
        addObject(platform4, 1400, 450);
        Platform platform5 = new Platform();
        addObject(platform5, 900, 300);
        Platform platform6 = new Platform();
        addObject(platform6, 750, 200);
        Platform platform7 = new Platform();
        addObject(platform7, 450,350);
        
        Coin c1 = new Coin();
        addObject(c1, 600, 500);
        Coin c2 = new Coin();
        addObject(c2, 400, 450);
        Coin c3 = new Coin();
        addObject(c3, 800, 530);
        
    }
    
    public void act() {
        scrollWithPlayer();
    }
    
     private void scrollWithPlayer() {
        int playerX = player.getX();

        // Check if the player is close to the left edge
        if (playerX < getWidth() / 4) {
            scroll(-SCROLL_SPEED);
        }
        // Check if the player is close to the right edge
        else if (playerX > getWidth() - getWidth() / 4) {
            scroll(SCROLL_SPEED);
        }
    }

    private void scroll(int amount) {
        for (Object obj : getObjects(null)) {
            Actor actor = (Actor) obj;
            actor.setLocation(actor.getX() - amount, actor.getY());
        }
    }
}
