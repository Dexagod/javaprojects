package game.Items;

public abstract class TileObject {

  Location location;

  public TileObject(Location location) {
    this.location = location;
  }

  public void moveTo(Location location) {
    this.location = location;
  }

  public abstract void beCaptured(Player player, TileObject tileObject);
}