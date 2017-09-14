package game;

import game.items.Board;
import game.items.Move;

public interface RuleController {
  boolean controlMove(Move move, Board board);
}
