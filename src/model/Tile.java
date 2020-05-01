package model;


import javafx.scene.paint.Color;

public class Tile {
    private Color color;

    public Tile() {
        color = Color.GREEN;
    }

    public Tile(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}
