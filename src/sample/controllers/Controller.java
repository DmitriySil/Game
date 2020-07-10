package sample.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
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
    private ImageView exit;

    @FXML
    private ImageView settings;

    @FXML
    private ImageView police;

    @FXML
    private ImageView terror;
    static boolean player1 = false;
    static boolean player2 = false;

    @FXML
    void initialize() {

        play.setOnMouseClicked(event -> {
            player2=true;

           play.getScene().getWindow().hide();
            try {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/sample/fxml/stage.fxml"));
                AnchorPane game = loader.load();
                Stage gameStage = new Stage();
                gameStage.initOwner(play.getScene().getWindow());
                gameStage.setScene(new Scene(game));
                gameStage.showAndWait();

            }
            catch (IOException e) {
                e.printStackTrace();
            }

        });

        settings.setOnMouseClicked(event -> {
            try {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/sample/fxml/settings.fxml"));
                loader.load();
                Parent root = loader.getRoot();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.showAndWait();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        });
        exit.setOnMouseClicked(event -> {
            System.exit(0);
        });
    }

}



