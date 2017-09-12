package game.Items.Tiles;

import game.Items.Location;
import game.Items.TileRepresentations.BlackTileRepresentation;
import game.Items.TileRepresentations.TileRepresentation;

public class BlackTile extends Tile {

  public BlackTile(Location location, boolean isEnabled) {
    super(location);
    this.setEnabled(true);
    this.setWhite(false);
  }



  @Override
  public TileRepresentation createTileRepresentation() {
    return new BlackTileRepresentation(this);
  }
}