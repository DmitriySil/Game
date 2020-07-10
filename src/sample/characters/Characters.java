package sample.characters;

import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import sample.animations.CharacterAnimation;


import java.time.LocalTime;
import java.util.List;

abstract public class Characters {
    ImageView player1Img,player2Img, weaponP1, weaponP2;
    Image weapon1R;
    Image weapon1L;
    Image weapon2L;
    Image weapon2R;
    BonusImg bonusImg;
    CharacterAnimation animation,animation2;
    List<ImageView> levelList;
    List<BulletImg> bulletsRP1;
    List<BulletImg> bulletsRP2;
    List<BulletImg> bulletsLP1;
    List<BulletImg> bulletsLP2;
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
    Label countKillP1;
    Label countKillP2;
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

    int countKP1 = 0;
    int countKP2 = 0;

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

    public Characters(AnchorPane pane, ProgressBar healthBar, ProgressBar healthBar2, ProgressBar ammoBar, ProgressBar ammoBar2,
                      List<ImageView> levelList,Label countKillP1,Label countKillP2) {
        this.pane = pane;
        this.healthBar1 = healthBar;
        this.healthBar2 = healthBar2;
        this.ammoBar1 = ammoBar;
        this.ammoBar2 = ammoBar2;
        this.levelList = levelList;
        this.countKillP1 = countKillP1;
        this.countKillP2 = countKillP2;


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
