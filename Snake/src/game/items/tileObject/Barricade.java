package game.items.tileObject;

import game.items.Location;
import game.items.Player;
import game.items.tileObjectRepresentation.BarricadeRepresentation;
import game.items.tileObjectRepresentation.TileObjectRepresentation;
import game.items.tiles.Tile;

public class Barricade extends TileObject{


  public Barricade(Tile tile) {
    super(tile);
  }

  @Override
  public TileObjectRepresentation createTileObjectRepresentation() {
    return new BarricadeRepresentation(this);
  }

}