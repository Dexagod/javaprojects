package game;

import game.items.tiles.BlackTile;
import game.items.tiles.EndTile;
import game.items.Location;
import game.items.tiles.OutOfBoundsTile;
import game.items.tiles.StartTile;
import game.items.tiles.Tile;
import game.items.tiles.WhiteTile;
import java.io.IOException;

public class TileGenerator {

  public static Tile generateTile(Location location, char chr) throws IOException {
    switch(chr) {
      case 'O': return new OutOfBoundsTile(location, false);
      case 'B': return new BlackTile(location, true);
      case 'W': return new WhiteTile(location, true);
      case 'S': return new StartTile(location, true);
      case 'E': return new EndTile(location, false);
      default : throw  new IOException();
    }
  }

}