package game;

import game.items.Player;

public class TurnController {

  GameController controller;
  private int currentPlayerIndex = 0;

  public TurnController(GameController controller) {
    this.controller = controller;
  }


  public void reset(){
    currentPlayerIndex = 0;
  }


  public void turnDone(){
    this.currentPlayerIndex = (this.currentPlayerIndex+1) % (controller.getPlayers().size());
  }

  public Player getCurrentPlayer(){
    return controller.getPlayers().get(currentPlayerIndex);
  }

}