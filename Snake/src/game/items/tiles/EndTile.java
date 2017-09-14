package game.items.tiles;

import game.items.Location;
import game.items.tileRepresentations.EndTileRepresentation;
import game.items.tileRepresentations.TileRepresentation;

public class EndTile extends Tile {

  public EndTile(Location location, boolean isEnabled) {
    super(location);
    this.setEnabled(true);
    this.setWhite(false);
  }

  @Override
  public TileRepresentation createTileRepresentation() {
    return new EndTileRepresentation(this);
  }

}