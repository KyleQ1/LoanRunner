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
        setBackground("falling-golden-poker-chips-tokens-600nw-1933775606-transformed.png");
        
        Counter counter = new Counter();
        addObject(counter, 1150, 50);
        player = new Student(counter);
        addObject(player, 600, 750);
                
        int[] xPlatform = {300, 450, 600, 750, 800, 900, 1400, 1450, 1600, 2000, 2100, 2500, 3000, 3500, 3700, 3900, 4100, 4400, 4700, 5000};
        int[] yPlatform = {550, 350, 675, 200, 600, 300, 450,  250,  150,  150,  400,  300,  300,  300,  400,  500,  600,  500,  400,  200};
        
        for (int i = 0; i < xPlatform.length; i++) {
            Platform platform = new Platform();
            addObject(platform, xPlatform[i], yPlatform[i]);
        }
        
        int[] xWall = {0,   0,   0,   0,   700, 2300, 2300, 2300, 5200, 5200, 5200};
        int[] yWall = {700, 500, 300, 100, 700, 700,  500,  300,  700,  500,  300};
        
        for (int i = 0; i < xWall.length; i++) {
            Wall wall = new Wall();
            addObject(wall,xWall[i], yWall[i]);
        }
        
        
        int[] xCoin = {300, 450, 600, 750, 800, 2000, 2100, 2500, 3000, 3500, 3700, 3900, 4100, 4400, 4700, 5000};
        int[] yCoin = {650, 350, 500,  300,  200,  200,  450,  350,  350,  350,  450,  550,  650,  550,  450,  250};
        
        for (int i = 0; i < xCoin.length; i++) {
            Coin c = new Coin();
            addObject(c, xCoin[i], yCoin[i]);
        }
        
        Obstacle o = new Obstacle();
        addObject(o, 200, 200);
        
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
