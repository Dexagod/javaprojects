package GameBoard.Menus;

import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;

public class CustomMenuBar extends MenuBar{

    public CustomMenuBar (final ReadOnlyDoubleProperty width){
        initMenuBar(width);
    }

    private void initMenuBar(final ReadOnlyDoubleProperty width){

        this.prefWidthProperty().bind(width);
        this.setStyle("-fx-background-color: #4E5B6E");

        this.getMenus().add(createTestMenu("menu een"));
        this.getMenus().add(createTestMenu("menu twee"));
    }

    private Menu createTestMenu(String text){
        Menu menu = new Menu();
        menu.setText(text);
        return menu;
    }
}
