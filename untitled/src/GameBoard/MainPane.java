package GameBoard;

import GameBoard.Board.MainGamePane;
import GameBoard.Menus.CustomMenuBar;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.Pane;

public class MainPane extends Pane {


    public MainPane(){
    }

    public void initialize(Scene scene){
        setStyle("-fx-background-color: #00CED1");

        setWidth(Double.MAX_VALUE);
        setHeight(Double.MAX_VALUE);

        MenuBar gameMenuBar = new CustomMenuBar(scene.widthProperty());
        MainGamePane mainGamePane = new MainGamePane();
        getChildren().add(gameMenuBar);
        getChildren().add(mainGamePane);

    }
}
