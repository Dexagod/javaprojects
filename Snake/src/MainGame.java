import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainGame  extends Application {
    public void start(Stage stage) {
        System.out.println("STARTING");
        GamePane gamePane = new GamePane();
        Scene scene = new Scene(gamePane);
        gamePane.initialize(scene);
        stage.setTitle("Not Runescape");
        stage.setMaximized(true);
        stage.setScene(scene);
        stage.show();
    }
}


