package game.items.tileObjectRepresentation;

import game.items.tileObject.Barricade;
import game.items.tileObject.Pawn;
import game.items.tileObject.TileObject;
import game.items.tiles.Tile;
import javafx.scene.layout.Pane;

public class TileObjectRepresentation extends Pane{

    private TileObject tileObject;

    public TileObjectRepresentation(TileObject tileObject) {
      this.tileObject = tileObject;
      this.setPrefSize(40, 40);
      this.getStyleClass().add("tileObject");

      this.setOnMouseClicked(event -> {
        tileObject.isClicked();
      });
    }

    public TileObject getTileObject(){
      return tileObject;
    }
}