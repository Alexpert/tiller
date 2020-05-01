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
        World world = new World(256,256);

        MinimapView worldView = new MinimapView(world);
        worldView.setPrefSize(200, 200);
        worldView.draw();
        primaryStage.setTitle("OpenEmpires");
        primaryStage.setScene(new Scene(worldView));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
