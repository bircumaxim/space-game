package com.company.presentation.windows;

import com.company.domain.Game;
import com.company.domain.Window;
import com.company.domain.models.Key;
import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import static org.lwjgl.opengl.GL11.*;

/**
 * Created by max on 5/1/17.
 */
public class MainWindow extends Window {
    private Game game;

    public MainWindow(int fps, int windowWidth, int windowHeight, String windowTitle) {
        super(fps, windowWidth, windowHeight, windowTitle);
    }

    @Override
    public boolean isKeyDown(Key key) {
        return Keyboard.isKeyDown(key.getKeyID());
    }

    public void setGame(Game game) {
        this.game = game;
    }

    @Override
    public void run() {
        initDisplay();
        initGL();
        windowLoop();
        clean();
    }

    private void windowLoop() {
        while (!Display.isCloseRequested()) {

            glClear(GL_COLOR_BUFFER_BIT);
            glLoadIdentity();

            if (game != null) {
                game.update();
                game.render();
            }

            Display.update();
            Display.sync(fps);
        }
    }

    private void initGL() {
        glEnable(GL_TEXTURE_2D);

        glEnable(GL_BLEND);
        glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);

        glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        glOrtho(0, Display.getWidth(), 0, Display.getHeight(), -1, 1);
        glMatrixMode(GL_MODELVIEW);

        glDisable(GL_DEPTH_TEST);

    }

    private void clean() {
        Display.destroy();
    }

    private void initDisplay() {
        try {
            Display.setTitle(title);
            Display.setDisplayMode(new DisplayMode(width, height));
            Display.setVSyncEnabled(true);
            Display.create();

        } catch (LWJGLException e) {
            e.printStackTrace();
        }
    }

}
