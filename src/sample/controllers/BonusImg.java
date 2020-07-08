package sample.controllers;

import javafx.scene.image.ImageView;

public class BonusImg extends ImageView {
    BonusCat bonusCat;

    public BonusImg(String url) {
        super(url);
    }

    public BonusCat getBonusCat() {
        return bonusCat;
    }

    public void setBonusCat(BonusCat bonusCat) {
        this.bonusCat = bonusCat;
    }
}