import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.Pane;

public class GamePane extends Pane {

    public GamePane() {
    }

    public void initialize(Scene scene){
        setStyle("-fx-background-color: #00CED1");

        setWidth(Double.MAX_VALUE);
        setHeight(Double.MAX_VALUE);

        MenuBar gameMenuBar = new CustomMenuBar(scene.widthProperty());
        GameBoardPane gameBoardPane = new GameBoardPane();
        getChildren().add(gameMenuBar);
        getChildren().add(gameBoardPane);

    }

}
