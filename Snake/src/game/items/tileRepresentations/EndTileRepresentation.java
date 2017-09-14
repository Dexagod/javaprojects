package game.items.tileRepresentations;

import game.items.tiles.Tile;

public class EndTileRepresentation extends TileRepresentation {

  public EndTileRepresentation(Tile tile) {
    super(tile);
    this.getStyleClass().add("endtile");
  }
}