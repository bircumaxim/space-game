package com.company.domain.core;

import com.company.domain.Window;

import java.awt.*;

/**
 * Created by max on 5/2/17.
 */
public abstract class Sprite extends GameObject {

    public Sprite(Window window, int width, int height) {
        super(window, width, height);
    }

    public Sprite(Window window, Point position, int width, int height) {
        super(window, position, width, height);
    }
}
