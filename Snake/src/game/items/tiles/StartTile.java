package game.items.tiles;

import game.items.Location;
import game.items.Player;
import game.items.tileObject.Pawn;
import game.items.tileRepresentations.StartTileRepresentation;
import game.items.tileRepresentations.TileRepresentation;

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
    System.out.println("setting player and color");
    this.player = player;
    ((StartTileRepresentation) this.getRepresentation()).setStart(player.getColor());
  }

  public void reset(){
    this.player = null;
  }

  public Player getPlayer() {
    return player;
  }
}