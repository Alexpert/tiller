package model;

import javafx.scene.paint.Color;

public class RockTile extends Tile {

    public RockTile(int x, int y) {
        super(x, y);
        textureName = "rock";
        color = Color.GRAY;

    }
}
