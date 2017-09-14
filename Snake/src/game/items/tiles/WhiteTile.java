package game.items.tiles;

import game.items.Location;
import game.items.tileObject.Barricade;
import game.items.tileRepresentations.TileRepresentation;
import game.items.tileRepresentations.WhiteTileRepresentation;

public class WhiteTile extends Tile {

  public WhiteTile(Location location, boolean isEnabled) {
    super(location);
    this.setEnabled(true);
    this.setWhite(true);
  }

  @Override
  public TileRepresentation createTileRepresentation() {
    return new WhiteTileRepresentation(this);
  }
}