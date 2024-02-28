import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.GreenfootSound;
import java.util.List;

/**
 * Write a description of class World4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class World3 extends World
{
    public static GreenfootSound backgroundMusic = new GreenfootSound("bg3Music.mp3");
    private Student player;
    private int SCROLL_SPEED = 15;
    private TitleImage ti3;

    /**
     * Constructor for objects of class World4.
     * 
     */
    public World3()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 800, 1, false);
        

        backgroundMusic.setVolume(35);

        prepare();
        Counter counter = new Counter();
        addObject(counter, 1150, 50);
        player = new Student(counter);
        player.level = 3;
        addObject(player, 600, 750);
        ti3 = new TitleImage(3);
        addObject(ti3, getWidth() / 2, getHeight() / 2);
        setBackground("bg.jpg");
    }

    public static GreenfootSound getBackgroundMusic() {
        return backgroundMusic;
    }

    public void act() {
        if (Greenfoot.isKeyDown("up") || Greenfoot.mouseClicked(ti3)) {
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

        Wall wall = new Wall();
        addObject(wall,70,700);
        Wall wall2 = new Wall();
        addObject(wall2,70,500);
        Wall wall3 = new Wall();
        addObject(wall3,70,300);
        Wall wall4 = new Wall();
        addObject(wall4,70,100);
        Wall wall5 = new Wall();
        addObject(wall5,5000,700);
        Wall wall6 = new Wall();
        addObject(wall6,5000,500);
        Wall wall7 = new Wall();
        addObject(wall7,5000,300);
        Wall wall8 = new Wall();
        addObject(wall8,5000,100);
        Wall wall9 = new Wall();
        addObject(wall9,2800,700);
        Wall wall10 = new Wall();
        addObject(wall10,2800,500);
        Wall wall11 = new Wall();
        addObject(wall11,2800,100);
        Wall wall12 = new Wall();
        addObject(wall12,3200,100);
        Wall wall13 = new Wall();
        addObject(wall13,3200,300);
        Wall wall14 = new Wall();
        addObject(wall14,3200,500);
        Wall wall15 = new Wall();
        addObject(wall15,3600,700);
        Wall wall16 = new Wall();
        addObject(wall16,3600,500);
        Wall wall17 = new Wall();
        addObject(wall17,3600,300);
        Wall wall18 = new Wall();
        addObject(wall18,4000,700);
        Platform platform = new Platform();
        addObject(platform,350,637);
        Platform platform2 = new Platform();
        addObject(platform2,175,464);
        Platform platform3 = new Platform();
        addObject(platform3,419,289);
        Platform platform4 = new Platform();
        addObject(platform4,747,160);
        Platform platform5 = new Platform();
        addObject(platform5,1075,317);
        Platform platform6 = new Platform();
        addObject(platform6,1575,314);
        Platform platform7 = new Platform();
        addObject(platform7,1999,214);
        Platform platform8 = new Platform();
        addObject(platform8,2292,427);
        Platform platform9 = new Platform();
        addObject(platform9,2593,500);
        Platform platform10 = new Platform();
        addObject(platform10,3002,413);
        Platform platform11 = new Platform();
        addObject(platform11,3110,598);
        Platform platform12 = new Platform();
        addObject(platform12,3500,644);
        Platform platform13 = new Platform();
        addObject(platform13,3250, 365);
        Platform platform14 = new Platform();
        addObject(platform14,3510,200);
        Platform platform15 = new Platform();
        addObject(platform15,3910,600);
        Platform platform16 = new Platform();
        addObject(platform16,4336,446);
        Platform platform17 = new Platform();
        addObject(platform17,4721,299);
        Platform platform18 = new Platform();
        addObject(platform18,4900,535);
        Platform platform19 = new Platform();
        addObject(platform19,3486,337);
        platform19.setLocation(3600,450);
        Platform platform20 = new Platform();
        addObject(platform20,4396,167);
        Platform platform21 = new Platform();
        addObject(platform21,4076,172);
        Platform platform22 = new Platform();
        addObject(platform22,3803,121);
        LoanShark loanShark = new LoanShark();
        addObject(loanShark,952,635);
        loanShark.setLocation(980,698);
        Coin coin = new Coin();
        addObject(coin,147,165);
        Coin coin2 = new Coin();
        addObject(coin2,1329,202);
        Coin coin3 = new Coin();
        addObject(coin3,1767,152);
        Coin coin4 = new Coin();
        addObject(coin4,3145,175);
        Coin coin5 = new Coin();
        addObject(coin5,3648,414);
        coin5.setLocation(3663,412);
        Coin coin6 = new Coin();
        addObject(coin6,4925,486);
        Coin coin7 = new Coin();
        addObject(coin7,4331,387);
        Coin coin8 = new Coin();
        addObject(coin8,4687,234);
        Coin coin9 = new Coin();
        addObject(coin9,3911,745);
        Coin coin10 = new Coin();
        addObject(coin10,3911,667);
        Obstacle obstacle = new Obstacle();
        addObject(obstacle,3772,768);
        Obstacle obstacle2 = new Obstacle();
        addObject(obstacle2,3776,624);
        Obstacle obstacle3 = new Obstacle();
        addObject(obstacle3,4116,765);
        Obstacle obstacle4 = new Obstacle();
        addObject(obstacle4,4257,765);
        Obstacle obstacle5 = new Obstacle();
        addObject(obstacle5,4399,765);
        Obstacle obstacle6 = new Obstacle();
        addObject(obstacle6,4524,764);
        Obstacle obstacle7 = new Obstacle();
        addObject(obstacle7,4642,759);
        Obstacle obstacle8 = new Obstacle();
        addObject(obstacle8,4751,764);
        Obstacle obstacle9 = new Obstacle();
        addObject(obstacle9,4863,761);
        Obstacle obstacle10 = new Obstacle();
        addObject(obstacle10,3560,414);
        Obstacle obstacle11 = new Obstacle();
        addObject(obstacle11,3242,334);
        Obstacle obstacle12 = new Obstacle();
        addObject(obstacle12,3480,175);
        Obstacle obstacle13 = new Obstacle();
        addObject(obstacle13,3357,630);
        Obstacle obstacle14 = new Obstacle();
        addObject(obstacle14,3292,625);
        obstacle14.setLocation(3295,633);
        Obstacle obstacle15 = new Obstacle();
        addObject(obstacle15,2689,756);
        Obstacle obstacle16 = new Obstacle();
        addObject(obstacle16,2577,755);
        Obstacle obstacle17 = new Obstacle();
        addObject(obstacle17,2487,750);
        Obstacle obstacle18 = new Obstacle();
        addObject(obstacle18,2407,753);
        Obstacle obstacle19 = new Obstacle();
        addObject(obstacle19,2323,746);
        Obstacle obstacle20 = new Obstacle();
        addObject(obstacle20,2230,750);
        Obstacle obstacle21 = new Obstacle();
        addObject(obstacle21,2136,739);
        Obstacle obstacle22 = new Obstacle();
        addObject(obstacle22,2064,746);
        Obstacle obstacle23 = new Obstacle();
        addObject(obstacle23,1987,742);
        Obstacle obstacle24 = new Obstacle();
        addObject(obstacle24,1929,741);
        Obstacle obstacle25 = new Obstacle();
        addObject(obstacle25,1871,740);
        Obstacle obstacle26 = new Obstacle();
        addObject(obstacle26,1775,741);
        Obstacle obstacle27 = new Obstacle();
        addObject(obstacle27,1679,743);
        Obstacle obstacle28 = new Obstacle();
        addObject(obstacle28,1583,740);
        Obstacle obstacle29 = new Obstacle();
        addObject(obstacle29,1514,734);
        Obstacle obstacle30 = new Obstacle();
        addObject(obstacle30,1464,740);
        Obstacle obstacle31 = new Obstacle();
        addObject(obstacle31,1395,738);
        Obstacle obstacle32 = new Obstacle();
        addObject(obstacle32,2998,454);
        obstacle32.setLocation(3003,509);
        Obstacle obstacle33 = new Obstacle();
        addObject(obstacle33,266,547);
        Obstacle obstacle34 = new Obstacle();
        addObject(obstacle34,279,369);
        Obstacle obstacle35 = new Obstacle();
        addObject(obstacle35,572,209);
        Obstacle obstacle36 = new Obstacle();
        addObject(obstacle36,921,226);
        Obstacle obstacle37 = new Obstacle();
        addObject(obstacle37,1330,319);
        Obstacle obstacle38 = new Obstacle();
        addObject(obstacle38,2797,382);
        removeObject(obstacle2);
    }
}
