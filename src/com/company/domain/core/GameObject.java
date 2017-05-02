package com.company.domain.core;

import com.company.domain.Window;
import com.company.domain.utils.RectangleUtils;

import java.awt.*;

/**
 * Created by max on 5/1/17.
 */
public abstract class GameObject {
    protected Window window;
    protected Point position;
    protected Dimension dimension;
    protected boolean isAlive;

    GameObject(Window window, Dimension dimension) {
        this.window = window;
        position = new Point(window.getWidth() / 2, window.getHeight() / 2);
        this.dimension = dimension;
        isAlive = true;
    }

    GameObject(Window window, Point position, Dimension dimension) {
        this.window = window;
        this.position = position;
        this.dimension = dimension;
        isAlive = true;
    }

    public Point getPosition() {
        return position;
    }

    public Dimension getDimension() {
        return dimension;
    }

    /**
     * Check collision for 2 given game objects.
     *
     * @param gameObject
     * @return True if objects collide and false vice-versa.
     */
    public boolean collide(GameObject gameObject) {
        Rectangle r1 = RectangleUtils.getRectFromGameObject(this);
        Rectangle r2 = RectangleUtils.getRectFromGameObject(gameObject);
        return r1.intersects(r2) && isAlive;
    }

    public abstract void update();

    public abstract void render();

    public boolean isInWindow() {
        return window.getWindowRectangle().contains(RectangleUtils.getRectFromGameObject(this));
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }
}
