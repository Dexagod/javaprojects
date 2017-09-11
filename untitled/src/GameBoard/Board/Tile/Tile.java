package GameBoard.Board.Tile;

import GameBoard.Board.Building.Building;
import GameBoard.Board.GameBoard;
import GameBoard.Board.Unit.Unit;

import java.util.ArrayList;
import java.util.List;

public abstract class Tile {
    private int xLocation;
    private int yLocation;
    private GameBoard board;
    private List<Building> buildings;
    private List<Unit> units;

    public Tile(int xLocation, int yLocation, GameBoard board) {
        this.xLocation = xLocation;
        this.yLocation = yLocation;
        this.board = board;

        buildings = new ArrayList<>();
        units = new ArrayList<>();
    }

    public int getxLocation() {
        return xLocation;
    }

    public int getyLocation() {
        return yLocation;
    }

    public GameBoard getBoard() {
        return board;
    }

    public List<Building> getBuildings() {
        return buildings;
    }

    public List<Unit> getUnits() {
        return units;
    }

    private void addBuilding(Building building) {
        buildings.add(building);
    }

    private void addBuilding(Building building, int index) {
        buildings.add(index, building);
    }

    private void removeBuilding(int index) {
        buildings.remove(index);
    }

    private void removeBuilding(Building building) {
        buildings.remove(building);
    }

    private void addUnit(Unit unit) {
        units.add(unit);
    }

    private void addUnit(Unit unit, int index) {
        units.add(index, unit);
    }

    private void removeUnit(Unit unit) {
        units.remove(unit);
    }

    private void removeUnit(int index) {
        units.remove(index);
    }

    abstract public boolean isWalkable();
}
