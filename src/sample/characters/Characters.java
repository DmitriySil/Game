package sample.characters;

import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

abstract public class Characters {
    String name;
    double health;
    int speed;
    double damage;
    AnchorPane pane;
    ProgressBar healthBar;
    ProgressBar ammoBar;
    ImageView removeImgR = null;
    ImageView removeImgL = null;
    int width;
    int height;
    int x;
    int y;
    int offSetX;
    int offSetY;
    int level;
    int crossCount;
    int pistolCount = 0;
    boolean inJump;
    boolean canJump;
    boolean flyUp;
    boolean flyDown;
    boolean runLeft;
    boolean runRight;
    boolean seeRight;
    boolean seeLeft;
    boolean shot;
    boolean weapon1;
    boolean weapon2;
    static final int MAX_DOWN = 490;
    static final int FIRST_STAGE = 260;
    static final int SECOND_STAGE = 190;
    static final int THIRD_STAGE = 490;

    boolean enemySeeRight;

    public Characters(AnchorPane pane, ProgressBar healthBar,ProgressBar ammoBar) {
        this.pane = pane;
        this.healthBar = healthBar;
        this.ammoBar = ammoBar;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public AnchorPane getPane() {
        return pane;
    }

    public void setPane(AnchorPane pane) {
        this.pane = pane;
    }

    public ProgressBar getHealthBar() {
        return healthBar;
    }

    public void setHealthBar(ProgressBar healthBar) {
        this.healthBar = healthBar;
    }

    public ProgressBar getAmmoBar() {
        return ammoBar;
    }

    public void setAmmoBar(ProgressBar ammoBar) {
        this.ammoBar = ammoBar;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isInJump() {
        return inJump;
    }

    public void setInJump(boolean inJump) {
        this.inJump = inJump;
    }

    public int getOffSetX() {
        return offSetX;
    }

    public void setOffSetX(int offSetX) {
        this.offSetX = offSetX;
    }

    public int getOffSetY() {
        return offSetY;
    }

    public void setOffSetY(int offSetY) {
        this.offSetY = offSetY;
    }

    public boolean isRunLeft() {
        return runLeft;
    }

    public void setRunLeft(boolean runLeft) {
        this.runLeft = runLeft;
    }

    public boolean isRunRight() {
        return runRight;
    }

    public void setRunRight(boolean runRight) {
        this.runRight = runRight;
    }

    public void start(){}
    public void move(){}
    public void jump(){}
    public void run(){}
    public void shooting(){}
    public void damage(){}
    public void bonus(){}
}
