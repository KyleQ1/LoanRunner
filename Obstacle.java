import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Obstacle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Obstacle extends Actor
{
    public Obstacle() {
        setImage("bomb.png");
    }
        public void act()
    {
        killStudent();
    }
    
    public void killStudent() {
        Student s = (Student) getOneIntersectingObject(Student.class);
        if (s!=null) {
            MyWorld w = new MyWorld();
            Greenfoot.setWorld(w);       
        }
    }
}
