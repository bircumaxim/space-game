package com.company.game;

import java.awt.*;

/**
 * Created by max on 5/1/17.
 */
public class Physics {
    /**
     * Check collision for 2 given game objects.
     *
     * @param gameObject1
     * @param gameObject2
     * @return True if 2 objects collide and false vice-versa.
     */
    public static boolean checkCollision(GameObject gameObject1, GameObject gameObject2) {
        Rectangle r1 = getRectFromGameObject(gameObject1);
        Rectangle r2 = getRectFromGameObject(gameObject2);
        return r1.intersects(r2);
    }

    /**
     * Create a java Rectangular object for guve GameObject.
     *
     * @param gameObject
     * @return Java rectangular object.
     */
    private static Rectangle getRectFromGameObject(GameObject gameObject) {
        Point position = gameObject.getPosition();
        Dimension dimension = gameObject.getDimension();
        return new Rectangle(
                (int) position.getX() - (int) (dimension.getWidth() / 2),
                (int) position.getY() - (int) (dimension.getHeight() / 2),
                (int) dimension.getWidth(),
                (int) dimension.getHeight()
        );
    }
}
