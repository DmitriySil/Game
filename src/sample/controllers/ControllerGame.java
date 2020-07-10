package sample.controllers;


import javafx.fxml.FXML;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import sample.characters.TwoPlayers;

import sample.threads.PVPThread;


import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

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
    @FXML
    private Label player1Name;

    @FXML
    private Label player2Name;

    @FXML
    private Label killP1;

    @FXML
    private Label countKillP1;

    @FXML
    private Label killP2;

    @FXML
    private Label countKillP2;
    private ImageView plateC,plateL,plateUPC,plateUPR,plateUPL;

    private List<ImageView> levelList;

    @FXML
    void initialize() {
       health1.setStyle("-fx-accent: red;");
       health2.setStyle("-fx-accent: red;");
       ammunition1.setStyle("-fx-accent: grey;");
       ammunition2.setStyle("-fx-accent: grey;");

       if (Settings.policeP1){player1Name.setText("Police");}
       if (Settings.terroristP1){player1Name.setText("Terrorist");}
       if (Settings.terroristP2){player2Name.setText("Terrorist");}
       if (Settings.policeP2){player2Name.setText("Police");}

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
            TwoPlayers pvp = null;
            pvp = new TwoPlayers(menuPane,health1,health2,ammunition1,ammunition2,levelList,countKillP1,countKillP2);
            System.out.println(" create");
            PVPThread pvpThread = new PVPThread(pvp);
            pvpThread.start();
        }
    }
}
