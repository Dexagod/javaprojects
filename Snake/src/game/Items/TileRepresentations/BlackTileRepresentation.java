package game.Items.TileRepresentations;

import game.Items.Tiles.Tile;

public class BlackTileRepresentation extends TileRepresentation{

  public BlackTileRepresentation(Tile tile) {
    super(tile);
    this.getStyleClass().add("blacktile");
  }
}