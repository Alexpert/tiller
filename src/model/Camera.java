package model;

import java.util.ArrayList;

import static java.lang.Math.floor;

public class Camera {
    private World world;
    private double px = 20, py = 50 ;
    private double width = 50, height = 50;

    public Camera(World world) {
        this.world = world;
    }

    public ArrayList<Tile> getViewedTiles() {
        ArrayList<Tile> tiles = new ArrayList<>();
        for (int i = - 1; i < height + 1; i++)
            for (int j = - 1; j < width + 1; j++) {
                tiles.add(world.getTile((int) px + j + i, (int) py - j + i));
                tiles.add(world.getTile((int) px + j + 1 + i, (int) py - j + i));
            }

        System.out.println("Drawing " + tiles.size() + " tiles.");
        return tiles;
    }

    public double getPx() {
        return px;
    }

    public double getPy() {
        return py;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public void step() {
    }

    public void moveUp() {
        py -= height * 0.02;
        px -= height * 0.02;
    }

    public void moveDown() {
        py += height * 0.02;
        px += height * 0.02;
    }

    public void moveLeft() {
        py += width * 0.02;
        px -= width * 0.02;
    }

    public void moveRight() {
        py -= width * 0.02;
        px += width * 0.02;
    }

    public void zoom() {
        width *= 7d/6d;
        height *= 7d/6d;
    }

    public void unzoom() {
        width *= 6d/7d;
        height *= 6d/7d;
    }

    public void move(double dx, double dy) {
        px -= dx;
        py -= dy;
    }
}
