import controller.Controller;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.World;
import view.MinimapView;
import view.WorldView;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        World world = new World(2048,2048);
        WorldView worldView = new WorldView(world);
        worldView.setPrefSize(1920, 1080);
        primaryStage.setTitle("Tiller");
        Scene scene = new Scene(worldView);
        Controller controller = new Controller(scene, world);
        primaryStage.setScene(scene);
        primaryStage.show();

        new AnimationTimer(){
            @Override
            public void handle(long l) {
                world.step();
                controller.step();
                worldView.draw();
            }
        }.start();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
