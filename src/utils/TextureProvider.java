package utils;

import javafx.scene.image.Image;

import java.net.URL;
import java.util.HashMap;

public class TextureProvider {
    private static final String TEXTURES_PATH = "/assets/textures/";
    private static final String TEXTURES_EXT = ".png";

    private static TextureProvider instance = new TextureProvider();
    private HashMap<String, Image> textures;

    private TextureProvider() {
        textures = new HashMap<>();
    }

    public static TextureProvider getInstance() {
        return instance;
    }

    public Image getTexture(String textureName) {
        Image texture = textures.get(textureName);

        if (texture != null)
            return texture;

        texture = new Image(TEXTURES_PATH + textureName + TEXTURES_EXT);
        textures.put(textureName, texture);

        return texture;
    }
}
