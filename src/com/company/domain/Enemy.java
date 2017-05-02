package com.company.domain;

import com.company.domain.core.Drawer;
import com.company.domain.core.Sprite;
import com.company.domain.models.TextureKey;
import com.company.domain.utils.RectangleUtils;

import java.awt.*;

/**
 * Created by max on 5/2/17.
 */
public class Enemy extends Sprite {

    private static final int VELOCITY = 3;
    private static final int ENEMY_SIZE = 26;
    private Drawer drawer;

    public Enemy(Window window, Point position, Drawer drawer) {
        super(window, position, ENEMY_SIZE, ENEMY_SIZE);
        this.drawer = drawer;
    }

    @Override
    public void update() {
        position.translate(0, -VELOCITY);
    }

    @Override
    public void render() {
        Rectangle rectangle = RectangleUtils.getRectFromGameObject(this);
        drawer.drawWithTexture(rectangle, TextureKey.ENEMY);
    }
}
