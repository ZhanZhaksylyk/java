import Maps.GameMapDrawer;
import Tanks.Tank;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Game extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane pane =new Pane();
        Scene scene= new Scene(pane);
        GameMapDrawer gameMapDrawer = new GameMapDrawer("map1.txt",pane);
        Tank tank=gameMapDrawer.getTank();

        pane.getChildren().add(gameMapDrawer);

        scene.setOnKeyPressed(event -> {
            switch (event.getCode()){
                case W: tank.up();break;
                case S: tank.down();break;
                case A: tank.left();break;
                case D: tank.right();break;
                case SPACE: tank.shoot();break;
                case Q: tank.leftWeapon();break;
                case E: tank.rightWeapon();break;
            }
        });

        primaryStage.setScene(scene);
        primaryStage.setFullScreen(true);
        primaryStage.show();
    }
}
