package sample.controllers;



import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;

public class Settings {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView police;

    @FXML
    private ImageView terrorist;

    @FXML
    private RadioButton policeChoice;

    @FXML
    private ToggleGroup player_1;


    @FXML
    private RadioButton terrorChoice;

    @FXML
    private ImageView ok;

    @FXML
    private RadioButton policeChoiceP2;

    @FXML
    private ToggleGroup player_2;

    @FXML
    private RadioButton terrorChoiceP2;

    public static boolean policeP1 = true;
    public static boolean policeP2;
    public static boolean terroristP1;
    public static boolean terroristP2 = true;

    @FXML
    void initialize() {


        if (policeChoiceP2.isSelected()){policeP2 = true;}
        if (terrorChoiceP2.isSelected()){terroristP2 = true;}


        policeChoice.setOnMouseClicked(event -> {
            if (policeChoice.isSelected()){policeP1 = true;terroristP1 = false;System.out.println("p1 pol");}
        });
        terrorChoice.setOnMouseClicked(event -> {
            if (terrorChoice.isSelected()){terroristP1 = true;policeP1 = false;System.out.println("p1 ter");}
        });
        terrorChoiceP2.setOnMouseClicked(event -> {
            if (terrorChoiceP2.isSelected()){terroristP2 = true;policeP2 = false;System.out.println("p2 ter");}
        });
        policeChoiceP2.setOnMouseClicked(event -> {
            if (policeChoiceP2.isSelected()){terroristP2 = false;policeP2 = true;System.out.println("p2 pol");}
        });
        ok.setOnMouseClicked(event -> {
        ok.getScene().getWindow().hide();
        });


    }
}