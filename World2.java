import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.GreenfootSound;
import java.util.List;

/**
 * Write a description of class World4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class World2 extends World
{
    public static GreenfootSound backgroundMusic = new GreenfootSound("bgMusic.mp3");
    private Student player;
    private int SCROLL_SPEED = 15;
    private TitleImage ti2;

    /**
     * Constructor for objects of class World4.
     * 
     */
    public World2()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 800, 1, false);

        backgroundMusic.setVolume(35);  

        prepare();
        Counter counter = new Counter();
        addObject(counter, 1150, 50);
        player = new Student(counter);
        player.level = 2;
        addObject(player, 600, 750);
        

        ti2 = new TitleImage(2);
        addObject(ti2, getWidth() / 2, getHeight() / 2);
        setBackground("bg.jpg");
    }

    public static GreenfootSound getBackgroundMusic() {
        return backgroundMusic;
    }

    public void act() {
        if (Greenfoot.isKeyDown("up") || Greenfoot.mouseClicked(ti2)) {
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
    private void prepare()
    {
        LoanShark loanShark = new LoanShark();
        addObject(loanShark,2007,658);
        loanShark.setLocation(2006,691);
        Wall wall = new Wall();
        addObject(wall,100,700);
        Wall wall2 = new Wall();
        addObject(wall2,100,500);
        Wall wall3 = new Wall();
        addObject(wall3,100,300);
        Wall wall4 = new Wall();
        addObject(wall4,100,100);
        Platform platform = new Platform();
        addObject(platform,2693,579);
        Platform platform2 = new Platform();
        addObject(platform2,2956,464);
        Platform platform3 = new Platform();
        addObject(platform3,3432,460);
        Platform platform4 = new Platform();
        addObject(platform4,3438,247);
        Platform platform5 = new Platform();
        addObject(platform5,3765,236);
        Platform platform6 = new Platform();
        addObject(platform6,4032,258);
        Wall wall5 = new Wall();
        addObject(wall5,4897,693);
        Wall wall6 = new Wall();
        addObject(wall6,4886,488);
        Wall wall7 = new Wall();
        addObject(wall7,4888,268);
        Wall wall8 = new Wall();
        addObject(wall8,4876,85);
        Platform platform7 = new Platform();
        addObject(platform7,4354,145);
        Platform platform8 = new Platform();
        addObject(platform8,4776,448);
        Platform platform9 = new Platform();
        addObject(platform9,2309,554);
        Platform platform10 = new Platform();
        addObject(platform10,2318,333);
        Platform platform11 = new Platform();
        addObject(platform11,1871,415);
        Platform platform12 = new Platform();
        addObject(platform12,1689,314);
        Platform platform13 = new Platform();
        addObject(platform13,1484,249);
        Platform platform14 = new Platform();
        addObject(platform14,1266,166);
        Platform platform15 = new Platform();
        addObject(platform15,1069,167);
        platform15.setLocation(1059,167);
        Platform platform16 = new Platform();
        addObject(platform16,807,430);
        Platform platform17 = new Platform();
        addObject(platform17,484,291);
        Coin coin = new Coin();
        addObject(coin,475,258);
        Coin coin2 = new Coin();
        addObject(coin2,792,391);
        Coin coin3 = new Coin();
        addObject(coin3,1284,396);
        Coin coin4 = new Coin();
        addObject(coin4,2616,234);
        Coin coin5 = new Coin();
        addObject(coin5,4803,393);
        Coin coin6 = new Coin();
        addObject(coin6,4815,640);
        Coin coin7 = new Coin();
        addObject(coin7,4025,225);
        Coin coin8 = new Coin();
        addObject(coin8,4342,112);
        Coin coin9 = new Coin();
        addObject(coin9,2350,512);
        Coin coin10 = new Coin();
        addObject(coin10,189,166);
        Wall wall9 = new Wall();
        addObject(wall9,932,347);
        wall9.setLocation(982,268);
        Wall wall10 = new Wall();
        addObject(wall10,2729,300);
        Wall wall11 = new Wall();
        addObject(wall11,2729,100);
        Wall wall12 = new Wall();
        addObject(wall12,3564,389);
        wall12.setLocation(3535,364);
        platform4.setLocation(3495,260);
        wall12.setLocation(3564,342);
        platform4.setLocation(3577,284);
        wall12.setLocation(3545,361);
        Obstacle obstacle = new Obstacle();
        addObject(obstacle,189,744);
        Obstacle obstacle2 = new Obstacle();
        addObject(obstacle2,614,382);
        Obstacle obstacle3 = new Obstacle();
        addObject(obstacle3,1150,134);
        Obstacle obstacle4 = new Obstacle();
        addObject(obstacle4,2239,300);
        Obstacle obstacle5 = new Obstacle();
        addObject(obstacle5,4658,765);
        Obstacle obstacle6 = new Obstacle();
        addObject(obstacle6,4587,766);
        obstacle5.setLocation(4629,743);
        obstacle6.setLocation(4635,657);
        Obstacle obstacle7 = new Obstacle();
        addObject(obstacle7,4682,209);
        obstacle7.setLocation(4592,220);
        Obstacle obstacle8 = new Obstacle();
        addObject(obstacle8,3483,753);
        Obstacle obstacle9 = new Obstacle();
        addObject(obstacle9,3814,758);
        Obstacle obstacle10 = new Obstacle();
        addObject(obstacle10,4214,763);
        Obstacle obstacle11 = new Obstacle();
        addObject(obstacle11,3023,748);
        Obstacle obstacle12 = new Obstacle();
        addObject(obstacle12,2793,749);
        obstacle11.setLocation(3150,768);
        Obstacle obstacle13 = new Obstacle();
        addObject(obstacle13,989,774);
        Obstacle obstacle14 = new Obstacle();
        addObject(obstacle14,1188,779);
        Obstacle obstacle15 = new Obstacle();
        addObject(obstacle15,3110,482);
        Obstacle obstacle16 = new Obstacle();
        addObject(obstacle16,3197,480);
        Obstacle obstacle17 = new Obstacle();
        addObject(obstacle17,3275,480);
        obstacle11.setLocation(3173,753);
        obstacle11.setLocation(2511,500);
        obstacle16.setLocation(3183,480);
        obstacle17.setLocation(3266,481);
        wall12.setLocation(3545,452);
        platform5.setLocation(3749,200);
        platform6.setLocation(3964,268);
        wall5.setLocation(4890,700);
        wall6.setLocation(4890,500);
        wall7.setLocation(4890,300);
        wall8.setLocation(4890,100);
        platform8.setLocation(4811,444);
        coin6.setLocation(4811,710);
        platform3.setLocation(3483,477);
        platform15.setLocation(1074,169);
        platform8.setLocation(4789,446);
        wall12.setLocation(3575,380);
        platform6.setLocation(4121,267);
        platform6.setLocation(4060,267);
        platform6.setLocation(4050,265);
        platform15.setLocation(1070,166);
    }
}
