package game;

import game.Items.Board;
import game.Items.Location;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class BoardGenerator {


  public static Board generateBoardFromFile(File file) throws IOException {
    Board board = new Board();
    BufferedReader reader = new BufferedReader(new FileReader(file));

    int row = 0;
    int col;

    String line;
    while ((line = reader.readLine()) != null) {
      char[] chars = line.toCharArray();
      col = 0;
      for(char chr : chars) {
        if (row == 0){
          board.addCollumn();
        }
        Location location = new Location(col, row);
        board.addTile(col, row, TileGenerator.generateTile(location, chr));
        col += 1;
      }
      row += 1;
    }


    return board;
  }

}