package model;


import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import utils.TextureProvider;

public abstract class Tile {
    protected String textureName;
    protected Color color;
    protected int x, y;

    protected Tile(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Color getColor() {
        return color;
    }

    public Image getTexture() {
        return TextureProvider.getInstance().getTexture(textureName);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
