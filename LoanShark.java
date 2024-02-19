import greenfoot.*;
import java.util.Random;
/**
 * Write a description of class LaonShark here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LoanShark extends Actor 
{
    private int walkLength;
    private Random random = new Random();
    private boolean walkingRight = true;
    private GreenfootImage originalImage;
    private Actor textboxActor;
    private int textboxOffset = 125;
    /**
     * Constructor for objects of class LaonShark
     */
    public LoanShark()
    {
        originalImage = new GreenfootImage("loanshark-0.png");
        setImage(originalImage);
    }

    public void act() {
        walkingLogic();    
        textboxLogic();
    }
    
    private void textboxLogic() {
        // Check for collision with a Student
        Student student = (Student) getOneIntersectingObject(Student.class);
        if (student != null) {
            if (textboxActor == null) { // Create the textbox if it doesn't exist
                displayTextbox("You better have my money\nnext time I see you.");
            } else {
                // Update the position of the textbox to follow the LoanShark
                textboxActor.setLocation(getX(), getY() - textboxOffset);
            }
        } else if (textboxActor != null) {
            // Remove the textbox if the LoanShark is no longer colliding with a Student
            getWorld().removeObject(textboxActor);
            textboxActor = null;
        }
    }
    
    private void walkingLogic() {
         if (walkLength > 0) {
            walkDirection(walkingRight);
            walkLength--;
            animate();
        } else {
            walkLength = random.nextInt(50) + 10; // Walk for 10 to 60 steps
            walkingRight = random.nextBoolean(); 
        }
    }
    
    private void walkDirection(boolean direction) {
        int dx = direction ? 1 : -1;
        if (canMove(dx*10)) {
            setLocation(getX() + dx, getY());
            if (direction != walkingRight) {
                flipImage();
            }
            walkingRight = direction;
        }
    }
    private void animate() {
        int frame = 19 -(walkLength / 2) % 20;
        originalImage = new GreenfootImage("loanshark-" + frame + ".png");
        if (!walkingRight) {
            flipImage();
        } else {
            setImage(originalImage);
        }
    }
    
    private boolean canMove(int dx) {
        Actor wall = getOneObjectAtOffset(dx, 0, Wall.class);
        return wall == null;
    }
    
    private void flipImage() {
        GreenfootImage flippedImage = new GreenfootImage(originalImage);
        flippedImage.mirrorHorizontally();
        setImage(flippedImage);
    }
    
    private void displayTextbox(String text) {
        GreenfootImage textbox = new GreenfootImage(225, 50);
        textbox.setColor(Color.WHITE);
        textbox.fill();
        textbox.setColor(Color.BLACK);
        textbox.setFont(new Font("Arial", true, false, 16));
        textbox.drawString(text, 10, 25);

        textboxActor = new Actor() {
            {
                setImage(textbox);
            }
        };

        getWorld().addObject(textboxActor, getX(), getY() - textboxOffset);
    }
}
