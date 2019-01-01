package Tanks;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class Bot extends Tank {
    Timeline animation;
    public Bot(Pane pane) {
        super(pane);
        setColor(Color.GRAY);
    }
    @Override
    public void shoot(){
        animation=new Timeline(new KeyFrame(Duration.millis(500),e->weapon.shot()));
        animation.setDelay(Duration.millis(500));
        animation.setCycleCount(Animation.INDEFINITE);
        animation.play();
    }
    @Override
    public void remove(){
        animation.stop();
        removeBody();
        pane.getChildren().remove(this);
        alive=false;
    }
}
