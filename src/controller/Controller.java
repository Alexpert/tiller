package controller;

import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import model.World;

import java.util.Set;
import java.util.HashSet;

public class Controller {
    private final World world;
    private Set<KeyCode> pressedKeys;
    public Controller(Scene scene, World world) {
        this.pressedKeys = new HashSet<>();
        this.world = world;

        scene.setOnKeyPressed((e) -> pressedKeys.add(e.getCode()));
        scene.setOnKeyReleased((e) -> pressedKeys.remove(e.getCode()));
    }

    public void step() {
        pressedKeys.forEach((k) -> {
            switch (k) {
                case UP:
                    world.getCamera().moveUp();
                    break;
                case DOWN:
                    world.getCamera().moveDown();
                    break;
                case LEFT:
                    world.getCamera().moveLeft();
                    break;
                case RIGHT:
                    world.getCamera().moveRight();
                    break;
                default:
                    break;
            };
        });
    }
}
