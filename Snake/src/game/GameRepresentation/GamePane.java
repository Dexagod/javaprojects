package game.GameRepresentation;

import game.GameController;
import game.MenuBarListener;
import java.io.IOException;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GamePane extends VBox implements MenuBarListener {

    Stage stage;
    GameController controller;

    public GamePane(Stage stage) {
        this.stage = stage;
    }

    public void initialize(Scene scene){
        setStyle("-fx-background-color: #00CED1");

        setWidth(Double.MAX_VALUE);
        setHeight(Double.MAX_VALUE);
        MenuBar gameMenuBar = new CustomMenuBar(scene.widthProperty(), this);
        GameBoardPane gameBoardPane = new GameBoardPane();
        InfoPane infoPane = new InfoPane(this.widthProperty());

        getChildren().addAll(gameMenuBar, gameBoardPane, infoPane);

        this.setVgrow(gameBoardPane, Priority.ALWAYS);

        this.controller = new GameController(gameBoardPane);

    }

    @Override
    public void showFileChooser() {
        System.out.println("starting makeBoard");
        try {
            controller.startGame();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void showColorPicker() {

    }
}
