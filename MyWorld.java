import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 800, 1);
        
        Student student = new Student();
        addObject(student, 600, 750);
        
        Platform platform1 = new Platform();
        addObject(platform1, 600, 675);
        Platform platform2 = new Platform();
        addObject(platform2, 300, 550);
        Platform platform3 = new Platform();
        addObject(platform3, 800, 600);
        
        Coin c1 = new Coin();
        addObject(c1, 600, 500);
        Coin c2 = new Coin();
        addObject(c2, 400, 450);
        Coin c3 = new Coin();
        addObject(c3, 800, 530);
        
    }
}
