package game.items;

import game.PlayerMoveGenerator;
import game.items.tiles.StartTile;
import game.items.tiles.Tile;
import game.items.tileObject.Barricade;
import game.items.tileObject.Pawn;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.paint.Color;

public class Player {

  String name;
  Color color;
  int reservePawns;
  List<Pawn> pawns;
  StartTile startPosition;
  boolean isPlaying = false;
  PlayerMoveGenerator playerMoveGenerator;

  public Player(){
  }

  public String getName() {
    return name;
  }

  public void setPawns(List<Pawn> stones){
    this.pawns = stones;
  }

  public Color getColor() {
    return color;
  }

  public int getReservePawns() {
    return reservePawns;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setColor(Color color) {
    this.color = color;
  }

  public void setReservePawns(int reservePawns) {
    this.reservePawns = reservePawns;
  }

  public Pawn getFreePawn(){
    for(Pawn pawn : pawns){
      if (pawn.getCurrentTile() == null){
        return pawn;
      }
    }
    return null;
  }

  public void setStartPosition(StartTile startPosition){
    if (this.startPosition != null) this.startPosition.reset();
    this.startPosition = startPosition;
    startPosition.setPlayer(this);
  }

  public StartTile getStartPosition(){
    return startPosition;
  }

  public void returnPawn(Pawn pawn){
    pawn.setCurrentTile(null);
    this.setReservePawns(reservePawns + 1);
  }

  public void setStartPawnIfPossible(){
    if(reservePawns > 0){
      Pawn freepawn = null;
      for (Pawn pawn : pawns){
        if (pawn.getCurrentTile() == null){
          freepawn = pawn;
          break;
        }
      }
      if (freepawn != null){
        this.startPosition.setTileObject(freepawn);
      }
    }
  }

  public void reset(){
    this.reservePawns = 0;
    this.pawns = new ArrayList<>();
    this.startPosition.reset();
    this.startPosition = null;
    isPlaying = false;
  }



  public Move requestMove(){
    return playerMoveGenerator.requestMove();
  }

  public void clickedTile(Tile tile){
    playerMoveGenerator.clickedTile(tile);
  }

  public Move replaceBarricade(Barricade barricade){
    return playerMoveGenerator.replaceBarricade(barricade);
  }

  public void setPlayerMoveGenerator(PlayerMoveGenerator playerMoveGenerator){
    this.playerMoveGenerator = playerMoveGenerator;
  }

  public PlayerMoveGenerator getPlayerMoveGenerator(){
    return this.playerMoveGenerator;
  }

}