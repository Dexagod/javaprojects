package game.items.tileRepresentations;

import game.items.tiles.Tile;
import javafx.scene.paint.Color;

public class StartTileRepresentation extends TileRepresentation {

  public StartTileRepresentation(Tile tile) {
    super(tile);
    this.getStyleClass().add("starttile");
  }

  public void setStart(Color color){
    if (color == null) return;
    //if (!this.isEnabled) return;
    //String hex = String.format("#%02X%02X%02X", color.getRed()-10, color.getGreen(), color.getBlue());
    this.setStyle("-fx-background-color: GRAY"); //+ hex);
  }

}