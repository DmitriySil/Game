package sample.characters;

import javafx.animation.AnimationTimer;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import sample.animations.PoliceAnimation;
import sample.controllers.BonusImg;

import java.util.ArrayList;
import java.util.List;

public class Terrorist extends Policeman {

    public Terrorist(AnchorPane pane, ProgressBar healthBar, ProgressBar ammoBar, List<ImageView> levelList, BonusImg bonusImg) throws InterruptedException {
        super(pane, healthBar, ammoBar, levelList,bonusImg);
        this.levelList = levelList;
        this.name = "Terrorist";
        this.health = 1.0;
        this.speed = 20;
        this.x = 900;
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
        this.offSetY = 85;
        this.level = 0;
        this.crossCount = 0;
        this.seeRight = true;

        Image player = new Image(getClass().getResourceAsStream("2_police_Run_002.png"));
        playerImg = new ImageView(player);
        playerImg.setViewport(new Rectangle2D(0,0,width,height));
        playerImg.relocate(x,y);
        animation = new PoliceAnimation(playerImg,5,6,offSetX,offSetY,width,height, Duration.millis(1000));

        bulletsR = new ArrayList<>();
        bulletsL = new ArrayList<>();
       // pane.getChildren().addAll(playerImg);
    }

    @Override
    public void start() {
        System.out.println("terrorist start");
        pane.getChildren().addAll(playerImg);
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                move();
                run();
                jump();
                shooting();
            }
        };timer.start();


    }

    @Override
    public void jump() {
        super.jump();
    }

    @Override
    public void run() {
        super.run();
    }

    @Override
    public void shooting() {
        super.shooting();
    }

    @Override
    public void move() {
        pane.setOnKeyPressed(event -> {
            if(event.getCode().equals(KeyCode.LEFT)){seeLeft = true;seeRight = false;runLeft = true;animation.play();animation.setOffSetY(85); }
            if(event.getCode().equals(KeyCode.RIGHT)){seeLeft = false;seeRight = true;runRight = true;animation.play();animation.setOffSetY(0); }
            if(event.getCode().equals(KeyCode.UP)){}
            if(event.getCode().equals(KeyCode.DOWN)){}
        });
        pane.setOnKeyReleased(event -> {
            if(event.getCode().equals(KeyCode.LEFT)){runLeft = false;animation.stop(); }
            if(event.getCode().equals(KeyCode.RIGHT)){runRight = false;animation.stop(); }
            if(event.getCode().equals(KeyCode.UP)){if (canJump){inJump =true;flyUp = true;canJump = false;}}
            if(event.getCode().equals(KeyCode.DOWN)){}
        });
        pane.setOnMouseClicked(event -> {
            switch (event.getButton()){
                case PRIMARY:if (weapon2){pistolCount=0;}
                    if (pistolCount == 0) {
                        if (weapon1){BulletImg bullet = new BulletImg("/sample/images/police/shot.png");
                            bullet.setBulletDamage(BulletDamage.BULLET);
                            bullet.setViewport(new Rectangle2D(0,0,10,10));
                            bullet.relocate(playerImg.getLayoutX()+22,playerImg.getLayoutY()+40);pane.getChildren().add(bullet);
                            if (seeRight){ bulletsR.add(bullet);}
                            if (seeLeft){ bulletsL.add(bullet);}
                            shot = true;pistolCount++;}
                        if (weapon2){
                            BulletImg bullet = new BulletImg("/sample/images/police/shot2.png");
                            bullet.setBulletDamage(BulletDamage.BULLET);
                            bullet.setViewport(new Rectangle2D(0,0,10,10));
                            bullet.relocate(playerImg.getLayoutX()+22,playerImg.getLayoutY()+40);pane.getChildren().add(bullet);
                            if (seeRight){ bulletsR.add(bullet);}
                            if (seeLeft){ bulletsL.add(bullet);}
                            shot = true;
                        }
                    }else pistolCount=0;

            }
        });
    }
}
