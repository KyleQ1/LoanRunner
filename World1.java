import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.GreenfootSound;
import java.util.List;

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class World1 extends World
{
    public static GreenfootSound backgroundMusic = new GreenfootSound("bgMusic.mp3");
    private Student player;
    private int SCROLL_SPEED = 15;
    private TitleImage ti;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public World1()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 800, 1, false);
        setBackground("bg.jpg");

        backgroundMusic.setVolume(50);

        Counter counter = new Counter();
        addObject(counter, 1150, 50);
        player = new Student(counter);
        player.level = 1;
        addObject(player, 600, 750);

        int[] xPlatform = {300, 450, 600, 750, 800, 900, 1400, 1450, 1600, 2000, 2100, 2500, 3000, 3500, 3700, 3900, 4100, 4400, 4700, 5000};
        int[] yPlatform = {550, 350, 675, 200, 600, 300, 450,  250,  150,  150,  400,  300,  300,  300,  400,  500,  600,  500,  400,  200};

        for (int i = 0; i < xPlatform.length; i++) {
            Platform platform = new Platform();
            addObject(platform, xPlatform[i], yPlatform[i]);
        }

        int[] xWall = {0,   0,   0,   0,   700, 2300, 2300, 2300, 5200, 5200, 5200, 5200};
        int[] yWall = {700, 500, 300, 100, 700, 700,  500,  300,  700,  500,  300,  100};

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

        int[] xObstacle = {300, 450, 2000, 2250, 3900, 4100, 4400, 4700, 5000};
        int[] yObstacle = {400, 100, 350,  300,  350,  450,  550,  450,  250};

        for (int i = 0; i < xObstacle.length; i++) {
            Obstacle o = new Obstacle();
            addObject(o, xObstacle[i], yObstacle[i]);
        }

        ti = new TitleImage();
        addObject(ti, getWidth() / 2, getHeight() / 2);

        LoanShark shark = new LoanShark();
        addObject(shark, 1024, 700);
    }
    
    public void act() {
        if (Greenfoot.isKeyDown("up") || Greenfoot.mouseClicked(ti)) {
            // Remove the TitleImage
            try{
                removeObject(getObjects(TitleImage.class).get(0));
                backgroundMusic.playLoop(); 
            }
            
            catch (IndexOutOfBoundsException e) {
            // do nothing
            }
        }
        scrollWithPlayer();
        //printPlatformCoordinates();
    }
    public static GreenfootSound getBackgroundMusic() {
        return backgroundMusic;
    }
    public void printPlatformCoordinates() {
        List<Platform> platforms = getObjects(Platform.class);
        for (Platform platform : platforms) {
            if (platform.isPrinted() == false) {
                int x = platform.getX();
                int y = platform.getY();
                System.out.println("Platform coordinates: (" + x + ", " + y + ")"); 
            }    
        }
    }
    
     private void scrollWithPlayer() {
        int playerX = player.getX();

        // Check if the player is close to the left edge
        if (playerX < getWidth() / 3) {
            scroll(-SCROLL_SPEED);
        }
        // Check if the player is close to the right edge
        else if (playerX > getWidth() - getWidth() / 3) {
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