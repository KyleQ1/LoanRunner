import greenfoot.*; // Import Greenfoot classes

public class Coin extends Actor {
    private int atime = 0;
    private GreenfootImage image1 = new GreenfootImage("money1.png");
    private GreenfootImage image2 = new GreenfootImage("money2.png");
    private GreenfootImage image3 = new GreenfootImage("money3.png");
    private GreenfootImage image4 = new GreenfootImage("money4.png");
    public Coin() {
        image1.scale(image1.getWidth()/2, image1.getHeight()/2);
        image2.scale(image2.getWidth()/2, image2.getHeight()/2);
        image3.scale(image3.getWidth()/2, image3.getHeight()/2);
        image4.scale(image4.getWidth()/2, image4.getHeight()/2);
        setImage(image1);
        
    }
    public void act() {
        atime++;
        if (atime == 0) {
            setImage(image1);
        }
        else if (atime == 4) {
            setImage(image2);
        }
        else if (atime == 8) {
            setImage(image3);
        }
        else if (atime == 12) {
            setImage(image4);
        }
        else if (atime == 16) {
            atime = 0;
        }
    }
}
