package com.company.domain.utils;

import com.company.domain.core.GameObject;

import java.awt.*;

/**
 * Created by max on 5/1/17.
 */
public class RectangleUtils {

    private RectangleUtils() {

    }

    /**
     * Create a java Rectangular object for guve GameObject.
     *
     * @param gameObject
     * @return Java rectangular object.
     */
    public static Rectangle getRectFromGameObject(GameObject gameObject) {
        Point position = gameObject.getPosition();
        Dimension dimension = gameObject.getDimension();
        return new Rectangle(
                (int) position.getX(),
                (int) position.getY(),
                (int) dimension.getWidth(),
                (int) dimension.getHeight()
        );
    }
}
