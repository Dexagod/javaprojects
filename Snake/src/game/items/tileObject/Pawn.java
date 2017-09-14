package game.items.tileObject;

import game.items.Location;
import game.items.Player;
import game.items.tileObjectRepresentation.PawnRepresentation;
import game.items.tileObjectRepresentation.TileObjectRepresentation;
import game.items.tiles.Tile;

public class Pawn extends TileObject{

  private Player player;

  public Pawn(Tile tile, Player player){
    super(tile);
    this.player = player;
    ((PawnRepresentation) this.getTileObjectRepresentation()).updateColor(player);
  }


  public Player getPlayer(){
    return player;
  }

  @Override
  public TileObjectRepresentation createTileObjectRepresentation() {
    return new PawnRepresentation(this);
  }
}