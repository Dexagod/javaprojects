package game.items.tileRepresentations;

import game.items.tiles.Tile;

public class WhiteTileRepresentation extends TileRepresentation{

  public WhiteTileRepresentation(Tile tile) {
    super(tile);
    this.getStyleClass().add("whitetile");
  }
}