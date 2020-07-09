package sample.characters;

import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;


import java.time.LocalTime;
import java.util.List;

abstract public class Characters {
    String player1Name;
    String player2Name;
    double player1Health = 1.0;
    double player2Health = 1.0;
    int player1Speed;
    int player2Speed;
    double damage;
    AnchorPane pane;
    ProgressBar healthBar1;
    ProgressBar healthBar2;
    ProgressBar ammoBar1;
    ProgressBar ammoBar2;
    ImageView removeImgRP1 = null;
    ImageView removeImgRP2 = null;
    ImageView removeImgLP1 = null;
    ImageView removeImgLP2 = null;
    int widthP1;
    int widthP2;
    int heightP1;
    int heightP2;
    int xP1;
    int xP2;
    int yP1;
    int yP2;
    int offSetXP1;
    int offSetXP2;
    int offSetYP1;
    int offSetYP2;
    int levelP1;
    int levelP2;
    int crossCountP1;
    int crossCountP2;
    int pistolCountP1 = 0;
    int pistolCountP2 = 0;
    boolean inJumpP1 = false;
    boolean inJumpP2 = false;
    boolean canJumpP1 = true;
    boolean canJumpP2 = true;
    boolean flyUpP1 = false;
    boolean flyUpP2 = false;
    boolean flyDownP1 = false;
    boolean flyDownP2 = false;
    boolean runLeftP1 = false;
    boolean runLeftP2 = false;
    boolean runRightP1 = false;
    boolean runRightP2 = false;
    boolean seeRightP1 = true;
    boolean seeRightP2;
    boolean seeLeftP1;
    boolean seeLeftP2 = true;
    boolean shotP1;
    boolean shotP2;
    boolean weapon1P1 = true;
    boolean weapon1P2 = true;
    boolean weapon2P1;
    boolean weapon2P2;

    LocalTime dieTime = LocalTime.now();
    boolean dieP1 = false;
    boolean dieP2 = false;

    boolean isBonus = false;
    int bonusCount = 0;
    int bonusWidth = 30;
    int bonusHeight = 30;
    int bonusPos1x = 20;
    int bonusPos1y = 155;
    LocalTime time = LocalTime.now();

    static final int MAX_DOWN = 490;
    static final int FIRST_STAGE = 260;
    static final int SECOND_STAGE = 190;
    static final int THIRD_STAGE = 490;

    boolean enemySeeRight;

    public Characters(AnchorPane pane, ProgressBar healthBar, ProgressBar healthBar2, ProgressBar ammoBar, ProgressBar ammoBar2) {
        this.pane = pane;
        this.healthBar1 = healthBar;
        this.healthBar2 = healthBar2;
        this.ammoBar1 = ammoBar;
        this.ammoBar2 = ammoBar2;


    }

    public String getPlayer1Name() {
        return player1Name;
    }

    public void setPlayer1Name(String player1Name) {
        this.player1Name = player1Name;
    }

    public double getPlayer1Health() {
        return player1Health;
    }

    public void setPlayer1Health(double player1Health) {
        this.player1Health = player1Health;
    }

    public int getPlayer1Speed() {
        return player1Speed;
    }

    public void setPlayer1Speed(int player1Speed) {
        this.player1Speed = player1Speed;
    }

    public AnchorPane getPane() {
        return pane;
    }

    public void setPane(AnchorPane pane) {
        this.pane = pane;
    }

    public ProgressBar getHealthBar1() {
        return healthBar1;
    }

    public void setHealthBar1(ProgressBar healthBar1) {
        this.healthBar1 = healthBar1;
    }

    public ProgressBar getAmmoBar1() {
        return ammoBar1;
    }

    public void setAmmoBar1(ProgressBar ammoBar1) {
        this.ammoBar1 = ammoBar1;
    }

    public int getWidthP1() {
        return widthP1;
    }

    public void setWidthP1(int widthP1) {
        this.widthP1 = widthP1;
    }

    public int getHeightP1() {
        return heightP1;
    }

    public void setHeightP1(int heightP1) {
        this.heightP1 = heightP1;
    }

    public int getxP1() {
        return xP1;
    }

    public void setxP1(int xP1) {
        this.xP1 = xP1;
    }

    public int getyP1() {
        return yP1;
    }

    public void setyP1(int yP1) {
        this.yP1 = yP1;
    }

    public boolean isInJumpP1() {
        return inJumpP1;
    }

    public void setInJumpP1(boolean inJumpP1) {
        this.inJumpP1 = inJumpP1;
    }

    public int getOffSetXP1() {
        return offSetXP1;
    }

    public void setOffSetXP1(int offSetXP1) {
        this.offSetXP1 = offSetXP1;
    }

    public int getOffSetYP1() {
        return offSetYP1;
    }

    public void setOffSetYP1(int offSetYP1) {
        this.offSetYP1 = offSetYP1;
    }

    public boolean isRunLeftP1() {
        return runLeftP1;
    }

    public void setRunLeftP1(boolean runLeftP1) {
        this.runLeftP1 = runLeftP1;
    }

    public boolean isRunRightP1() {
        return runRightP1;
    }

    public void setRunRightP1(boolean runRightP1) {
        this.runRightP1 = runRightP1;
    }

    public void start(){}
    public void move(){}
    public void jump(){}
    public void run(){}
    public void shooting(){}
    public void weapon(){}
    public void bonus(){}
    public void die(){}
}
