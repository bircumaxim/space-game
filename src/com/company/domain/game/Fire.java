package com.company.domain.game;

import com.company.domain.core.Drawer;
import com.company.domain.core.Sprite;
import com.company.domain.models.TextureKey;

import java.awt.*;

/**
 * Created by max on 5/2/17.
 */
public class Fire extends Sprite {

    private static final int VELOCITY = 6;
    private static final int FIRE_SIZE = 16;

    Fire(com.company.domain.Window window, Drawer drawer, Point position) {
        super(window, position, new Dimension(FIRE_SIZE, FIRE_SIZE), TextureKey.FIRE, drawer);
    }

    @Override
    public void update() {
        move();
    }

    private void move() {
        position.translate(0, VELOCITY);
    }
}
