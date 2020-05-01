package model;

import utils.WorldBuilder;

public class World {
    private int width;
    private int height;
    private Tile tiles[][];
    private Camera camera;

    public World(int width, int height) {
        this.width = width;
        this.height = height;

        this.tiles = WorldBuilder.generate(width, height);
        this.camera = new Camera(this);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Tile getTile(int x, int y) {
        if(x >= 0 && y >= 0 && x < width && y < height)
            return this.tiles[x][y];
        return null;
    }

    public Camera getCamera() {
        return camera;
    }

    private void setTile(int x, int y, Tile tile) {
        this.tiles[x][y] = tile;
    }

    public void step() {
        camera.step();
    }
}
