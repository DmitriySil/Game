package sample.threads;

import javafx.geometry.Rectangle2D;
import javafx.scene.layout.AnchorPane;
import sample.controllers.BonusImg;

import java.time.LocalTime;
import java.util.Random;

public class Bonus{
    BonusImg bonus;
    AnchorPane pane;
    LocalTime time,bonusTime;
    Random random;
    boolean isBonus = false;
    int bonusCount;
    int width = 30;
    int height = 28;
    int pos1x = 20;
    int pos2x ;
    int pos3x;
    int pos1y = 175;
    int pos2y;
    int pos3y;

    public Bonus(BonusImg bonus, AnchorPane pane) {
        this.bonus = bonus;
        this.pane = pane;

    }

    public void start() {

        time = LocalTime.now();
        time = time.plusSeconds(15);

            bonusCount = random.nextInt(3);
            //System.out.println(bonusCount);
            switch (bonusCount) {
                case 0:if (!isBonus){
                    System.out.println("bonus create");
                    bonus = new BonusImg("/sample/images/bonus/HP.png");
                    bonus.setViewport(new Rectangle2D(0, 0, width, height));
                    bonus.relocate(pos1x, pos1y);
                    pane.getChildren().add(bonus);isBonus = true;
                    }
                    break;
                case 1:
                    //System.out.println("1");
                case 2:
                   // System.out.println("2");
            }
//            if (isBonus && time.plusSeconds(30).isBefore(LocalTime.now())){
//                pane.getChildren().remove(bonus);
//                time = LocalTime.now();
//                isBonus = false;
//            }


        }
    }

