package model;

import javafx.scene.paint.Color;

public class GrassTile extends Tile {

    public GrassTile(int x, int y) {
        super(x, y);
        textureName = "grass";
        color = Color.GREEN;
    }
}
