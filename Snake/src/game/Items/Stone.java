package game.Items;

public class Stone extends TileObject{

  Player player;

  public Stone(Location location, Player player){
    super(location);
    this.player = player;
  }


  @Override
  public void beCaptured(Player player, TileObject tileObject) {

  }
}