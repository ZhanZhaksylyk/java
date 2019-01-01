package Blocks;

import Interfaces.*;
import javafx.scene.image.*;


public class Brick extends Block implements Visible,Removable{
    boolean alive=true;
    double lifeCount=3;
    Image image;
    ImageView imageView;
    public Brick(double x, double y){
        image=new Image("file:\\C:\\Users\\Zhan\\Desktop\\Tanks\\Images\\"+"Brick.png");
        changePosition(x,y);
        draw();
    }
    @Override
    public void drawBody() {
        addBody();
        setPosition();
    }

    @Override
    public void addBody() {
        imageView=new ImageView(image);
        getChildren().add(this.imageView);
    }

    @Override
    public void removeBody() {
        getChildren().remove(this.imageView);
    }

    @Override
    public void draw() {
        drawBody();
    }

    @Override
    public void remove() {
        removeBody();alive=false;
    }

    @Override
    public boolean alive() {
        return alive;
    }

    @Override
    public void loseHP() {
        lifeCount-=1;
        if(lifeCount==0){
            remove();
        }
    }
}
