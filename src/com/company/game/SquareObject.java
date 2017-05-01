package com.company.game;

import com.company.utils.Draw;

/**
 * Created by max on 5/1/17.
 */
public class SquareObject extends GameObject {

    public SquareObject(int width, int height) {
        super(width, height);
    }

    @Override
    protected void update() {
        position.translate(1, 1);
    }

    @Override
    protected void render() {
        int x = (int) position.getX();
        int y = (int) position.getY();
        int width = (int) dimension.getWidth();
        int height = (int) dimension.getHeight();

        Draw.rect(x, y, width, height, 0);
    }
}
