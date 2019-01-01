package Upgrades;

import Interfaces.Block;
import Interfaces.Removable;
import Interfaces.Visible;
import Tanks.Tank;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

import java.util.ArrayList;

public class Weapon extends Block {
    Tank tank;
    Rectangle body;
    Pane pane;
    Color color;

    public ArrayList<Block> targets;

    double width;
    double height;
    double angle;

    double length;
    double rate;
    double x0;
    double y0;

    int range;

    public Weapon(Tank tank){
        width=tank.getHead().getRadius()*2;
        height=tank.getHead().getRadius()/2;

        angle=0;

        length=1;
        color=Color.BLACK;

        range=600;
        rate=10;

        x0=tank.getTranslateX()+width;
        y0=tank.getTranslateX()+width-height/2;


        this.tank=tank;
        this.pane=tank.pane;

        draw();
    }

    @Override
    public void drawBody() {
        body=new Rectangle(width,height);
        body.setTranslateX(x0);
        body.setTranslateY(y0);
    }

    @Override
    public void addBody() {
        getChildren().add(body);
    }

    @Override
    public void removeBody() {
        getChildren().remove(body);
    }

    @Override
    public void draw() {
        drawBody();
        addBody();
    }
    public void shot(){
        new Bullet(tank,angle).shot();
    }
    public void turn(double angle){
        this.angle+=angle;
        getTransforms().add(new Rotate(angle+0,x0+0,y0+height/2));
    }

    public void setTargets(ArrayList<Block> targets) {
        this.targets = targets;
        targets.remove(this.tank);
    }

    public void setLength(double length) {
        this.length = length;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public double getLength() {
        return length;
    }

    public double getRate() {
        return rate;
    }

    public int getRange() {
        return range;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }
}

