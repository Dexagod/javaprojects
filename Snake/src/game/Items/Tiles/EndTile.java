package game.Items.Tiles;

import game.Items.Location;
import game.Items.TileRepresentations.EndTileRepresentation;
import game.Items.TileRepresentations.TileRepresentation;

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