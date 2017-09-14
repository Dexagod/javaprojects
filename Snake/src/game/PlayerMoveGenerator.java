package game;

import com.sun.javafx.tk.Toolkit.Task;
import game.items.Board;
import game.items.Move;
import game.items.Player;
import game.items.tileObject.Barricade;
import game.items.tiles.Tile;

public class PlayerMoveGenerator {

  boolean isActive = false;
  boolean searchingMove = false;
  boolean searchingBarricadeMove = false;

  Move move = null;

  Tile origin = null;
  Arbiter arbiter;
  Board board;
  Player player;

  public PlayerMoveGenerator(Board board, Arbiter arbiter, Player player){
    this.board = board;
    this.arbiter = arbiter;
    this.player = player;
  }

  public void setActive(boolean searchingForMove){
    this.isActive = true;
    this.origin = null;

    if (searchingForMove) searchingMove = true;
    else searchingBarricadeMove = true;
  }

  public void setInactive(boolean searchingForMove){
    this.isActive = false;
    searchingMove = false;
  }

  public synchronized Move requestMove(){
    if (searchingBarricadeMove) return null;
    this.setActive(true);

    try {
      while(searchingMove) {
        wait(1000);
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    Move returnMove = this.move;
    this.move = null;
    return returnMove;
  }


  public void clickedTile(Tile tile){
    if (searchingMove){
      if (origin == null){
        origin = tile;
      } else {
        if(arbiter.checkTileCorrect(board, origin, tile, player)) {
          move = new Move(player, origin, tile);
          searchingMove = false;
        }
      }
    } else if(searchingBarricadeMove){
      if(arbiter.checkCanPlaceBarricade(tile)) {
        move = new Move(player, null, tile);
        searchingBarricadeMove = false;
      }
    }

  }

  public synchronized Move replaceBarricade(Barricade barricade) {
    if (searchingMove) return null;
    this.setActive(false);
    try {
      while (searchingBarricadeMove) {
        wait(1000);
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    Move returnMove = this.move;
    this.move = null;
    return returnMove;
  }
}