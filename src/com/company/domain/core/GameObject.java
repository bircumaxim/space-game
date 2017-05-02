package com.company.domain.core;

import com.company.domain.Window;
import com.company.domain.utils.RectangleUtils;

import javax.swing.text.Position;
import java.awt.*;

/**
 * Created by max on 5/1/17.
 */
public abstract class GameObject {
    protected Window window;
    protected Point position;
    protected Dimension dimension;

    public GameObject(Window window, int width, int height) {
        this.window = window;
        position = new Point(window.getWidth() / 2, window.getHeight() / 2);
        dimension = new Dimension(width, height);
    }

    GameObject(Window window, Point position, int width, int height) {
        this.window = window;
        this.position = position;
        dimension = new Dimension(width, height);
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
        return r1.intersects(r2);
    }

    public abstract void update();

    public abstract void render();

    public boolean isInWindow() {
        return window.getWindowRectangle().contains(RectangleUtils.getRectFromGameObject(this));
    }
}
