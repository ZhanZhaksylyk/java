package Interfaces;

import javafx.geometry.Rectangle2D;
import javafx.scene.layout.Pane;
import javafx.stage.Screen;


public abstract class Block extends Pane implements Drawable{
    Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();

    public final double blockWidth=40,blockHeight=40;
    public final double initialX=(primaryScreenBounds.getWidth()/blockWidth-28)/2,initialY=(primaryScreenBounds.getHeight()/blockHeight-18)/2;

    public double positionX=0,positionY=0;
    public void setPosition(){setTranslateX((positionX+initialX)*blockWidth);setTranslateY((positionY+initialY)*blockHeight);}
    public abstract void drawBody();
    public abstract void addBody();
    public abstract void removeBody();

    public void setPositionX(double positionX) {
        this.positionX = positionX ;
    }

    public void setPositionY(double positionY) {
        this.positionY = positionY ;
    }
    public void changePosition(double x, double y){
        setPositionX(x);
        setPositionY(y);
        setPosition();
    }

    public double getPositionX() {
        return positionX;
    }

    public double getPositionY() {
        return positionY;
    }
    public String getCoordinates(){
        String coordinates=Double.toString(positionX)+Double.toString(positionY);
        return coordinates;
    }
}
