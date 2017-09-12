package game;

import game.GameRepresentation.GameBoardPane;
import game.Items.Board;
import game.Items.Location;
import game.Items.Player;
import game.Items.Tiles.Tile;
import game.Items.TileObject;
import java.io.File;
import java.io.IOException;

public class GameController {

    GameBoardPane gameBoardPane;

    public GameController(GameBoardPane gameBoardPane) {
        this.gameBoardPane = gameBoardPane;
    }

    public void startGame() throws IOException {
        File file = new File("src\\game\\Maps\\map1");
        Board board = BoardGenerator.generateBoardFromFile(file);
        initializeBoard(board);
    }

    public void initializeBoard(Board board) {
        for(int row = 0; row < board.getColCount(); row++){
            for(int col = 0; col < board.getRowCount(); col++) {
                Tile tile = board.getTile(col, row);
                gameBoardPane.add(tile.getRepresentation(), col, row); // item, col, row
            }
        }
    }

    public void doMove(Player player, TileObject object, Location destination) {

    }
}
