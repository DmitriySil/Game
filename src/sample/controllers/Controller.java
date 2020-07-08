package sample.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;


public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane menuPane;

    @FXML
    private ImageView play;

    @FXML
    private ImageView settings;

    @FXML
    private Button startButton;
    static boolean player1 = false;
    static boolean player2 = false;

    @FXML
    void initialize() {
       // assert playGame != null : "fx:id=\"playGame\" was not injected: check your FXML file 'sample.fxml'.";
        ImageView img = new ImageView("/sample/images/police_Jump.png");
        img.relocate(100,100);

        menuPane.getChildren().addAll(img);
        menuPane.setOnKeyPressed(event -> {
            System.out.println("d");
            switch (event.getCode()){
                case DOWN:img.relocate(img.getLayoutX()+15,img.getLayoutY());
            }
        });

        play.setOnMouseClicked(event -> {
            player2=true;
            startButton.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/fxml/stage.fxml"));

            try {
                loader.load();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });

        startButton.setOnAction(event -> {
            player2=true;
            startButton.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/fxml/stage.fxml"));

            try {
                loader.load();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });
    }
}



