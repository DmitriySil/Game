package sample.characters;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import sample.animations.PoliceAnimation;
import sample.controllers.BonusImg;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Policeman extends Characters {
    ImageView playerImg,weapon,enemy;
    Image weapon1R;
    Image weapon1L;
    Image weapon2L;
    Image weapon2R;
    PoliceAnimation animation;
    List<ImageView> levelList;
    List<BulletImg> bulletsR;
    List<BulletImg> bulletsL;
    BonusImg bonusImg;
    public Policeman(AnchorPane pane, ProgressBar healthBar,ProgressBar ammoBar,List<ImageView> levelList,BonusImg bonusImg){
        super(pane,healthBar,ammoBar);
        this.bonusImg = bonusImg;
        this.levelList = levelList;
        this.name = "Policeman";
        this.health = 1.0;
        this.speed = 20;
        this.x = 10;
        this.y = 490;
        this.width = 50;
        this.height = 82;
        this.inJump = false;
        this.canJump = true;
        this.flyDown = false;
        this.flyUp = false;
        this.runLeft = false;
        this.runRight = false;
        this.offSetX = 0;
        this.offSetY = 0;
        this.level = 0;
        this.crossCount = 0;//счетчик пересечений для падения
        this.seeRight = true;
        this.weapon1 = true;//первое оружие




        Image player = new Image(getClass().getResourceAsStream("2_police_Run_002.png"));
        weapon1L = new Image(getClass().getResourceAsStream("weapon1L.png"));
        weapon1R = new Image(getClass().getResourceAsStream("weapon1R.png"));
        weapon2R = new Image(getClass().getResourceAsStream("weapon2R.png"));
        weapon2L = new Image(getClass().getResourceAsStream("weapon2L.png"));
        weapon = new ImageView(weapon1R);
        playerImg = new ImageView(player);
        playerImg.setViewport(new Rectangle2D(0,0,width,height));
        playerImg.relocate(x,y);
        animation = new PoliceAnimation(playerImg,5,6,offSetX,offSetY,width,height, Duration.millis(1000));

       // weapon = new ImageView("/sample/images/police/weapon1R.png");
        weapon.relocate(playerImg.getLayoutX()+26,playerImg.getLayoutY()+44);

        enemy = new ImageView("/sample/images/2_terrorist_2_Run_003.png");
        enemy.setViewport(new Rectangle2D(enemy.getLayoutX(),enemy.getLayoutY(),50,100));
        enemy.relocate(45,260);

        bulletsR = new ArrayList<>();
        bulletsL = new ArrayList<>();
       // pane.getChildren().addAll(playerImg);

    }

    @Override
    public void start() {


        System.out.println("police start");
        pane.getChildren().addAll(playerImg,weapon,enemy);
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (seeRight){weapon.relocate(playerImg.getLayoutX()+26,playerImg.getLayoutY()+44);
                    if (weapon1){weapon.setImage(weapon1R);}if (weapon2){weapon.setImage(weapon2R);}}
                if (seeLeft){weapon.relocate(playerImg.getLayoutX(),playerImg.getLayoutY()+44);
                    if (weapon1){weapon.setImage(weapon1L);}if (weapon2){weapon.setImage(weapon2L);}}

                try {
                    if (playerImg.getBoundsInParent().intersects(bonusImg.getBoundsInParent())){
                        System.out.println("Bonus take");
                        pane.getChildren().remove(bonusImg);
                        System.out.println("bonus remove");
                    }
                }catch (NullPointerException e){}


               move();
                run();
              jump();
              shooting();
            }
        };timer.start();



    }

    @Override
    public void jump() {
        if (inJump && flyUp){
            System.out.println(playerImg.getLayoutY()+" 1c");
            playerImg.relocate(playerImg.getLayoutX(),playerImg.getLayoutY()-8);
        level+=8;
            System.out.println(level+" level");
            if (level >= 230) {
                System.out.println("верх прыжка"); flyUp = false;flyDown = true;
            }
           }

        if (flyDown){
            System.out.println(playerImg.getLayoutY()+" начинаемвниз");
            System.out.println(level+" level");
            playerImg.relocate(playerImg.getLayoutX(),playerImg.getLayoutY()+7);
            level-=7;
            for (ImageView image:levelList){
            if (playerImg.getBoundsInParent().intersects(image.getBoundsInParent()) &&
                    image.getLayoutY()>=playerImg.getLayoutY()+40 && level>=0)
            {playerImg.setY(image.getTranslateY());level=0;
                inJump = false;flyDown = false;canJump = true; System.out.println(level+" level before jump");break;}
            if (playerImg.getLayoutY()<FIRST_STAGE && !playerImg.getBoundsInParent().intersects(image.getBoundsInParent()) && level <=0)
            {level=230;}
            if (playerImg.getLayoutY()>=MAX_DOWN)
            {playerImg.setLayoutY(y);level = 0;inJump = false;flyDown = false;canJump = true;}}
        }
    }

    @Override
    public void run() {
        if (enemySeeRight){enemy.relocate(enemy.getLayoutX()+1,enemy.getLayoutY());}
        if (runLeft) {
            playerImg.relocate(playerImg.getLayoutX()-8,playerImg.getLayoutY());
            for (ImageView image:levelList){
                if (canJump && playerImg.getBoundsInParent().intersects(image.getBoundsInParent()) && playerImg.getLayoutY()<MAX_DOWN)
                    crossCount++;}
            if (playerImg.getLayoutY() != MAX_DOWN && canJump && crossCount == 0) {flyDown = true;canJump = false;}
            crossCount = 0;
        }
        if (runRight){
            playerImg.relocate(playerImg.getLayoutX()+8,playerImg.getLayoutY());
            for (ImageView image:levelList){
                if (canJump && playerImg.getBoundsInParent().intersects(image.getBoundsInParent()) && playerImg.getLayoutY()<MAX_DOWN)
                    crossCount++;}
            if (playerImg.getLayoutY() != MAX_DOWN && canJump && crossCount == 0) {flyDown = true;canJump = false;}
            crossCount = 0;
        }
    }

    @Override
    public void shooting() {
       if (shot){
           bulletsR.forEach(bul->{
               bul.relocate(bul.getLayoutX()+2,bul.getLayoutY());
               if (bul.getLayoutX()>800){removeImgR = bul;
                   System.out.println(bulletsR.size());}
               if (bul.getBoundsInParent().intersects(enemy.getBoundsInParent())){
                   health -= bul.bulletDamage.getDamage();
                   healthBar.setProgress(height);
                   System.out.println(healthBar.getProgress() + health);
               }
           });
           bulletsR.remove(removeImgR);pane.getChildren().remove(removeImgR);

           bulletsL.forEach(bul->{
            bul.relocate(bul.getLayoutX()-2,bul.getLayoutY());
            if (bul.getLayoutX()<0){removeImgL = bul;
                System.out.println(bulletsL.size());}
               if (bul.getBoundsInParent().intersects(enemy.getBoundsInParent())){
                   health -= bul.bulletDamage.getDamage();
                   removeImgL = bul;
                   healthBar.setProgress(health);
                   System.out.println("helthbar"+healthBar.getProgress() +"health"+ health);
               }
        }); bulletsL.remove(removeImgL);pane.getChildren().remove(removeImgL);}

    }

    @Override
    public void move() {
        pane.setOnKeyPressed(event -> {
            if(event.getCode().equals(KeyCode.A)){seeLeft = true;seeRight = false;runLeft = true;
            animation.play();animation.setOffSetY(85);}
            if(event.getCode().equals(KeyCode.D)){seeLeft = false;seeRight = true;runRight = true;
            animation.play();animation.setOffSetY(0);}
            if(event.getCode().equals(KeyCode.W)){}
            if(event.getCode().equals(KeyCode.S)){}
            if (event.getCode().equals(KeyCode.DIGIT1)){
                System.out.println("key1");weapon1=true;weapon2=false;}
            if (event.getCode().equals(KeyCode.DIGIT2)){weapon1=false;weapon2=true;}
            if (event.getCode().equals(KeyCode.RIGHT)){enemySeeRight=true;}

        });
        pane.setOnKeyReleased(event -> {
            if(event.getCode().equals(KeyCode.A)){runLeft = false;animation.stop(); }
            if(event.getCode().equals(KeyCode.D)){runRight = false;animation.stop(); }
            if(event.getCode().equals(KeyCode.W)){if (canJump){inJump =true;flyUp = true;canJump = false;}}
            if(event.getCode().equals(KeyCode.S)){}
            if (event.getCode().equals(KeyCode.RIGHT)){enemySeeRight=false;}
            if(event.getCode().equals(KeyCode.ESCAPE)){
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/sample/fxml/escMenu.fxml"));

                try {
                    loader.load();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
                Parent root = loader.getRoot();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.initOwner(pane.getScene().getWindow());
                stage.showAndWait();}
        });
        pane.setOnMouseClicked(event -> {
            switch (event.getButton()){
                case PRIMARY:if (weapon2){pistolCount=0;}
                    if (pistolCount == 0) {
                        if (weapon1){BulletImg bullet = new BulletImg("/sample/images/police/shot.png");
                            bullet.setBulletDamage(BulletDamage.BULLET);
                            System.out.println(bullet.getBulletDamage().getDamage());
                        bullet.setViewport(new Rectangle2D(bullet.getLayoutX(),bullet.getLayoutY(),10,10));
                        bullet.relocate(playerImg.getLayoutX()+22,playerImg.getLayoutY()+43);pane.getChildren().add(bullet);
                        if (seeRight){ bulletsR.add(bullet);}
                        if (seeLeft){ bulletsL.add(bullet);}
                        shot = true;pistolCount++;}
                        if (weapon2){
                            BulletImg bullet = new BulletImg("/sample/images/police/shot2.png");
                            bullet.setBulletDamage(BulletDamage.BULLET);
                            bullet.setViewport(new Rectangle2D(0,0,10,10));
                            bullet.relocate(playerImg.getLayoutX()+22,playerImg.getLayoutY()+43);pane.getChildren().add(bullet);
                            if (seeRight){ bulletsR.add(bullet);}
                            if (seeLeft){ bulletsL.add(bullet);}
                            shot = true;
                        }
                    }else pistolCount=0;

            }
        });
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
    BULLET(0.02),BULLET_A(0.05);

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