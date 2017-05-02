package com.company.domain;

import com.company.domain.core.Drawer;
import com.company.domain.core.Sprite;
import com.company.domain.models.TextureKey;
import com.company.domain.utils.RectangleUtils;

import java.awt.*;

/**
 * Created by max on 5/2/17.
 */
public class Fire extends Sprite {

    private static final int VELOCITY  = 6;
    private static final int FIRE_SIZE = 16;
    private Drawer drawer;

    public Fire(Window window, Drawer drawer, Point position) {
        super(window, position, FIRE_SIZE, FIRE_SIZE);
        this.drawer = drawer;
    }

    @Override
    public void update() {
        move();
    }

    @Override
    public void render() {
        Rectangle rectangle = RectangleUtils.getRectFromGameObject(this);
        drawer.drawWithTexture(rectangle, TextureKey.FIRE);
    }

    private void move(){
        position.translate(0, VELOCITY);
    }
}
