package com.company;

import com.company.game.SpaceGame;

public class Main {

    private static int FPS = 60;
    private static int WINDOW_WIDTH = 800;
    private static int WINDOW_HEIGHT = 600;
    private static String WINDOW_TITLE = "Space Shooter";

    public static void main(String[] args) {
        Game spaceGame = new SpaceGame();
        Window window = new Window(spaceGame, FPS, WINDOW_WIDTH, WINDOW_HEIGHT, WINDOW_TITLE);
        window.run();
    }
}
