package game.items.tileObjectRepresentation;

import game.items.tileObject.TileObject;
import game.items.tileRepresentations.TileRepresentation;
import game.items.tiles.Tile;

public class BarricadeRepresentation extends TileObjectRepresentation {

  public BarricadeRepresentation(TileObject tileObject) {
    super(tileObject);
    this.getStyleClass().add("barricade");
  }
}