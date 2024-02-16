import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Student extends Actor {
    private double v = 0; 
    private double g = .6; 
    private final int ground = 750; 
    
    private int strafeSpeed = 0; 
    private final int maxStrafeSpeed = 14; 
    private final int strafeAcceleration = 2;
    private Counter counter;
    public Student() {
        setImage("man01.png");
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
        setLocation(getX() + strafeSpeed, getY() + (int)Math.round(v));
    }

    private void checkJump() {
        if (Greenfoot.isKeyDown("up") && onGround()) {
            v = -10;
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
        if (platform != null && v >= 0) {
            // Student is on a platform
            setLocation(getX(), platform.getY()-30);
            return true;
        } else {
            // Check if the Student is at the ground level
            return getY() >= ground;
        }
    }
    
    private void collectCoin() {
        Coin coin = (Coin) getOneIntersectingObject(Coin.class);
        if (coin != null) {
            counter.addScore(5);
            getWorld().removeObject(coin);
        }
    }
    private void hitRoof() {
        if (getY() <= 30) {
            setLocation(getX(), 31);
            v=-v;
        }
    }
}
