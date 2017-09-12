package game;

import game.Items.Tiles.BlackTile;
import game.Items.Tiles.EndTile;
import game.Items.Location;
import game.Items.Tiles.OutOfBoundsTile;
import game.Items.Tiles.StartTile;
import game.Items.Tiles.Tile;
import game.Items.Tiles.WhiteTile;
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