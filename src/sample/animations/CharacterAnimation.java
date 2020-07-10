package sample.animations;

import javafx.animation.Interpolator;
import javafx.animation.Transition;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.util.Duration;




public class CharacterAnimation extends Transition {
    final ImageView imageView;
    private int count;
    private int columns;
    private int offSetX;
    private int offSetY;
    private int width;
    private int height;
    private Duration duration;

    public CharacterAnimation(ImageView imageView, int count, int columns, int offSetX,
                              int offSetY, int width, int height, Duration duration) {
        this.imageView = imageView;
        this.count = count;
        this.columns = columns;
        this.offSetX = offSetX;
        this.offSetY = offSetY;
        this.width = width;
        this.height = height;
        setCycleDuration(duration);
        setCycleCount(CharacterAnimation.INDEFINITE);
        setInterpolator(Interpolator.LINEAR);
        this.imageView.setViewport(new Rectangle2D(offSetX,offSetY,width,height));
    }
    public void setOffSetX(int x){
        this.offSetX = x;
    }
    public void setOffSetY(int y){
        this.offSetY = y;
    }

    public int getWidth() {
        return width;
    }
    public void setWidth(int width) {
        this.width = width;
    }
    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    protected void interpolate(double frac) {
        final int index = Math.min((int)Math.floor(count*frac),count-1);
        final int x = (index%columns)*width+offSetX;
        final int y = (index/columns)*height+offSetY;
        imageView.setViewport(new Rectangle2D(x,y,width,height));
    }
}
