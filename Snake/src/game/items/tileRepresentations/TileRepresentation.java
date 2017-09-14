package game.items.tileRepresentations;

import game.items.tileObject.Barricade;
import game.items.tileObject.Pawn;
import game.items.tileObject.TileObject;
import game.items.tileObjectRepresentation.TileObjectRepresentation;
import game.items.tiles.Tile;
import javafx.scene.layout.Pane;

public abstract class TileRepresentation extends Pane {

  private Tile tile;
  private boolean isEnabled;

  public TileRepresentation(Tile tile) {
    this.tile = tile;
    this.setPrefSize(50, 50);
    this.getStyleClass().add("tile");

    this.setOnMouseClicked(event -> {
      tile.isClicked();
    });
  }

  public void clearRepresentation(){
    this.getStyleClass().clear();
    this.getStyleClass().add("tile");
  }

  public void addTileObjectRepresentation(TileObjectRepresentation representation){
    this.getChildren().add(representation);
  }

  public void clearTileObjectRepresentation(){
    this.getChildren().clear();
  }
}