package game.items;

import game.items.tiles.Tile;

public class Move {

  private Player player;
  private Tile origin;
  private Tile destination;

  public Move(Player player, Tile origin, Tile destination) {
    this.player = player;
    this.origin = origin;
    this.destination = destination;
  }

  public Player getPlayer() {
    return player;
  }

  public Tile getOrigin() {
    return origin;
  }

  public Tile getDestination() {
    return destination;
  }
}