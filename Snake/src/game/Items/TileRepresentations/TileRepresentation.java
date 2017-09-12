package game.Items.TileRepresentations;

import game.Items.Tiles.Tile;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public abstract class TileRepresentation extends Pane {

  private Tile tile;
  private boolean isEnabled;

  public TileRepresentation(Tile tile) {
    this.tile = tile;
    this.setPrefSize(50, 50);
    this.getStyleClass().add("tile");
  }

  public void setStart(Color color){
    if (color == null) return;
    //if (!this.isEnabled) return;
    String hex = String.format("#%02X%02X%02X", color.getRed(), color.getGreen(), color.getBlue());
    this.setStyle("-fx-background-color: " + hex);
  }


}