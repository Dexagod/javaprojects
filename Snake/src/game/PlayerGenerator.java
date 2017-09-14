package game;

import game.items.tileObject.Pawn;
import game.items.Player;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.paint.Color;

public class PlayerGenerator {

  public static Player generatePlayer(String name, int numberOfPawns, Color color){
    Player player = new Player();
    player.setColor(color);
    player.setName(name);

    List<Pawn> pawns = new ArrayList<>();
    for (int i = 0; i < numberOfPawns; i++){
      pawns.add(new Pawn(null, player));
      player.setReservePawns(player.getReservePawns() + 1);
    }
    player.setPawns(pawns);
    return player;
  }

  //TODO:: ISSUE IF PAWNS ARE CREATED BEFORE PLAYER CANNOT SET PLAYER COLOR
}