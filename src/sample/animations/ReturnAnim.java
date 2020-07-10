package sample.animations;

import javafx.scene.image.ImageView;

public class ReturnAnim{
    CharacterAnimation animation;
    ImageView imageView;

    public ReturnAnim(CharacterAnimation animation, ImageView imageView) {
        this.animation = animation;
        this.imageView = imageView;
    }

    public CharacterAnimation getAnimation() {
        return animation;
    }

    public void setAnimation(CharacterAnimation animation) {
        this.animation = animation;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

    public CharacterAnimation animation(){
        return animation;
    }
    public ImageView getImageView(){
        return imageView;
    }
}