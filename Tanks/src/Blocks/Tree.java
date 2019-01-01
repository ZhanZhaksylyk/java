package Blocks;

import Interfaces.*;
import javafx.scene.image.*;


public class Tree extends Block implements Removable,Visible{
    boolean alive=true;
    double lifeCount=1;
    Image image;
    ImageView imageView;
    public Tree(double x, double y){
        image=new Image("file:\\C:\\Users\\Zhan\\Desktop\\Tanks\\Images\\"+"Tree.png");
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
    public void loseHP() {
        lifeCount-=1;
        if(lifeCount==0){
            remove();
        }
    }

    @Override
    public void remove() {
        removeBody();alive=false;
    }

    @Override
    public boolean alive() {
        return alive;
    }
}
