package sample.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

public class EscMenu {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView play;

    @FXML
    private ImageView exit;

    @FXML
    void initialize() {

        play.setOnMouseClicked(event -> {
            play.getScene().getWindow().hide();
        });
        exit.setOnMouseClicked(event -> {
            exit.getScene().getWindow().hide();

        });


    }
}