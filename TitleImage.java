import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TitleImage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TitleImage extends Actor
{
    private int level;
    public TitleImage(int level){
        if(level == 1){
            GreenfootImage titleimage = new GreenfootImage("title.png");
            setImage(titleimage);
        }
        else if (level == 2){
            GreenfootImage titleimage = new GreenfootImage("w2title.png");
            setImage(titleimage);
        }
        else if (level == 3){
            GreenfootImage titleimage = new GreenfootImage("w3title.png");
            setImage(titleimage);
        }
    }
}
