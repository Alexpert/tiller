package view;

import javafx.scene.image.ImageView;
import model.Entity;


public class EntityView extends ImageView {
    private Entity entity;

    public EntityView(Entity entity, double w, double h) {
        super(entity.getTexture());
        this.entity = entity;
        this.setFitHeight(h);
        this.setFitWidth(w);

    }
}
