package model;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import utils.TextureProvider;

public class Entity {
    protected String textureName = "default";
    protected Color color;
    protected Tile tile;

    public Entity(Tile tile) {
        this.tile = tile;
        tile.addEntity(this);
    }

    public Image getTexture() {
        return TextureProvider.getInstance().getTexture(textureName);
    }
}
