package com.company.domain.game;

import com.company.domain.core.Drawer;
import com.company.domain.core.Sprite;
import com.company.domain.models.TextureKey;

import java.awt.*;

/**
 * Created by max on 5/2/17.
 */
class Enemy extends Sprite {

    private static final int VELOCITY = 3;
    private static final int ENEMY_SIZE = 36;

    Enemy(com.company.domain.Window window, Point position, Drawer drawer) {
        super(window, position, new Dimension(ENEMY_SIZE, ENEMY_SIZE), TextureKey.ENEMY, drawer);
    }

    @Override
    public void update() {
        position.translate(0, -VELOCITY);
    }
}
