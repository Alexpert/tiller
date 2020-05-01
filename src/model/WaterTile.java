package model;

import javafx.scene.paint.Color;

public class WaterTile extends Tile {

    public WaterTile(int x, int y) {
        super(x, y);
        textureName = "water";
        color = Color.BLUE;
    }
}
