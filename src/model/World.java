package model;

import utils.WorldBuilder;

public class World {
    private int width;
    private int height;
    private Tile tiles[][];

    public World(int width, int height) {
        this.width = width;
        this.height = height;

        this.tiles = WorldBuilder.generate(width, height);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Tile getTile(int x, int y) {
        return this.tiles[x][y];
    }

    private void setTile(int x, int y, Tile tile) {
        this.tiles[x][y] = tile;
    }
}
