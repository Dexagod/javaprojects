package game.Items;

import game.Items.Tiles.Tile;
import java.util.ArrayList;
import java.util.List;


// board is a list of columns containing a list of tiles
public class Board {

  List<List<Tile>> board;

  public Board() {
    board = new ArrayList<>();
  }

  public int getColCount(){
    return board.get(0).size();
  }

  public int getRowCount() {
    return board.size();
  }

  public List<List<Tile>> getBoard(){
    return board;
  }

  public Tile getTile(int col, int row){
    return board.get(col).get(row);
  }

  public void addTile(int col, int row, Tile tile){
    board.get(col).add(row, tile);
  }
  public void setTile(int col, int row, Tile tile){
      board.get(col).set(row, tile);
  }

  public void addCollumn(){
    board.add(new ArrayList<>());
  }
}