package game.items.tiles;

import game.items.tileObject.Barricade;
import game.items.Location;
import game.items.tileObject.Pawn;
import game.items.tileObject.TileObject;
import game.items.tileRepresentations.TileRepresentation;
import game.OnClickListener;
import java.util.ArrayList;
import java.util.List;

public abstract class Tile{

    private boolean isWhite;
    private boolean isEnabled;
    private TileRepresentation representation;
    private Location location;

    private TileObject tileObject;

    List<OnClickListener> listeners = new ArrayList<>();

    public Tile(Location location) {
        initTile(location);
    }


    private void initTile(Location location){
        this.representation = createTileRepresentation();
        this.location = location;
    }

    public void addListener(OnClickListener listener){
        this.listeners.add(listener);
    }

    public void isClicked(){
        for(OnClickListener ocl : listeners){
            ocl.tileClicked(this);
        }
    }



    public boolean setTileObject(TileObject tileObject){
        if(this.tileObject != null || tileObject == null){
            return false;
        }
        this.tileObject = tileObject;
        this.representation.addTileObjectRepresentation(tileObject.getTileObjectRepresentation());
        return true;
    }

    public boolean removeTileObject(){
        this.tileObject = null;
        this.representation.clearTileObjectRepresentation();
        return true;
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

    public void clear(){
        this.representation.clearRepresentation();
    }

}
