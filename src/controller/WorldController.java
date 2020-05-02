package controller;

import javafx.scene.input.ScrollEvent;
import model.World;
import view.WorldView;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class WorldController {
    private enum State {MOVING, PRESSED, DRAGGING};

    private final World world;
    private State state = State.MOVING;
    private double px, py;

    public WorldController(WorldView worldView, World world) {
        this.world = world;
        worldView.setOnScroll(s -> handleScroll(s));

        worldView.setOnMousePressed(e -> {
            System.out.println(e.getEventType());
            switch (state) {
                case MOVING:
                    px = e.getX();
                    py = e.getY();
                    state = State.PRESSED;
                    break;
                default:
            };
            System.out.println(state.toString());
        });

        worldView.setOnMouseReleased(e -> {
            System.out.println(e.getEventType());
            switch (state) {
                case PRESSED:
                    state = State.MOVING;
                    break;
                case DRAGGING:
                    state = State.MOVING;
                    break;
                default:
            };
            System.out.println(state.toString());
        });

        worldView.setOnMouseDragged(e -> {
            System.out.println(e.getEventType());
            switch (state) {
                case PRESSED:
                    if (sqrt(pow((e.getX() - px), 2) + pow((e.getY() - py), 2)) > 5) {
                        state = State.DRAGGING;
                        world.getCamera().move((e.getX() - px) / worldView.getTileWidth(), (e.getY() - py) / worldView.getTileHeight());
                        px = e.getX();
                        py = e.getY();
                    }
                    break;
                case DRAGGING:
                    world.getCamera().move((e.getX() - px) / worldView.getTileWidth(), (e.getY() - py) / worldView.getTileWidth());
                    px = e.getX();
                    py = e.getY();
                    break;
                default:
            };
            System.out.println(state.toString());
        });
    }

    private void handleScroll(ScrollEvent s) {
        if (s.getDeltaY() > 0) {
            world.getCamera().zoom();
        } else if (s.getDeltaY() < 0){
            world.getCamera().unzoom();
        }
    }
}
