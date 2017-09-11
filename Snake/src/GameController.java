import java.util.ArrayList;
import java.util.List;

public class GameController {

    GameBoardPane gameBoardPane;

    public static int SIZE = 40;

    List<List<Tile>> board = new ArrayList<>();

    public GameController(GameBoardPane gameBoardPane) {
        this.gameBoardPane = gameBoardPane;
        gameBoardPane.setPrefColumns(SIZE);
    }

    public void startGame(){}

    public void initializeBoard() {
        for(int i = 0; i < SIZE; i++) {
            for(int j = 0; j < SIZE; j++) {
                Tile tile = new Tile();
                board.get(i).add(j, tile);
                gameBoardPane.getChildren().add
            }
        }
    }
}
