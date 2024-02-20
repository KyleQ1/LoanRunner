import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.GreenfootSound;

public class Student extends Actor {
    public int level = 1;
    private double v = 0; 
    private double g = .6; 
    private final int ground = 750; 
    
    private int strafeSpeed = 0; 
    private final int maxStrafeSpeed = 14; 
    private final int strafeAcceleration = 2;
    private Counter counter;
    private int idleAnimation = 1;
    private int jumpAnimation = 1;
    private int runAnimation = 1;
    private int animationTimer = 0;
    private boolean isJumping = false;
    private boolean wasJumpingForward = false;
    private boolean wasRunningForward = false;
    private Actor textboxActor;
    
    private GreenfootSound jump;

    public Student() {
        setImage("idle1.png");
    }
    Student(Counter c) {
        counter = c;
    }
    public void act() {
        checkJump();
        checkKeyPress();
        move();
        fall();
        applyFriction();
        collectCoin();
        hitRoof();
        animateIdle();
        animateJump();
        animateRun();
        winCondition();
    }

    public void fall() {
        if (onGround()) {
            v = 0; 
        } else {
            setLocation(getX(), getY() + (int)Math.round(v));
            v += g;
        }
    }

    public void move() {        
        Wall w = (Wall) getOneObjectAtOffset(strafeSpeed, 0, Wall.class);
        if (w != null) {
            // should keep the student on the same side of the wall
            setLocation(getX(), getY() + (int)Math.round(v));
        } else {
            setLocation(getX() + strafeSpeed, getY() + (int)Math.round(v));
        }
    }

    private void checkJump() {
        if (Greenfoot.isKeyDown("up") && onGround()) {
            v = -10;
            jump = new GreenfootSound("jump.mp3");
            jump.setVolume(30);
            jump.play();
        }
    }

    private void checkKeyPress() {
        if (strafeSpeed > -maxStrafeSpeed && strafeSpeed < maxStrafeSpeed) {
            if (Greenfoot.isKeyDown("left")) {
                strafeSpeed -= strafeAcceleration;
            }
            if (Greenfoot.isKeyDown("right")) {
                strafeSpeed += strafeAcceleration;
            }
        }
    }

    private void applyFriction() {
        if (strafeSpeed < 0) {
            strafeSpeed++;
        } else if (strafeSpeed > 0) {
            strafeSpeed--;
        }
    }

    private boolean onGround() {
        // Check for platform directly below the Student
        Platform platform = (Platform) getOneIntersectingObject(Platform.class);
        if (platform != null && v >= 0 && Math.abs(getX() - platform.getX()) < 100) {
            // Student is on a platform
            setLocation(getX(), platform.getY()-45);
            return true;
        } else {
            // Check if the Student is at the ground level
            return getY() >= ground;
        }
    }
    
    private boolean notMoving() {
        return onGround() && strafeSpeed == 0;
    }
    
    private void collectCoin() {
        Coin coin = (Coin) getOneIntersectingObject(Coin.class);
        if (coin != null) {
            if (Math.abs(getY() - coin.getY()) < 40) 
            {
                counter.addScore(5);
                getWorld().removeObject(coin);
                GreenfootSound test = new GreenfootSound("money.mp3");
                test.setVolume(30);
                test.play();
            }
        }
    }
    private void hitRoof() {
        if (getY() <= 30) {
            setLocation(getX(), 31);
            v=-v;
        }
    }
    private void winCondition() {
        LoanShark loan = (LoanShark) getOneIntersectingObject(LoanShark.class);
        if (counter.getValue() >= 0) {
            if (loan != null) {
                World w = null;
                if (this.level == 1) {
                    World1.getBackgroundMusic().stop();
                    w = new World2();
                    this.level++;
                } else if (this.level == 2) {
                    World2.getBackgroundMusic().stop();
                    w = new World3();
                    this.level++;
                } else {
                    w = new Credits();
                }
                Greenfoot.setWorld(w);
            }
            
        }
    }
    private void animateIdle() {
        if (idleAnimation >= 6) {
            idleAnimation = 1;
        }
        if (notMoving() && animationTime(8)) {
            setImage(new GreenfootImage("idle"+idleAnimation+".png"));
            idleAnimation++;
        }
    }
    
    private void animateJump() {
        // Refresh jump state
        if (onGround()) {
            isJumping = false;
        }
    
        // Determine the direction of the fall
        boolean fallingForward = (strafeSpeed < 0);

        // If player is jumping
        if (v < 0 && animationTime(8)) {
            if (!isJumping) {
                // Play it once
                jumpAnimation = 1;
                isJumping = true;
            }
            if (jumpAnimation < 3) {
                setImage(new GreenfootImage("jump" + jumpAnimation + ".png"));
                if (fallingForward) {
                    flipImage(getImage());
                }
                jumpAnimation++;
            }
        }
        // If player is falling
        else if (v > 0 && animationTime(8)) {
            if (!isJumping) {
                jumpAnimation = 3;
                isJumping = true;
            }
            if (jumpAnimation < 6) {
                setImage(new GreenfootImage("jump" + jumpAnimation + ".png"));
                if (fallingForward) {
                    flipImage(getImage());
                }
                jumpAnimation++;
            }
        }
    }
    
    private void animateRun() {
        // Determine the direction of the run
        boolean runningForward = (strafeSpeed > 0);
    
        // If player is running forward
        if (strafeSpeed != 0 && animationTime(8)) {
            if (runAnimation >= 7) {
                runAnimation = 1;
            }
            setImage(new GreenfootImage("run" + runAnimation + ".png"));
            // Flip the image only if the direction changes
            if (!runningForward) {
                flipImage(getImage());
            }
            runAnimation++;
        }  
    }
    
    private boolean animationTime(int t) {
        if (animationTimer >= 2147483646) {
            animationTimer = 0;
        }
        animationTimer++;
        return animationTimer % t == 0;
    }
    
    private void flipImage(GreenfootImage image) {
        GreenfootImage flippedImage = new GreenfootImage(image);
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

        getWorld().addObject(textboxActor, getX(), getY() - 125);
    }
}
