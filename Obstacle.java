import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.GreenfootSound;
/**
 * Write a description of class Obstacle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Obstacle extends Actor
{
    private GreenfootSound slot = new GreenfootSound("kaching.mp3");
    public Obstacle() {
        GreenfootImage image = new GreenfootImage("slotmachine.png");
        image.scale(52, 52);
        setImage(image);
    }
        public void act()
    {
        killStudent();
    }
    
    public void killStudent() {
        Student s = (Student) getOneIntersectingObject(Student.class);
        if (s!=null) {
            if (Math.abs(getX() - s.getX()) < 30 
             && Math.abs(getY() - s.getY()) < 30) 
            {
                World w;
                if (s.level == 1) {
                    w = new World1();
                    s.level = 1;
                    World1.getBackgroundMusic().stop();                    
                } else if (s.level == 2) {
                    w = new World2();
                    s.level = 2;
                    World2.getBackgroundMusic().stop();
                } else if (s.level == 3) {
                    w = new World3();
                    s.level = 3;
                    World3.getBackgroundMusic().stop();
                } else {
                    w = new Credits();
                }
                slot.setVolume(35);
                slot.play();
                Greenfoot.setWorld(w);
            }
        }
    }
}
