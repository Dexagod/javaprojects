package game.Items.Tiles;

import game.Items.Location;
import game.Items.TileRepresentations.OutOfBoundsTileRepresentation;
import game.Items.TileRepresentations.TileRepresentation;

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