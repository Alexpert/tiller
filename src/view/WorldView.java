package view;

import controller.WorldController;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import model.Tile;
import model.World;

public class WorldView extends Pane {
    private World world;
    private WorldController worldController;
    private double tileWidth;
    private double tileHeight;

    public WorldView(World world) {
        super();
        this.world = world;
        this.worldController = new WorldController(this, world);
    }

    public void draw() {
        tileWidth = getPrefWidth() / world.getCamera().getWidth();
        tileHeight = getPrefHeight() / world.getCamera().getHeight();
        this.getChildren().removeAll(this.getChildren());

        world.getCamera().getViewedTiles().forEach((t) -> drawTile(t, tileWidth, tileHeight));
    }

    private void drawTile(Tile t, double tileWidth, double tileHeight) {
        ImageView tile = new ImageView(t.getTexture());
        tile.setFitHeight(tileHeight);
        tile.setFitWidth(tileWidth);
        tile.relocate(
                (getPrefWidth() / 2) + (t.getX() - world.getCamera().getPx()) * tileWidth / 2 -
                        (t.getY() - world.getCamera().getPy()) * tileWidth / 2,
                0 + (t.getX() - world.getCamera().getPx()) * tileHeight / 2 +
                        (t.getY() - world.getCamera().getPy()) * tileHeight / 2);
        getChildren().add(tile);
    }

    public double getTileHeight() {
        return tileHeight;
    }

    public double getTileWidth() {
        return tileWidth;
    }
}
