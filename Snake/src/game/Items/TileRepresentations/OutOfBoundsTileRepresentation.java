package game.Items.TileRepresentations;

import game.Items.Tiles.Tile;

public class OutOfBoundsTileRepresentation extends TileRepresentation {

  public OutOfBoundsTileRepresentation(Tile tile) {
    super(tile);
    this.getStyleClass().add("oobtile");
  }
}