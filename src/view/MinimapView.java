package view;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import model.World;


public class MinimapView extends Pane {
    private World world;
    private double tileWidth;
    private double tileHeight;

    public MinimapView(World world) {
        super();
        this.world = world;
    }

    public void draw() {
        tileWidth = this.getPrefWidth() / world.getWidth();
        tileHeight = this.getPrefHeight() / world.getHeight();
        System.out.println("w: " + tileWidth);
        System.out.println("h: " + tileHeight);

        for (int y = 0; y < world.getHeight(); y++) {
            for (int x = 0; x < world.getWidth(); x++) {

                Rectangle tile = new Rectangle(tileWidth, tileHeight, world.getTile(x, y).getColor());
                tile.relocate(x * tileWidth, y * tileHeight);

                getChildren().add(tile);
            }
        }

    }
}
