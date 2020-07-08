package sample.animations;

import javafx.animation.Interpolator;
import javafx.animation.Transition;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.util.Duration;




public class PoliceAnimation extends Transition {
    private final ImageView imageView;
    private final int count;
    private final int columns;
    private int offSetX;
    private int offSetY;
    private final int width;
    private final int height;

    public PoliceAnimation(ImageView imageView, int count, int columns, int offSetX,
                     int offSetY, int width, int height, Duration duration) {
        this.imageView = imageView;
        this.count = count;
        this.columns = columns;
        this.offSetX = offSetX;
        this.offSetY = offSetY;
        this.width = width;
        this.height = height;
        setCycleDuration(duration);
        setCycleCount(PoliceAnimation.INDEFINITE);
        setInterpolator(Interpolator.LINEAR);
        this.imageView.setViewport(new Rectangle2D(offSetX,offSetY,width,height));
    }
    public void setOffSetX(int x){
        this.offSetX = x;
    }
    public void setOffSetY(int y){
        this.offSetY = y;
    }


    @Override
    protected void interpolate(double frac) {
        final int index = Math.min((int)Math.floor(count*frac),count-1);
        final int x = (index%columns)*width+offSetX;
        final int y = (index/columns)*height+offSetY;
        imageView.setViewport(new Rectangle2D(x,y,width,height));
    }
}
