package sample.controllers;


import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import sample.characters.PlayerVsPlayer;

import sample.threads.PVsPThread;


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




        menuPane.getChildren().addAll(plateC,plateL,plateUPC,plateUPL,plateUPR);


        if (Controller.player2){
            PlayerVsPlayer pvp = null;
            pvp = new PlayerVsPlayer(menuPane,health1,health2,ammunition1,ammunition2,levelList);
            System.out.println(" create");
            PVsPThread pVsPThread = new PVsPThread(pvp);
            pVsPThread.start();
        }
    }
}
