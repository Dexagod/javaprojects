package game.GameRepresentation;

import game.MenuBarListener;
import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

public class CustomMenuBar  extends MenuBar{

    MenuBarListener listener;

    public CustomMenuBar (final ReadOnlyDoubleProperty width, MenuBarListener listener){
      this.listener = listener;
        initMenuBar(width);
    }

    private void initMenuBar(final ReadOnlyDoubleProperty width){

        this.prefWidthProperty().bind(width);
        this.setStyle("-fx-background-color: #4E5B6E");

        this.getMenus().add(createFileChooserMenu("Start game"));
    }



    private Menu createFileChooserMenu(String text){
      Menu menu = new Menu();
      MenuItem menuItem = new MenuItem();
      menu.setText(text);
      menuItem.setText(text);
      menuItem.setOnAction(event -> {
            // Doesn't go into this method on click of the menu
            System.out.println("Inside On Action!!!");
            listener.showFileChooser();
          }
        );

      menu.getItems().add(menuItem);
        return menu;
    }

}
