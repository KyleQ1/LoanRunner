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
        backgroundMusic = new GreenfootSound("bgMusic.mp3");
        backgroundMusic.setVolume(35);

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

        LoanShark shark = new LoanShark();
        addObject(shark, 1024, 700);
        prepare();
        ti = new TitleImage();
        addObject(ti, getWidth() / 2, getHeight() / 2);
        Counter counter = new Counter();
        addObject(counter, 1150, 50);
        player = new Student(counter);
        player.level = 1;
        addObject(player, 600, 750);
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

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Coin coin = new Coin();
        addObject(coin,300,505);
        Coin coin2 = new Coin();
        addObject(coin2,761,239);
        Coin coin3 = new Coin();
        addObject(coin3,1125,418);
        Coin coin4 = new Coin();
        addObject(coin4,1966,313);
        Coin coin5 = new Coin();
        addObject(coin5,3238,199);
        Coin coin6 = new Coin();
        addObject(coin6,3991,314);
        Coin coin7 = new Coin();
        addObject(coin7,4208,314);
        Coin coin8 = new Coin();
        addObject(coin8,4950,130);
        Coin coin9 = new Coin();
        addObject(coin9,4692,367);
        Coin coin10 = new Coin();
        addObject(coin10,3568,343);
        Coin coin11 = new Coin();
        addObject(coin11,3752,444);
        Coin coin12 = new Coin();
        addObject(coin12,3933,545);
        Coin coin13 = new Coin();
        addObject(coin13,2395,755);
        Coin coin14 = new Coin();
        addObject(coin14,2195,758);
        Coin coin15 = new Coin();
        addObject(coin15,4886,320);
        Coin coin16 = new Coin();
        addObject(coin16,4883,391);
        Obstacle obstacle = new Obstacle();
        addObject(obstacle,3995,400);
        Obstacle obstacle2 = new Obstacle();
        addObject(obstacle2,4209,391);
        Obstacle obstacle3 = new Obstacle();
        addObject(obstacle3,3706,377);
        Obstacle obstacle4 = new Obstacle();
        addObject(obstacle4,4611,381);
        obstacle4.setLocation(4610,372);
        obstacle4.setLocation(4625,386);
        Obstacle obstacle5 = new Obstacle();
        addObject(obstacle5,4783,375);
        Obstacle obstacle6 = new Obstacle();
        addObject(obstacle6,2639,770);
        obstacle6.setLocation(2637,777);
        Obstacle obstacle7 = new Obstacle();
        addObject(obstacle7,2056,380);
        obstacle7.setLocation(2057,374);
        Obstacle obstacle8 = new Obstacle();
        addObject(obstacle8,223,525);
        Obstacle obstacle9 = new Obstacle();
        addObject(obstacle9,461,227);
        Obstacle obstacle10 = new Obstacle();
        addObject(obstacle10,787,577);
        obstacle10.setLocation(887,573);
        Obstacle obstacle11 = new Obstacle();
        addObject(obstacle11,1465,423);
        obstacle11.setLocation(1460,426);
        removeObject(obstacle10);
        removeObject(obstacle7);
        removeObject(coin14);
        removeObject(obstacle2);
        removeObject(obstacle4);
        obstacle.setLocation(4107,405);
    }
}
