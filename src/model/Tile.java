package model;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import utils.TextureProvider;

import java.util.ArrayList;

public abstract class Tile {
    protected String textureName;
    protected Color color;
    protected int x, y;
    protected ArrayList<Entity> entities;

    protected Tile(int x, int y) {
        this.x = x;
        this.y = y;
        entities = new ArrayList<>();
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

    public ArrayList<Entity> getEntities() {
        return this.entities;
    }

    public void addEntity(Entity entity) {
        this.entities.add(entity);
    }
}
