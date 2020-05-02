package view;

import controller.WorldController;
import javafx.scene.layout.Pane;

import model.Tile;
import model.World;

import java.util.ArrayList;

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
        ArrayList<Tile> tiles = world.getCamera().getViewedTiles();

        tiles.forEach((t) -> drawTile(t, tileWidth, tileHeight));

        //System.out.println(world.getCamera().getPx() + " " + world.getCamera().getPy());
        //System.out.println(tiles.get(0) != null ? tiles.get(0).getX() + " " + tiles.get(0).getY() : "null");
    }

    private void drawTile(Tile t, double tileWidth, double tileHeight) {
        if (t == null)
            return;
        TileView tileView = new TileView(t, tileWidth, tileHeight);
        tileView.relocate((t.getX() - world.getCamera().getPx()) * tileWidth / 2 -
                        (t.getY() - world.getCamera().getPy()) * tileWidth / 2,
                    (t.getX() - world.getCamera().getPx()) * tileHeight / 2 +
                        (t.getY() - world.getCamera().getPy()) * tileHeight / 2);

        getChildren().add(tileView);
    }

    public double getTileHeight() {
        return tileHeight;
    }

    public double getTileWidth() {
        return tileWidth;
    }
}
