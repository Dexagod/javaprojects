package game.items.tiles;

import game.items.Location;
import game.items.tileRepresentations.OutOfBoundsTileRepresentation;
import game.items.tileRepresentations.TileRepresentation;

public class OutOfBoundsTile extends Tile {

  public OutOfBoundsTile(Location location, boolean isEnabled) {
    super(location);
    this.setEnabled(true);
    this.setWhite(false);
  }

  @Override
  public TileRepresentation createTileRepresentation() {
    return new OutOfBoundsTileRepresentation(this);
  }
}