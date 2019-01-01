package Tanks;

import Interfaces.*;
import Upgrades.*;
import javafx.scene.layout.Pane;
import javafx.scene.paint.*;
import javafx.scene.shape.*;

import java.util.Map;

public class Tank extends Block implements Movable, Shotable, Removable, Upgradeable {
    public Map<String,Block> map;

    int lifeCount=3;
    public Pane pane;
    boolean moveUP=true,moveDown=true,moveLeft=true,moveRight=true;
    boolean alive=true;

    Rectangle body;
    Circle head;
    Weapon weapon;
    Color color;

    double headRadius;

    public Tank(Pane pane){
        headRadius=blockWidth/4;
        this.pane=pane;
        draw();
    }

    @Override
    public void draw() {
        drawBody();
        addBody();
        setPosition();
    }

    @Override
    public void up() {
        allowMove();
        if(moveUP) {
            this.positionY -= 0.5;
            setPosition();
        }
    }

    @Override
    public void down() {
        allowMove();
        if(moveDown) {
            this.positionY += 0.5;
            setPosition();
        }
    }

    @Override
    public void left() {
        allowMove();
        if(moveLeft) {
            this.positionX -= 0.5;
            setPosition();
        }
    }

    @Override
    public void right() {
        allowMove();
        if (moveRight) {
            this.positionX += 0.5;
            setPosition();
        }
    }


    @Override
    public void remove() {
        removeBody();
        pane.getChildren().remove(this);
        alive=false;
    }

    @Override
    public boolean alive() {
        return alive;
    }

    @Override
    public void shoot() {
        weapon.shot();
    }

    @Override
    public  void loseHP(){
        this.lifeCount-=1;
        if(lifeCount==0){remove();}
    }

    @Override
    public void upgrade() {

    }
    public void leftWeapon(){
        weapon.turn(-90);
    }
    public void rightWeapon(){
        weapon.turn(90);
    }

    @Override
    public void drawBody() {
        body=new Rectangle(blockWidth,blockHeight);
        head=new Circle(headRadius);
        weapon=new Weapon(this);

        body.setFill(Color.GREEN);
        head.setFill(Color.BLACK);
        head.setStroke(Color.BLACK);
        head.setCenterX(body.getTranslateX()+body.getWidth()/2);
        head.setCenterY(body.getTranslateY()+body.getHeight()/2);
    }

    @Override
    public void addBody() {
        getChildren().addAll(body,head,weapon);
    }

    @Override
    public void removeBody() {
        getChildren().removeAll(body,head,weapon);
    }

    public Circle getHead() {
        return head;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Weapon getWeapon() {
        return weapon;
    }
    private void allowMove(){
        double getPositionX=getPositionX();
        double getPositionY=getPositionY();
        String right=Double.toString(getPositionX+1)+Double.toString(getPositionY);
        String right1=Double.toString(getPositionX+1)+Double.toString(getPositionY-0.5);
        String right2=Double.toString(getPositionX+1)+Double.toString(getPositionY+0.5);
        if(map.get(right)!=null || map.get(right1)!=null || map.get(right2)!=null){
            moveRight=false;
        }else moveRight=true;
        String left=Double.toString(getPositionX-1)+Double.toString(getPositionY);
        String left1=Double.toString(getPositionX-1)+Double.toString(getPositionY-0.5);
        String left2=Double.toString(getPositionX-1)+Double.toString(getPositionY+0.5);
        if(map.get(left)!=null || map.get(left1)!=null || map.get(left2)!=null){
            moveLeft=false;
        }else moveLeft=true;
        String UP=Double.toString(getPositionX)+Double.toString(getPositionY-1);
        String UP1=Double.toString(getPositionX-0.5)+Double.toString(getPositionY-1);
        String UP2=Double.toString(getPositionX+0.5)+Double.toString(getPositionY-1);
        if(map.get(UP)!=null || map.get(UP1)!=null || map.get(UP2)!=null){
            moveUP=false;
        }else moveUP=true;
        String Down=Double.toString(getPositionX)+Double.toString(getPositionY+1);
        String Down1=Double.toString(getPositionX-0.5)+Double.toString(getPositionY+1);
        String Down2=Double.toString(getPositionX+0.5)+Double.toString(getPositionY+1);
        if(map.get(Down)!=null || map.get(Down1)!=null || map.get(Down2)!=null){
            moveDown=false;
        }else moveDown=true;
    }

    public void setMap(Map<String, Block> map) {
        this.map = map;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
