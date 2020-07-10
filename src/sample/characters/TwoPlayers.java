package sample.characters;

import javafx.animation.AnimationTimer;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import sample.animations.CharacterAnimation;
import sample.animations.PlayerAnimation;
import sample.animations.ReturnAnim;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


public class TwoPlayers extends Characters{

    public TwoPlayers(AnchorPane pane, ProgressBar healthBar, ProgressBar healthBar2, ProgressBar ammoBar, ProgressBar ammoBar2,
                      List<ImageView> levelList, Label countKillP1,Label countKillP2){
        super(pane,healthBar,healthBar2,ammoBar,ammoBar2,levelList,countKillP1,countKillP2);
        this.levelList = levelList;
        this.player1Name = "Policeman";
        this.player1Health = 1.0;
        this.player1Speed = 20;
        this.xP1 = 10;
        this.xP2 = 800;
        this.yP1 = 490;
        this.yP2 = 490;
        this.widthP1 = 50;
        this.widthP2 = 50;
        this.heightP1 = 82;
        this.heightP2 = 85;
        this.inJumpP1 = false;
        this.canJumpP1 = true;
        this.flyDownP1 = false;
        this.flyUpP1 = false;
        this.runLeftP1 = false;
        this.runRightP1 = false;
        this.offSetXP1 = 0;
        this.offSetXP2 = 0;
        this.offSetYP1 = 0;
        this.offSetYP2 = 85;
        this.levelP1 = 0;
        this.crossCountP1 = 0;//счетчик пересечений для падения
        this.seeRightP1 = true;
        this.weapon1P1 = true;//первое оружие





        weapon1L = new Image(getClass().getResourceAsStream("weapon1L.png"));
        weapon1R = new Image(getClass().getResourceAsStream("weapon1R.png"));
        weapon2R = new Image(getClass().getResourceAsStream("weapon2R.png"));
        weapon2L = new Image(getClass().getResourceAsStream("weapon2L.png"));
        weaponP1 = new ImageView(weapon1R);
        weaponP2 = new ImageView(weapon1R);

        PlayerAnimation player1Animation = new PlayerAnimation(pane);
        ReturnAnim player1 = player1Animation.player1();
        player1Img = player1.getImageView();
        animation = player1.getAnimation();

        PlayerAnimation player2Animation = new PlayerAnimation(pane);
        ReturnAnim player2 = player2Animation.player2();
        player2Img = player2.getImageView();
        animation2 = player2.getAnimation();

        //Image player = new Image(getClass().getResourceAsStream("2_police_Run_002.png"));
       // Image player2 = new Image(getClass().getResourceAsStream("Terrorist_Run.png"));
      //  player1Img = new ImageView(player);
        //player2Img = new ImageView(player2);
       // player1Img.setViewport(new Rectangle2D(0,0, widthP1, heightP1));
        //player2Img.setViewport(new Rectangle2D(0,0, widthP2, heightP2));
      //  player1Img.relocate(xP1, yP1);
        //player2Img.relocate(xP2, yP2);
      //  animation = new CharacterAnimation(player1Img,5,6, offSetXP1, offSetYP1, widthP1, heightP1, Duration.millis(1000));
       // animation2 = new CharacterAnimation(player2Img,5,6, offSetXP2, offSetYP2, widthP2, heightP2, Duration.millis(1000));



        weaponP1.relocate(player1Img.getLayoutX()+26, player1Img.getLayoutY()+44);
        weaponP2.relocate(player2Img.getLayoutX()+26, player2Img.getLayoutY()+44);

        bulletsRP1 = new ArrayList<>();
        bulletsRP2 = new ArrayList<>();
        bulletsLP1 = new ArrayList<>();
        bulletsLP2 = new ArrayList<>();


    }

    @Override
    public void start() {
        System.out.println("start");
        pane.getChildren().addAll(player1Img,player2Img, weaponP1, weaponP2);
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
               move();run();jump();shooting();weapon();bonus();die();

            }
        };timer.start();
    }

    @Override
    public void weapon() {
        //todo Player1
        if (seeRightP1){
            weaponP1.relocate(player1Img.getLayoutX()+26, player1Img.getLayoutY()+44);
            if (weapon1P1){
                weaponP1.setImage(weapon1R);}if (weapon2P1){
                weaponP1.setImage(weapon2R);}}
        if (seeLeftP1){
            weaponP1.relocate(player1Img.getLayoutX(), player1Img.getLayoutY()+44);
            if (weapon1P1){
                weaponP1.setImage(weapon1L);}if (weapon2P1){
                weaponP1.setImage(weapon2L);}}

        //todo Player2
        if (seeRightP2){
            weaponP2.relocate(player2Img.getLayoutX()+26, player2Img.getLayoutY()+44);
            if (weapon1P2){
                weaponP2.setImage(weapon1R);}if (weapon2P2){
                weaponP2.setImage(weapon2R);}}
        if (seeLeftP2){
            weaponP2.relocate(player2Img.getLayoutX(), player2Img.getLayoutY()+44);
            if (weapon1P2){
                weaponP2.setImage(weapon1L);}if (weapon2P2){
                weaponP2.setImage(weapon2L);}}
    }

    @Override
    public void run() {
        //todo Player1
        if (runLeftP1) {
            player1Img.relocate(player1Img.getLayoutX()-8, player1Img.getLayoutY());
            for (ImageView image:levelList){
                if (canJumpP1 && player1Img.getBoundsInParent().intersects(image.getBoundsInParent()) && player1Img.getLayoutY()<MAX_DOWN)
                    crossCountP1++;}
            if (player1Img.getLayoutY() != MAX_DOWN && canJumpP1 && crossCountP1 == 0) {
                flyDownP1 = true;
                canJumpP1 = false;}
            crossCountP1 = 0;
        }
        if (runRightP1){
            player1Img.relocate(player1Img.getLayoutX()+8, player1Img.getLayoutY());
            for (ImageView image:levelList){
                if (canJumpP1 && player1Img.getBoundsInParent().intersects(image.getBoundsInParent()) && player1Img.getLayoutY()<MAX_DOWN)
                    crossCountP1++;}
            if (player1Img.getLayoutY() != MAX_DOWN && canJumpP1 && crossCountP1 == 0) {
                flyDownP1 = true;
                canJumpP1 = false;}
            crossCountP1 = 0;
        }
        //todo Player2
        if (runLeftP2) {
            player2Img.relocate(player2Img.getLayoutX()-8, player2Img.getLayoutY());
            for (ImageView image:levelList){
                if (canJumpP2 && player2Img.getBoundsInParent().intersects(image.getBoundsInParent()) && player2Img.getLayoutY()<MAX_DOWN)
                    crossCountP2++;}
            if (player2Img.getLayoutY() != MAX_DOWN && canJumpP2 && crossCountP2 == 0) {
                flyDownP2 = true;
                canJumpP2 = false;}
            crossCountP2 = 0;
        }
        if (runRightP2){
            player2Img.relocate(player2Img.getLayoutX()+8, player2Img.getLayoutY());
            for (ImageView image:levelList){
                if (canJumpP2 && player2Img.getBoundsInParent().intersects(image.getBoundsInParent()) && player2Img.getLayoutY()<MAX_DOWN)
                    crossCountP2++;}
            if (player2Img.getLayoutY() != MAX_DOWN && canJumpP2 && crossCountP2 == 0) {
                flyDownP2 = true;
                canJumpP2 = false;}
            crossCountP2 = 0;
        }
    }

    @Override
    public void jump() {
        //todo Player1
        if (inJumpP1 && flyUpP1){
            System.out.println(player1Img.getLayoutY()+" 1c");
            player1Img.relocate(player1Img.getLayoutX(), player1Img.getLayoutY()-8);
        levelP1 +=8;
            System.out.println(levelP1 +" level");
            if (levelP1 >= 230) {
                System.out.println("верх прыжка"); flyUpP1 = false;
                flyDownP1 = true; } }
//падение
        if (flyDownP1){
            System.out.println(player1Img.getLayoutY()+" начинаемвниз");
            System.out.println(levelP1 +" level");
            player1Img.relocate(player1Img.getLayoutX(), player1Img.getLayoutY()+7);
            levelP1 -=7;
            for (ImageView image:levelList){
            if (player1Img.getBoundsInParent().intersects(image.getBoundsInParent()) &&
                    image.getLayoutY()>= player1Img.getLayoutY()+40 && levelP1 >=0)
            {
                player1Img.setY(image.getTranslateY());
                levelP1 =0;
                inJumpP1 = false;
                flyDownP1 = false;
                canJumpP1 = true; System.out.println(levelP1 +" level before jump");break;}
            if (player1Img.getLayoutY()<FIRST_STAGE && !player1Img.getBoundsInParent().intersects(image.getBoundsInParent()) && levelP1 <=0)
            {
                levelP1 =230;}
            if (player1Img.getLayoutY()>=MAX_DOWN)
            {
                player1Img.setLayoutY(yP1);
                levelP1 = 0;
                inJumpP1 = false;
                flyDownP1 = false;
                canJumpP1 = true;}}
        }
        //todo Player2
        if (inJumpP2 && flyUpP2){
            System.out.println(player2Img.getLayoutY()+" 1c");
            player2Img.relocate(player2Img.getLayoutX(), player2Img.getLayoutY()-8);
            levelP2 +=8;
            System.out.println(levelP2 +" level");
            if (levelP2 >= 230) {
                System.out.println("верх прыжка"); flyUpP2 = false;
                flyDownP2 = true; } }
//падение
        if (flyDownP2){
            System.out.println(player2Img.getLayoutY()+" начинаемвниз");
            System.out.println(levelP2 +" level");
            player2Img.relocate(player2Img.getLayoutX(), player2Img.getLayoutY()+7);
            levelP2 -=7;
            for (ImageView image:levelList){
                if (player2Img.getBoundsInParent().intersects(image.getBoundsInParent()) &&
                        image.getLayoutY()>= player2Img.getLayoutY()+40 && levelP2 >=0)
                {
                    player2Img.setY(image.getTranslateY());
                    levelP2 =0;
                    inJumpP2 = false;
                    flyDownP2 = false;
                    canJumpP2 = true; System.out.println(levelP2 +" level before jump");break;}
                if (player2Img.getLayoutY()<FIRST_STAGE && !player2Img.getBoundsInParent().intersects(image.getBoundsInParent()) && levelP2 <=0)
                {
                    levelP2 =230;}
                if (player2Img.getLayoutY()>=MAX_DOWN)
                {
                    player2Img.setLayoutY(yP2);
                    levelP2 = 0;
                    inJumpP2 = false;
                    flyDownP2 = false;
                    canJumpP2 = true;}}
        }
    }

    @Override
    public void shooting() {
        //todo Player1
       if (shotP1){
           bulletsRP1.forEach(bul->{
               bul.relocate(bul.getLayoutX()+7,bul.getLayoutY());
               if (bul.getLayoutX()>1000){
                   removeImgRP1 = bul;
                   System.out.println(bulletsRP1.size());}
               if (bul.getBoundsInParent().intersects(player2Img.getBoundsInParent())){
                   player2Health -= bul.bulletDamage.getDamage();
                   removeImgRP1 = bul;
                   healthBar2.setProgress(player2Health);
                   System.out.println(healthBar2.getProgress() + player2Health);
               }
           });
           bulletsRP1.remove(removeImgRP1);pane.getChildren().remove(removeImgRP1);

           bulletsLP1.forEach(bul->{
            bul.relocate(bul.getLayoutX()-7,bul.getLayoutY());
            if (bul.getLayoutX()<0){
                removeImgLP1 = bul;
                System.out.println(bulletsLP1.size());}
               if (bul.getBoundsInParent().intersects(player2Img.getBoundsInParent())){
                   player2Health -= bul.bulletDamage.getDamage();
                   removeImgLP1 = bul;
                   healthBar2.setProgress(player2Health);
                   System.out.println("helthbar"+ healthBar2.getProgress() +"health"+ player2Health);
               }
        }); bulletsLP1.remove(removeImgLP1);pane.getChildren().remove(removeImgLP1);}
        //todo Player2
        if (shotP2){
            bulletsRP2.forEach(bul->{
                bul.relocate(bul.getLayoutX()+7,bul.getLayoutY());
                if (bul.getLayoutX()>1000){
                    removeImgRP2 = bul;
                    System.out.println(bulletsRP2.size());}
                if (bul.getBoundsInParent().intersects(player1Img.getBoundsInParent())){
                    player1Health -= bul.bulletDamage.getDamage();
                    removeImgRP2 = bul;
                    healthBar1.setProgress(player1Health);
                    System.out.println(healthBar1.getProgress() + player1Health);//fixme
                }
            });
            bulletsRP2.remove(removeImgRP2);pane.getChildren().remove(removeImgRP2);

            bulletsLP2.forEach(bul->{
                bul.relocate(bul.getLayoutX()-7,bul.getLayoutY());
                if (bul.getLayoutX()<0){
                    removeImgLP2 = bul;
                    System.out.println(bulletsLP2.size());}
                if (bul.getBoundsInParent().intersects(player1Img.getBoundsInParent())){
                    player1Health -= bul.bulletDamage.getDamage();
                    removeImgLP2 = bul;
                    healthBar1.setProgress(player1Health);
                    System.out.println("helthbar"+ healthBar1.getProgress() +"health"+ player1Health);
                }
            }); bulletsLP2.remove(removeImgLP2);pane.getChildren().remove(removeImgLP2);}
    }
//todo
    @Override
    public void move() {
        pane.setOnKeyPressed(event -> {
            switch (event.getCode()){
                case A:{
                    seeLeftP1 = true;
                    seeRightP1 = false;
                    runLeftP1 = true;
                    animation.play();animation.setOffSetY(85);}break;
                case D:{
                    seeLeftP1 = false;
                    seeRightP1 = true;
                    runRightP1 = true;
                    animation.play();animation.setOffSetY(0);}break;
                case W:break;
                case S:break;
                case DIGIT1:{
                    System.out.println("key1");
                    weapon1P1 =true;
                    weapon2P1 =false;}break;
                case DIGIT2:{
                    weapon1P1 =false;
                    weapon2P1 =true;}break;
                //player2
                case RIGHT:{
                    seeLeftP2 = false;
                    seeRightP2 = true;
                    runRightP2 = true;
                    animation2.play();animation2.setOffSetY(0);}break;
                case LEFT:{
                    seeLeftP2 = true;
                    seeRightP2 = false;
                    runLeftP2 = true;
                    animation2.play();animation2.setOffSetY(85);}break;
                case UP:break;
                case DOWN:break;
                case DIGIT9:{
                    System.out.println("key1");
                    weapon1P2 =true;
                    weapon2P2 =false;}break;
                case DIGIT0:{
                    weapon1P2 =false;
                    weapon2P2 =true;}break;
                case CONTROL: if (weapon2P2){
                    pistolCountP2 =0;}
                    if (pistolCountP2 == 0) {
                        if (weapon1P2){BulletImg bullet2 = new BulletImg("/sample/images/police/shot.png");
                            bullet2.setBulletDamage(BulletDamage.BULLET);
                            System.out.println(bullet2.getBulletDamage().getDamage());
                            bullet2.setViewport(new Rectangle2D(bullet2.getLayoutX(),bullet2.getLayoutY(),10,10));
                            bullet2.relocate(player2Img.getLayoutX()+22, player2Img.getLayoutY()+43);pane.getChildren().add(bullet2);
                            if (seeRightP2)
                            { bulletsRP2.add(bullet2);}
                            if (seeLeftP2)
                            { bulletsLP2.add(bullet2);}//todo
                            shotP2 = true;
                            pistolCountP2++;}
                        if (weapon2P2){
                            BulletImg bullet = new BulletImg("/sample/images/police/shot2.png");
                            bullet.setBulletDamage(BulletDamage.BULLET_A);
                            bullet.setViewport(new Rectangle2D(0,0,10,10));
                            bullet.relocate(player2Img.getLayoutX()+22, player2Img.getLayoutY()+43);pane.getChildren().add(bullet);
                            if (seeRightP2){ bulletsRP2.add(bullet);}
                            if (seeLeftP2){ bulletsLP2.add(bullet);}
                            shotP2 = true;
                        }
                    }else pistolCountP2 =0;break;
            }
        });
        pane.setOnKeyReleased(event -> {
            switch (event.getCode()){
                case A:{
                    runLeftP1 = false;animation.stop(); }break;
                case D:{
                    runRightP1 = false;animation.stop(); }break;
                case W:{if (canJumpP1){
                    inJumpP1 =true;
                    flyUpP1 = true;
                    canJumpP1 = false;}}break;
                case S:break;
                    //Player2
                case LEFT:{
                    runLeftP2 = false;animation2.stop(); }break;
                case RIGHT:{
                    runRightP2 = false;animation2.stop(); }break;
                case UP:{if (canJumpP2){
                    inJumpP2 =true;
                    flyUpP2 = true;
                    canJumpP2 = false;}}break;
                case DOWN:break;
                case ESCAPE:{ }break;
            }
        });
        pane.setOnMouseClicked(event -> {
            switch (event.getButton()){
                case PRIMARY:if (weapon2P1){
                    pistolCountP1 =0;}
                    if (pistolCountP1 == 0) {
                        if (weapon1P1){BulletImg bullet = new BulletImg("/sample/images/police/shot.png");
                            bullet.setBulletDamage(BulletDamage.BULLET);
                            System.out.println(bullet.getBulletDamage().getDamage());
                        bullet.setViewport(new Rectangle2D(bullet.getLayoutX(),bullet.getLayoutY(),10,10));
                        bullet.relocate(player1Img.getLayoutX()+22, player1Img.getLayoutY()+43);pane.getChildren().add(bullet);
                        if (seeRightP1){ bulletsRP1.add(bullet);}
                        if (seeLeftP1){ bulletsLP1.add(bullet);}
                        shotP1 = true;
                            pistolCountP1++;}
                        if (weapon2P1){
                            BulletImg bullet = new BulletImg("/sample/images/police/shot2.png");
                            bullet.setBulletDamage(BulletDamage.BULLET_A);
                            bullet.setViewport(new Rectangle2D(0,0,10,10));
                            bullet.relocate(player1Img.getLayoutX()+22, player1Img.getLayoutY()+43);pane.getChildren().add(bullet);
                            if (seeRightP1){ bulletsRP1.add(bullet);}
                            if (seeLeftP1){ bulletsLP1.add(bullet);}
                            shotP1 = true;
                        }
                    }else pistolCountP1 =0;break;

            }
        });
    }

    @Override
    public void die() {
        if (player2Health <= 0 && seeLeftP2 && !dieP2){
            countKP1++;
            countKillP1.setText(String.valueOf(countKP1));
            //canJumpP2 = false;runLeftP2 = false;
            dieTime = LocalTime.now();
            dieP2 = true;
            Image player2Die = new Image(getClass().getResourceAsStream("Terrorist_Die.png"));
            player2Img.setImage(player2Die);animation2.setWidth(80);animation2.setColumns(5);animation.setCount(5);
            animation2.setDuration(Duration.millis(1800));animation2.play();
        }
        if (dieP2 && dieTime.plusNanos(900000000).isBefore(LocalTime.now())){animation2.stop();pane.getChildren().remove(weaponP2);}
        if (dieP2 && dieTime.plusSeconds(5).isBefore(LocalTime.now())){pane.getChildren().remove(player2Img);}
        if (dieP2 && dieTime.plusSeconds(7).isBefore(LocalTime.now())){
            player2Health = 1.0;healthBar2.setProgress(player2Health);dieP2 = false;
            PlayerAnimation player2Animation = new PlayerAnimation(pane);
            ReturnAnim player2 = player2Animation.player2();
            player2Img = player2.getImageView();
            animation2 = player2.getAnimation();
            pane.getChildren().addAll(player2Img,weaponP2);
        }
    }

    @Override
    public void bonus() {
        if (time.plusSeconds(10).isBefore(LocalTime.now())){
        switch (bonusCount) {
            case 0:if (!isBonus ){
                System.out.println("bonus create");
                bonusImg = new BonusImg("/sample/images/bonus/HP.png");
                bonusImg.setViewport(new Rectangle2D(0, 0, bonusWidth, bonusHeight));
                bonusImg.relocate(bonusPos1x, bonusPos1y);bonusImg.setBonusCat(BonusCat.HP);
                pane.getChildren().add(bonusImg);
                isBonus = true;
            }
                break;
            case 1:
                //System.out.println("1");
            case 2:
                // System.out.println("2");
        }}
        try {
            if (player1Img.getBoundsInParent().intersects(bonusImg.getBoundsInParent())){
                System.out.println("Bonus take");
                if (player1Health<=0.7){player1Health+=bonusImg.bonusCat.getPlus();}
                else player1Health = 1.0;
                healthBar1.setProgress(player1Health);
                bonusImg.relocate(0,490);
                bonusImg.setDisable(true);
                time = time.plusSeconds(10);
                pane.getChildren().remove(bonusImg);
                System.out.println("bonus remove");
                isBonus = false;
            }
        }catch (NullPointerException e){}
    }
}
class BulletImg extends ImageView{
    BulletDamage bulletDamage;

    public BulletImg(String url) {
        super(url);
    }

    public BulletDamage getBulletDamage() {
        return bulletDamage;
    }

    public void setBulletDamage(BulletDamage bulletDamage) {
        this.bulletDamage = bulletDamage;
    }
}
enum BulletDamage{
    BULLET(0.02),BULLET_A(0.5);

   private double damage;

    BulletDamage(double damage) {
        this.damage = damage;
    }

    public double getDamage() {
        return damage;
    }

    public void setDamage(double damage) {
        this.damage = damage;
    }
}
enum BonusCat{
    HP(0.3),ARMOR(0.3),AMMO(0.3);

    private double plus;

    public double getPlus() {
        return plus;
    }

    public void setPlus(double plus) {
        this.plus = plus;
    }

    BonusCat(double plus) {
        this.plus = plus;


    }
}
class BonusImg extends ImageView {
    BonusCat bonusCat;

    public BonusImg(String url) {
        super(url);
    }

    public BonusCat getBonusCat() {
        return bonusCat;
    }

    public void setBonusCat(BonusCat bonusCat) {
        this.bonusCat = bonusCat; }}