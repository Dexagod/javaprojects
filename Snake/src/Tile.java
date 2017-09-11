import javafx.scene.layout.Pane;

public class Tile extends Pane {


    public Tile () {
        setWhite();
    }

    private boolean color;

    public void setBlack() {
        this.setStyle("-fx-background-color: #000000");
    }

    public void setWhite() {
        this.setStyle("-fx-background-color: #FFFFFF");
    }

}
