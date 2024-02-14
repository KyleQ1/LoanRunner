import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Platform here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Platform extends Actor
{
    public Platform() {
        // Set the image for the platform
        setImage(new GreenfootImage(200, 10)); // Change dimensions as needed
        getImage().setColor(Color.GRAY);
        getImage().fill();
    }
}
