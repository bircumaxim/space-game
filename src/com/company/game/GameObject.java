package com.company.game;

import javafx.geometry.Pos;

import javax.swing.text.Position;
import java.awt.*;

/**
 * Created by max on 5/1/17.
 */
public abstract class GameObject {
    protected Point position;
    protected Dimension dimension;

    public GameObject(int width, int height) {
        position = new Point(0, 0);
        dimension = new Dimension(width, height);
    }

    public GameObject(int x, int y, int width, int height) {
        position = new Point(x, y);
        dimension = new Dimension(width, height);
    }

    public Point getPosition() {
        return position;
    }

    public Dimension getDimension() {
        return dimension;
    }

    protected abstract void update();

    protected abstract void render();
}
