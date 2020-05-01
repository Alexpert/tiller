package model;


import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import utils.TextureProvider;

public abstract class Tile {
    protected String textureName;
    protected Color color;

    protected Tile() {
    }

    public Color getColor() {
        return color;
    }

    public Image getTexture() {
        return TextureProvider.getInstance().getTexture(textureName);
    }
}
