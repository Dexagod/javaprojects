package game.items;

import game.items.tiles.EndTile;
import game.items.tiles.StartTile;
import game.items.tiles.Tile;
import game.items.tiles.WhiteTile;
import java.util.ArrayList;
import java.util.List;


// board is a list of columns containing a list of tiles
public class Board {

  List<List<Tile>> board;
  List<StartTile> startTiles;
  List<EndTile> endTiles;
  List<WhiteTile> whiteTiles;

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
  public Tile getTile(Location location){
    return board.get(location.getColumn()).get(location.getRow());
  }
  public Tile getTile(Tile tile){
    return board.get(tile.getLocation().getColumn()).get(tile.getLocation().getRow());
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

  public void reset(){
    startTiles = null;
    endTiles = null;
    board = new ArrayList<>();
  }

  public List<StartTile> getStartTiles(){
    if (startTiles == null || endTiles == null || whiteTiles == null){
      findStartAndEndAndWhiteTiles();
    }

    return startTiles;
  }

  public List<EndTile> getEndTiles(){
    if (startTiles == null || endTiles == null || whiteTiles == null){
      findStartAndEndAndWhiteTiles();
    }

    return endTiles;
  }

  private void findStartAndEndAndWhiteTiles(){
    startTiles = new ArrayList<>();
    endTiles = new ArrayList<>();
    whiteTiles = new ArrayList<>();

    for(List<Tile> column : board){
      for(Tile tile : column) {
        if (tile instanceof StartTile){
          startTiles.add((StartTile) tile);
        }
        else if (tile instanceof EndTile){
          endTiles.add((EndTile) tile);
        }
        else if (tile instanceof WhiteTile){
          whiteTiles.add((WhiteTile) tile);
        }
      }
    }
  }

  public List<WhiteTile> getWhiteTiles(){
    if (startTiles == null || endTiles == null || whiteTiles == null){
      findStartAndEndAndWhiteTiles();
    }

    return whiteTiles;
  }
}