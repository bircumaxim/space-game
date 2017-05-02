package com.company.domain;

import com.company.domain.models.Key;

import java.awt.*;

/**
 * Created by max on 5/2/17.
 */
public abstract class Window implements Runnable {
    protected String title;

    protected int fps;
    protected int width;
    protected int height;
    protected Rectangle windowRectangle;

    protected Window(int fps, int windowWidth, int windowHeight, String windowTitle) {
        this.fps = fps;
        this.width = windowWidth;
        this.height = windowHeight;
        this.title = windowTitle;
        this.windowRectangle = new Rectangle(0, 0, windowWidth, windowHeight);
    }

    public String getTitle() {
        return title;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Rectangle getWindowRectangle() {
        return windowRectangle;
    }

    public abstract boolean isKeyDown(Key key);
}
