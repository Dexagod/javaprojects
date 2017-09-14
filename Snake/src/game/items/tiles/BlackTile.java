package game.items.tiles;

import game.items.Location;
import game.items.tileRepresentations.BlackTileRepresentation;
import game.items.tileRepresentations.TileRepresentation;

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