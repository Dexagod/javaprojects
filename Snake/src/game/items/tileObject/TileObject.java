package game.items.tileObject;

import game.items.Location;
import game.items.Player;
import game.items.tileObjectRepresentation.TileObjectRepresentation;
import game.items.tiles.Tile;

public abstract class TileObject {

  Tile tile;
  TileObjectRepresentation tileObjectRepresentation;

  public TileObject(Tile tile) {
    this.tile = tile;
    this.tileObjectRepresentation = createTileObjectRepresentation();
  }

  public void moveTo(Tile tile) {
    this.tile = tile;
  }

  public Tile getCurrentTile(){
    return tile;
  }

  public void setCurrentTile(Tile tile){
    this.tile = tile;
  }

  public void beCaptured(Player player, TileObject tileObject){reset();};

  public void isClicked(){
    if (this.getCurrentTile() == null) return;
    this.getCurrentTile().isClicked();
  }

  public abstract TileObjectRepresentation createTileObjectRepresentation();

  public TileObjectRepresentation getTileObjectRepresentation(){
    return tileObjectRepresentation;
  }

  private void reset(){
    if (this.getCurrentTile() == null) return;
    if (this.getCurrentTile().getTileObject().equals(this)){
      this.getCurrentTile().setTileObject(null);
    }
  }
}