import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Platform here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Platform extends Actor
{
    private boolean isPrint = false;
    public Platform() {
        // Set the image for the platform
        GreenfootImage image = new GreenfootImage("platformBackgroundImage.jpeg");
        image.scale(200,10);
        setImage(image);
    }
    
    public boolean isPrinted() {
        if (isPrint == false) {
            isPrint = true;
            return false;
        }
        return true;
    }
}
