package game.items.tileObjectRepresentation;

import game.ColorConverter;
import game.items.Player;
import game.items.tileObject.Pawn;
import game.items.tileObject.TileObject;
import javafx.scene.paint.Color;

public class PawnRepresentation extends TileObjectRepresentation{

  public PawnRepresentation(TileObject tileObject) {
    super(tileObject);
    this.getStyleClass().add("pawn");
  }

  public void updateColor(Player player){
    Color color = ((Pawn) this.getTileObject()).getPlayer().getColor();
    this.setStyle("-fx-background-color: " + ColorConverter.toHex(color.getRed(), color.getGreen(), color.getBlue()));
  }
}