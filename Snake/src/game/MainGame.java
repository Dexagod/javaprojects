package game;

import game.gameRepresentation.GamePane;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainGame extends Application {
    public void start(Stage stage) {
        System.out.println("STARTING");
        GamePane gamePane = new GamePane(stage);
        Scene scene = new Scene(gamePane);
        gamePane.initialize(scene);
        scene.getStylesheets().add(getClass().getResource("stylesheet.css").toExternalForm());
        stage.setTitle("Barricade");
        stage.setMaximized(true);
        stage.setScene(scene);
        stage.show();
    }
}


