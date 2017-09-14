package game.gameRepresentation;

import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.scene.layout.HBox;

public class InfoPane extends HBox {

  public InfoPane(final ReadOnlyDoubleProperty width) {
    this.setWidth(250);
    this.setHeight(150);
    getStyleClass().add("hbox");
    setStyle("-fx-background-color: #471c54");

  }
}