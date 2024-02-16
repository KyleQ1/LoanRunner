import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Wall here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Wall extends Actor
{
    public Wall() {
        // Set the image for the platform
        setImage(new GreenfootImage(20, 200)); // Change dimensions as needed
        getImage().setColor(Color.WHITE);
        getImage().fill();
    }
}
