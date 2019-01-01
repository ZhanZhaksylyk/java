package Maps;

import Blocks.*;
import Interfaces.Block;
import Tanks.Bot;
import Tanks.Tank;
import javafx.scene.layout.Pane;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GameMapDrawer extends Pane {
    Map<String,Block> map =new HashMap<>();
    ArrayList<Block> targets;
    String fileName;
    Scanner in;
    Tank tank;
    Pane pane;
    public GameMapDrawer(String fileName,Pane pane) throws FileNotFoundException {
        this.fileName=fileName;
        in = new Scanner(new File("C:\\Users\\Zhan\\Desktop\\Tanks\\src\\Maps\\"+fileName));
        targets=new ArrayList<>();
        this.pane=pane;
        draw();
    }

    public void draw() {
        double tankX = 0;
        double tankY=0;
        for (int j = 0; j < 18; j++) {
            for (int i = 0; i < 28; i++) {
                getChildren().add(new Grass(i,j));
            }
        }
        for (int j = 0; j < 18; j++) {
            ArrayList<Bot> bots;
            for (int i = 0; i < 28; i++) {
                int n=in.nextInt();
                if(n>10){
                    Bot bot = new Bot(pane);
                    bot.changePosition(i,j);
                    bot.getWeapon().setAngle(n);
                    getChildren().add(bot);

                }
                switch (n) {
                    case 1:
                        tankX = i;
                        tankY = j;
                        break;
                    case 2:
                        Beton beton = new Beton(i, j);
                        getChildren().add(beton);
                        targets.add(beton);
                        map.put(beton.getCoordinates(), beton);
                        break;
                    case 3:
                        Brick brick = new Brick(i, j);
                        getChildren().add(brick);
                        targets.add(brick);
                        map.put(brick.getCoordinates(), brick);
                        break;
                    case 4:
                        Tree tree = new Tree(i, j);
                        getChildren().add(tree);
                        targets.add(tree);
                        map.put(tree.getCoordinates(), tree);
                        break;
                    case 5:
                        Water water = new Water(i, j);
                        getChildren().add(water);
                        targets.add(water);
                        map.put(water.getCoordinates(), water);
                        break;
                }

            }
        }
        this.tank=new Tank(pane);
        tank.changePosition(tankX,tankY);getChildren().add(tank);
        targets.add(tank);
        tank.getWeapon().setTargets(this.targets);
        tank.setMap(map);
    }

    public ArrayList<Block> getTargets() {
        return targets;
    }

    public Tank getTank() {
        return tank;
    }
}
