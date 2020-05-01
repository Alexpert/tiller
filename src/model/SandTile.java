package model;

import javafx.scene.paint.Color;

public class SandTile extends Tile {

    public SandTile(int x, int y) {
        super(x, y);
        textureName = "sand";
        color = Color.YELLOW;
    }
}
