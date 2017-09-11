

import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;

public class CustomMenuBar  extends MenuBar{

    public CustomMenuBar (final ReadOnlyDoubleProperty width){
        initMenuBar(width);
    }

    private void initMenuBar(final ReadOnlyDoubleProperty width){

        this.prefWidthProperty().bind(width);
        this.setStyle("-fx-background-color: #4E5B6E");

        this.getMenus().add(createMenu("Start game"));
    }

    private Menu createMenu(String text){
        Menu menu = new Menu();
        menu.setText(text);
        menu.setOnAction(
                e -> {
                });
        return menu;
    }
}
