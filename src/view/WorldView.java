package view;

import javafx.scene.Scene;
import javafx.scene.layout.GridPane;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import model.Tile;
import model.World;

public class WorldView extends GridPane {
    private  World world;

    public WorldView(World world) {
        super();
        this.world = world;

        for (int y = 0; y < world.getHeight(); y++) {
            for (int x = 0; x < world.getWidth(); x++) {
                Rectangle tile = new Rectangle(5, 5);
                tile.setFill(world.getTile(x, y) != null ? world.getTile(x, y).getColor() : Color.FUCHSIA);
                add(tile, x, y, 1, 1);
            }
        }
    }
}
