package game.Items.Tiles;

import game.Items.Location;
import game.Items.TileRepresentations.TileRepresentation;
import game.Items.TileRepresentations.WhiteTileRepresentation;

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