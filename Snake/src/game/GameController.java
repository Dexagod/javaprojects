package game;

import game.gameRepresentation.GameBoardPane;
import game.items.tileObject.Barricade;
import game.items.Board;
import game.items.Move;
import game.items.Player;
import game.items.tileObject.Pawn;
import game.items.tiles.OutOfBoundsTile;
import game.items.tiles.StartTile;
import game.items.tiles.Tile;
import game.items.tileObject.TileObject;
import game.items.tiles.WhiteTile;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.scene.paint.Color;

public class GameController implements OnClickListener {

  GameBoardPane gameBoardPane;
  TurnController turnController;
  Arbiter arbiter;
  Board board;
  private boolean started = false;

  private List<Player> players = new ArrayList<>();

  public GameController(GameBoardPane gameBoardPane) {
    this.gameBoardPane = gameBoardPane;
  }


  public void addPlayer(Player player) {
    if (!started) {
      players.add(player);
    }
  }

  public void reset() {
    players = new ArrayList<>();
    started = false;
    turnController.reset();
  }

  private void scramblePlayers() {
    Collections.shuffle(players);
  }

  public List<Player> getPlayers() {
    return players;
  }



  public void initializeGame() throws IOException {

    File file = new File("src\\game\\maps\\map1");
    Board board = BoardGenerator.generateBoardFromFile(file);
    this.board = board;
    initializeBoard(board);

    arbiter = new Arbiter();

    generateTestPlayers();

    scramblePlayers();

    generateStartPositions();

    initializeFirstPawns();
    initializeBarricades();

    setPlayerMoveGenerators();

    turnController = new TurnController(this);

    started = true;

    Platform.runLater(new Runnable() {
      @Override
      public void run() {
        startGameLoop();
      }
    });
  }

  //     ############## INITIALIZATION ##############
  private void setPlayerMoveGenerators() {
    for (Player player : players) {
      player.setPlayerMoveGenerator(new PlayerMoveGenerator(board, arbiter, player));
    }
  }

  private void generateTestPlayers() {
    List<Player> testPlayers = new ArrayList<>();
    testPlayers.add(PlayerGenerator.generatePlayer("test1", 5, Color.BLUE));
    testPlayers.add(PlayerGenerator.generatePlayer("test2", 5, Color.RED));
    testPlayers.add(PlayerGenerator.generatePlayer("test3", 5, Color.GREEN));
    testPlayers.add(PlayerGenerator.generatePlayer("test4", 5, Color.BROWN));
    this.players = testPlayers;
  }

  private void generateStartPositions() {
    int playerindex = 0;
    for (StartTile startTile : board.getStartTiles()) {
      if (playerindex < players.size()) {
        players.get(playerindex).setStartPosition(startTile);
      }
      playerindex++;
    }
  }

  private void initializeBarricades() {
    List<WhiteTile> whiteTiles = board.getWhiteTiles();
    for (WhiteTile tile : whiteTiles) {
      if (tile.getTileObject() == null) {
        Barricade barricade = new Barricade(tile);
        tile.setTileObject(barricade);
      }
    }
  }

  private void initializeFirstPawns() {
    for (Player player : players) {
      player.setStartPawnIfPossible();
    }
  }

  private void initializeBoard(Board board) {
    for (int row = 0; row < board.getColCount(); row++) {
      for (int col = 0; col < board.getRowCount(); col++) {
        Tile tile = board.getTile(col, row);
        tile.addListener(this);
        gameBoardPane.add(tile.getRepresentation(), col, row); // item, col, row
      }
    }
  }

  //     ############## GAMELOOP ##############
  private void startGameLoop() {
    for (int i = 0; i < 100; i++) {
      System.out.println("turn " + i);
      turn();
    }
  }

  private void turn() {
    System.out.println("turn");
    Player player = turnController.getCurrentPlayer();
    Move move = player.requestMove();

    while (!arbiter.checkMove(board, move)) {
      move = player.requestMove();
    }

    while (move != null && move.getOrigin() != null && move.getOrigin().getTileObject() != null &&
        move.getDestination() != null) {
      TileObject destinationObject = move.getDestination().getTileObject();
      executeMoveWithPlayer(move);
      move = handleTakeDown(player, destinationObject);
      if (move == null || (!arbiter.checkMove(board, move))) {
        move = null;
      }
    }
    turnController.turnDone();
  }



  //     ############## HANDLERS ##############

  //call this method after executing the move first
  private Move handleTakeDown(Player currentPlayer, TileObject destinationObject) {
    if (currentPlayer == null || destinationObject == null) {
      return null;
    }
    if (destinationObject instanceof Barricade) {
      return currentPlayer.replaceBarricade((Barricade) destinationObject);
    } else if (destinationObject instanceof Pawn) {
      ((Pawn) destinationObject).getPlayer().returnPawn((Pawn) destinationObject);
    }
    return null;
  }

  private boolean executeMoveWithPlayer(Move move) {
    if (move.getOrigin().equals(move.getPlayer().getStartPosition())) {
      boolean test = executeMove(move);
      if (test) {
        move.getPlayer().setStartPawnIfPossible();
      }
      return test;
    }
    return executeMove(move);
  }

  private boolean executeMove(Move move) {
    TileObject object = board.getTile(move.getOrigin()).getTileObject();
    move.getOrigin().removeTileObject();
    move.getDestination().removeTileObject();
    move.getDestination().setTileObject(object);
    return true;
  }


  @Override
  public void tileClicked(Tile tile) {
    if (tile instanceof OutOfBoundsTile) {
      return;
    }
    turnController.getCurrentPlayer().clickedTile(tile);
  }
}
