package view;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import model.World;

public class WorldView extends Pane {
    private World world;
    private int tileWidth = 60;
    private int tileHeight = 30;

    public WorldView(World world) {
        super();
        this.world = world;
    }

    public void draw() {
        for (int y = 0; y < world.getHeight(); y++) {
            for (int x = 0; x < world.getWidth(); x++) {

                ImageView tile = new ImageView(world.getTile(x, y).getTexture());
                tile.setFitHeight(tileHeight);
                tile.setFitWidth(tileWidth);
                tile.relocate((getPrefWidth() / 2) + x * tileWidth / 2 - y * tileWidth / 2,
                        0 + x * tileHeight / 2 + y * tileHeight / 2);
                getChildren().add(tile);
            }
        }
    }
}
