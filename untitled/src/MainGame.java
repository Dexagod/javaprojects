import GameBoard.MainPane;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainGame  extends Application {
    public void start(Stage stage) {
        System.out.println("STARTING");
        MainPane mainPane = new MainPane();
        Scene scene = new Scene(mainPane);
        mainPane.initialize(scene);
        stage.setTitle("Not Runescape");
        stage.setMaximized(true);
        stage.setScene(scene);
        stage.show();
    }
}


