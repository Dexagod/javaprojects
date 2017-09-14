package game;

import game.items.Board;
import game.items.Move;
import game.items.Player;
import game.items.tiles.Tile;
import java.util.ArrayList;
import java.util.List;

public class Arbiter {

  GameController controller;
  List<RuleController> ruleControllers = new ArrayList<>();

  private void addRuleControllers(RuleController controller){
    this.ruleControllers.add(controller);
  }

  public boolean checkMove(Board board, Move move ) {
    for (RuleController ruleController : ruleControllers) {
      if (! ruleController.controlMove(move, board)) return false;
    }
    return true;
  }

  public boolean checkTileCorrect(Board board, Tile origin, Tile destination, Player player){
    return true;

  }

  public boolean checkCanPlaceBarricade(Tile tile){
    return true;
  }

}