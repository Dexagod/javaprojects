package game.items.tileRepresentations;

import game.items.tiles.Tile;

public class BlackTileRepresentation extends TileRepresentation{

  public BlackTileRepresentation(Tile tile) {
    super(tile);
    this.getStyleClass().add("blacktile");
  }
}