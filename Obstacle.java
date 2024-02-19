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
    private GreenfootSound musica;
    private GreenfootSound bomb;
    public Obstacle(GreenfootSound music) {
        setImage("bomb.png");
        musica = music;
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
            bomb = new GreenfootSound("bomb.mp3");
            bomb.setVolume(35);
            bomb.play();
            musica.stop();
        }
    }
}
