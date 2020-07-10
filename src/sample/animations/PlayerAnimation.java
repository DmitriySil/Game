package sample.animations;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import sample.controllers.Settings;

public class PlayerAnimation {
    Image player,player2;
    ImageView player1Img,player2Img;
    int widthPolice = 50;
    int heightPolice = 82;
    int widthTerror = 50;
    int heightTerror = 85;

    int xP1 = 10;
    int yP1 = 490;
    int xT1 = 10;
    int yT1 = 490;

    int xP2 = 900;
    int yP2 = 490;
    int xT2 = 900;
    int yT2 = 490;

    int offSetXP1 = 0;
    int offSetYP1 = 0;
    int offSetXP2 = 0;
    int offSetYP2 = 85;
    CharacterAnimation animation,animation2;

    public PlayerAnimation(AnchorPane pane) {

    }

    public ReturnAnim player1(){
if (Settings.policeP1){
        Image police = new Image(getClass().getResourceAsStream("2_police_Run_002.png"));
        player1Img = new ImageView(police);
        player1Img.setViewport(new Rectangle2D(0,0, widthPolice, heightPolice));
        player1Img.relocate(xP1, yP1);
        animation = new CharacterAnimation(player1Img,5,6, offSetXP1, offSetYP1, widthPolice, heightPolice, Duration.millis(1000));
       }
if (Settings.terroristP1){
    Image terrorist = new Image(getClass().getResourceAsStream("Terrorist_Run.png"));
    player1Img = new ImageView(terrorist);
    player1Img.setViewport(new Rectangle2D(0,0, widthTerror, heightTerror));
    player1Img.relocate(xT1, yT1);
    animation = new CharacterAnimation(player1Img,5,6, offSetXP1, offSetYP1, widthTerror, heightTerror, Duration.millis(1000));
}
    return new ReturnAnim(animation,player1Img);
    }

    public ReturnAnim player2(){
        if (Settings.policeP2){
            Image police = new Image(getClass().getResourceAsStream("2_police_Run_002.png"));
            player2Img = new ImageView(police);
            player2Img.setViewport(new Rectangle2D(0,0, widthPolice, heightPolice));
            player2Img.relocate(xP2, yP2);
            animation2 = new CharacterAnimation(player2Img,5,6, offSetXP2, offSetYP2, widthPolice, heightPolice, Duration.millis(1000));
        }
        if (Settings.terroristP2){
            Image terrorist = new Image(getClass().getResourceAsStream("Terrorist_Run.png"));
            player2Img = new ImageView(terrorist);
            player2Img.setViewport(new Rectangle2D(0,0, widthTerror, heightTerror));
            player2Img.relocate(xT2, yT2);
            animation2 = new CharacterAnimation(player2Img,5,6, offSetXP2, offSetYP2, widthTerror, heightTerror, Duration.millis(1000));
        }
        return new ReturnAnim(animation2,player2Img);
    }
}

