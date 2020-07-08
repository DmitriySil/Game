package sample.controllers;


import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import sample.characters.Policeman;
import sample.threads.PoliceThread;

import java.net.URL;
import java.time.LocalTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.concurrent.LinkedBlockingDeque;

public class ControllerGame {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane menuPane;

    @FXML
    private ProgressBar health1;

    @FXML
    private ProgressBar health2;

    @FXML
    private ProgressBar ammunition1;

    @FXML
    private ProgressBar ammunition2;
    private ImageView plateC,plateL,plateUPC,plateUPR,plateUPL;

    private List<ImageView> levelList;
    private LinkedBlockingDeque<BonusImg> bonusDeque;
    BonusImg bonusImg;
    LocalTime time,bonusTime;
    Random random;
    boolean isBonus = false;
    int bonusCount = 0;
    int width = 30;
    int height = 28;
    int pos1x = 20;
    int pos2x ;
    int pos3x;
    int pos1y = 155;
    int pos2y;
    int pos3y;
    @FXML
    void initialize() {
       health1.setStyle("-fx-accent: red;");
       health2.setStyle("-fx-accent: red;");
       ammunition1.setStyle("-fx-accent: grey;");
       ammunition2.setStyle("-fx-accent: grey;");

        plateC = new ImageView("/sample/images/stage/PlateC.png");
        plateC.setViewport(new Rectangle2D(plateC.getLayoutX(),plateC.getLayoutY(),407,26));
        plateC.relocate(343,356);

        plateUPL = new ImageView("/sample/images/stage/PlateLU.png");
        plateUPL.setViewport(new Rectangle2D(plateUPL.getLayoutX(),plateUPL.getLayoutY(),162,22));
        plateUPL.relocate(0,190);

        plateL = new ImageView("/sample/images/stage/PlateL.png");
        plateL.setViewport(new Rectangle2D(plateL.getLayoutX(),plateL.getLayoutY(),244,25));
        plateL.relocate(0,356);

        plateUPC = new ImageView("/sample/images/stage/PlateC.png");
        plateUPC.setViewport(new Rectangle2D(plateUPC.getLayoutX(),plateUPC.getLayoutY(),323,22));
        plateUPC.relocate(351,189);

        plateUPR = new ImageView("/sample/images/stage/PlateR.png");
        plateUPR.setViewport(new Rectangle2D(plateUPR.getLayoutX(),plateUPR.getLayoutY(),163,22));
        plateUPR.relocate(861,189);


        levelList = new LinkedList<>();
        levelList.add(plateC);
        levelList.add(plateL);
        levelList.add(plateUPC);
        levelList.add(plateUPL);
        levelList.add(plateUPR);

//todo добавить панели


        switch (bonusCount) {
            case 0:if (!isBonus){
                System.out.println("bonus create");
                bonusImg = new BonusImg("/sample/images/bonus/HP.png");
                bonusImg.setViewport(new Rectangle2D(0, 0, width, height));
                bonusImg.relocate(pos1x, pos1y);bonusImg.setBonusCat(BonusCat.HP);
                //menuPane.getChildren().add(bonusImg);
                isBonus = true;
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
        menuPane.getChildren().addAll(plateC,plateL,plateUPC,plateUPL,plateUPR,bonusImg);
       // Bonus bonus = new Bonus(bonus,menuPane);







//        BonusThread bonusThread = new BonusThread(bonusImg,menuPane);
//        bonusThread.start();

        if (Controller.player2){
            Policeman policeman = null;
            Policeman terrorist = null;
            policeman = new Policeman(menuPane,health1,ammunition1,levelList,bonusImg);
            //terrorist = new Terrorist(menuPane,health2,ammunition2,levelList);
            System.out.println("police create");
            PoliceThread policeThread = new PoliceThread(policeman);
            policeThread.start();



            //PoliceThread terror = new PoliceThread(terrorist);
            //terror.start();


        }

    }
}
enum BonusCat{
    HP,ARMOR,AMMO
}