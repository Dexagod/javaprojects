package game.Items.Tiles;

import game.Items.Barricade;
import game.Items.Location;
import game.Items.Stone;
import game.Items.TileObject;
import game.Items.TileRepresentations.TileRepresentation;

public abstract class Tile{

    private boolean isWhite;
    private boolean isEnabled;
    private TileRepresentation representation;
    private Location location;

    private TileObject tileObject;

    public Tile(Location location) {
        initTile(location);
    }


    private void initTile(Location location){
        this.representation = createTileRepresentation();
        this.location = location;
    }

    public void setBarricade(Barricade barricade) {
        this.tileObject = barricade;
    }

    public void setStone(Stone stone) {
        this.tileObject = stone;
    }

    public void setTileObject(TileObject tileObject){
        this.tileObject = tileObject;
    }


    public void setEnabled(boolean enabled) {
      this.isEnabled = enabled;
    }

    public void setWhite(boolean white) {
      this.isWhite = white;
    }

    public TileRepresentation getRepresentation() {
        return representation;
    }

    public boolean isWhite(){
        return isWhite;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public Location getLocation() {
        return location;
    }

    public TileObject getTileObject() {
        return tileObject;
    }

    public abstract TileRepresentation createTileRepresentation();
}
