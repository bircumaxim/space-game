package com.company.utils;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.glPopMatrix;

/**
 * Created by max on 5/1/17.
 */
public class Draw {

    private Draw() {
        //Should be private to avoid creation of instances of a static class.
    }

    /**
     * Draws a rectangular
     *
     * @param x        position of the center of the rectangular on x axis.
     * @param y        position of the center of the rectangular on y axis.
     * @param width    rectangular with.
     * @param height   rectangular height.
     * @param rotation angle of rotation relative to center.
     */
    public static void rect(int x, int y, float width, float height, float rotation) {
        glPushMatrix();
        {
            width /= 2;
            height /= 2;

            glTranslatef(x, y, 0);
            glRotatef(rotation, 0, 0, 1);

            glBegin(GL_QUADS);
            {
                glVertex2f(-width, -height);
                glVertex2f(-width, height);
                glVertex2f(width, height);
                glVertex2f(width, -height);
            }
            glEnd();
        }
        glPopMatrix();
    }
}
