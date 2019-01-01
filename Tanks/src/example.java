import Maps.GameMapDrawer;
import Tanks.Tank;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class example extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane pane =new Pane();
        Scene scene= new Scene(pane);
        GameMapDrawer gameMapDrawer = new GameMapDrawer("map0.txt",pane);
        Tank tank=gameMapDrawer.getTank();
    }
}
