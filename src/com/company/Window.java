package com.company;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import static org.lwjgl.opengl.GL11.*;

/**
 * Created by max on 5/1/17.
 */
class Window implements Runnable {

    private Game game;
    private String windowTitle;

    private int fps;
    private int windowWidth;
    private int windowHeight;

    Window(Game game, int fps, int windowWidth, int windowHeight, String windowTitle) {
        this.game = game;
        this.fps = fps;
        this.windowWidth = windowWidth;
        this.windowHeight = windowHeight;
        this.windowTitle = windowTitle;
    }

    @Override
    public void run() {
        game.init();
        initDisplay();
        initGL();
        windowLoop();
        clean();
    }

    private void windowLoop() {
        while (!Display.isCloseRequested()) {

            glClear(GL_COLOR_BUFFER_BIT);
            glLoadIdentity();

            game.update();
            game.render();

            Display.update();
            Display.sync(fps); //Smth. like delta time to sing frames and to make rendering CPU independent.
        }
    }

    private void initGL() {
        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        glOrtho(0, Display.getWidth(), 0, Display.getHeight(), -1, 1);
        glMatrixMode(GL_MODELVIEW);

        glClearColor(0, 0, 0, 1); //black color
        glDisable(GL_DEPTH_TEST);
    }

    private void clean() {
        Display.destroy();
    }

    private void initDisplay() {
        try {
            Display.setTitle(windowTitle);
            Display.setDisplayMode(new DisplayMode(windowWidth, windowHeight));
            Display.setVSyncEnabled(true);
            Display.create();

        } catch (LWJGLException e) {
            e.printStackTrace();
        }
    }
}
