package game.Items.TileRepresentations;

import game.Items.Tiles.Tile;

public class WhiteTileRepresentation extends TileRepresentation{

  public WhiteTileRepresentation(Tile tile) {
    super(tile);
    this.getStyleClass().add("whitetile");
  }
}