import greenfoot.*; // Import Greenfoot classes

public class Coin extends Actor {
    public Coin() {
        GreenfootImage image = new GreenfootImage(40, 40);
        image.setColor(Color.ORANGE);
        image.fillOval(0, 0, 40 - 1, 40 - 1);
        setImage(image);
    }
}
