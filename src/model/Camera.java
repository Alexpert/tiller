package model;

import java.util.ArrayList;

import static java.lang.Math.floor;

public class Camera {
    private World world;
    private double px = 0, py = 0;
    private double width = 20, height = 30;

    public Camera(World world) {
        this.world = world;
    }

    public ArrayList<Tile> getViewedTiles() {
        ArrayList<Tile> tiles = new ArrayList<>();

        for (int y = (int) floor(py - height); y < py + 2*height; y++) {
            for (int x = (int) floor(px - width); x < px + 2*width; x++) {
                if(x >= 0 && y >= 0 && x < world.getWidth() && y < world.getHeight())
                    tiles.add(world.getTile(x, y));
            }
        }

        //System.out.println("Drawing " + tiles.size() + " tiles.");
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
        px -= width * 0.02;
    }

    public void moveDown() {
        py += height * 0.02;
        px += width * 0.02;
    }

    public void moveLeft() {
        py += height * 0.02;
        px -= width * 0.02;
    }

    public void moveRight() {
        py -= height * 0.02;
        px += width * 0.02;
    }

    public void zoom() {
        width += 0.3;
        height += 0.3;
    }

    public void unzoom() {
        width -= 0.3;
        height -= 0.3;
    }

    public void move(double dx, double dy) {
        px -= dx;
        py -= dy;
    }
}
