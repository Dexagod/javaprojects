package game.Items.Tiles;

import game.Items.Location;
import game.Items.Player;
import game.Items.TileRepresentations.StartTileRepresentation;
import game.Items.TileRepresentations.TileRepresentation;

public class StartTile extends Tile {

  private Player player;

  public StartTile(Location location, boolean isEnabled) {
    super(location);
    this.setEnabled(true);
    this.setWhite(false);
  }

  @Override
  public TileRepresentation createTileRepresentation() {
    return new StartTileRepresentation(this);
  }

  public void setPlayer(Player player){
    this.player = player;
    this.getRepresentation().setStart(player.getColor());
  }

  public Player getPlayer() {
    return player;
  }
}