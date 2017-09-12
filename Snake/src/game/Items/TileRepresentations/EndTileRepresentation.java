package game.Items.TileRepresentations;

import game.Items.Tiles.Tile;

public class EndTileRepresentation extends TileRepresentation {

  public EndTileRepresentation(Tile tile) {
    super(tile);
    this.getStyleClass().add("endtile");
  }
}