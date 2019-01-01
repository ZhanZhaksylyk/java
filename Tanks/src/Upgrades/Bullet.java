package Upgrades;

import Interfaces.Block;
import Interfaces.Invisible;
import Interfaces.Removable;
import Interfaces.Visible;
import Tanks.Tank;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.shape.Circle;
import javafx.util.Duration;


public class Bullet extends Weapon{
    Circle bullet;
    Timeline animation;
    double angle;
    double CenterX;
    double CenterY;

    public Bullet(Tank tank,double angle) {
        super(tank);
        bullet=new Circle(height);
        setTargets(tank.getWeapon().targets);
        this.angle=angle;
        CenterX=tank.getTranslateX()+width+width*Math.cos(Math.toRadians(angle));
        CenterY=tank.getTranslateY()+width-height/2+width*Math.sin(Math.toRadians(angle));
    }

    public void drawBullet(){
        bullet.setFill(color);
        bullet.setCenterY(CenterY);
        bullet.setCenterX(CenterX);

        pane.getChildren().add(bullet);
    }
    public void moveBullet(){
        bullet.setTranslateX(bullet.getTranslateX()+length*Math.cos(Math.toRadians(angle)));
        bullet.setTranslateY(bullet.getTranslateY()+length*Math.sin(Math.toRadians(angle)));
        for (Block block : targets) {
            if (bullet.getBoundsInParent().intersects(block.getBoundsInParent())) {
                if (block instanceof Removable) {
                    ((Removable) block).loseHP();
                    pane.getChildren().remove(block);
                    if(!((Removable) block).alive()){
                        targets.remove(block);
                        tank.map.remove(block.getCoordinates());
                    }
                }
                if (block instanceof Visible && !(block instanceof Invisible)) {
                    remove();
                    break;
                }
            }
        }
    }

    public void shot(){
        drawBullet();
        animation= new Timeline(new KeyFrame(Duration.millis(500), e -> moveBullet()));
        start();
    }
    void stop(){
        animation.stop();
    }
    void start(){
        animation.setCycleCount(range);
        animation.setOnFinished(event -> pane.getChildren().remove(bullet));
        animation.setRate(rate);
        animation.play();
    }
    public void remove(){
        pane.getChildren().remove(bullet);
        getChildren().remove(bullet);
        stop();
    }

    public void setCenterX(double centerX) {
        CenterX = centerX;
    }

    public void setCenterY(double centerY) {
        CenterY = centerY;
    }
}
