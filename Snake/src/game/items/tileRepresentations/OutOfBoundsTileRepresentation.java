package game.items.tileRepresentations;

import game.items.tiles.Tile;

public class OutOfBoundsTileRepresentation extends TileRepresentation {

  public OutOfBoundsTileRepresentation(Tile tile) {
    super(tile);
    this.getStyleClass().add("oobtile");
  }
}