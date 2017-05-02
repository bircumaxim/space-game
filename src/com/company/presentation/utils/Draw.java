package com.company.presentation.utils;

import org.newdawn.slick.opengl.Texture;

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
     *Draw a rectangular using a given texture.
     *
     * @param x        position of the center of the rectangular on x axis.
     * @param y        position of the center of the rectangular on y axis.
     * @param width    rectangular with.
     * @param height   rectangular height.
     * @param texture  texture that will be used for drawing.
     */
    public static void rectWithTexture(int x, int y, float width, float height, Texture texture) {
        if (texture != null) {
            texture.bind();
        }
        rect(x, y, width, height);
    }

    /**
     * Draws a rectangular
     *
     * @param x        position of the center of the rectangular on x axis.
     * @param y        position of the center of the rectangular on y axis.
     * @param width    rectangular with.
     * @param height   rectangular height.
     */
    public static void rect(int x, int y, float width, float height) {
        glTranslatef(x, y, 0);

        width /= 2;
        height /= 2;

        glBegin(GL_QUADS);
        {
            glVertex2f(-width, -height);
            glTexCoord2f(0, 0);
            glVertex2f(-width, height);
            glTexCoord2f(1, 0);
            glVertex2f(width, height);
            glTexCoord2f(1, 1);
            glVertex2f(width, -height);
            glTexCoord2f(0, 1);
        }
        glEnd();
    }


}
