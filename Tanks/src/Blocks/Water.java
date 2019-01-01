package Blocks;

import Interfaces.*;
import javafx.scene.image.*;


public class Water extends Block implements Visible, Invisible {
    Image image;
    ImageView imageView;
    public Water(double x, double y){
        image=new Image("file:\\C:\\Users\\Zhan\\Desktop\\Tanks\\Images\\"+"Water.png");
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
}
