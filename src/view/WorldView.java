package view;

import javafx.scene.Scene;
import javafx.scene.image.ImageView;
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

                ImageView tile = new ImageView(world.getTile(x, y).getTexture());
                tile.setFitHeight(5);
                tile.setFitWidth(   5);

                add(tile, x, y, 1, 1);
            }
        }
    }
}
