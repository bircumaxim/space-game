package com.company;


import com.company.domain.Game;
import com.company.domain.SpaceGame;
import com.company.presentation.windows.MainWindow;

public class Main {

    private static int FPS = 60;
    private static int WINDOW_WIDTH = 800;
    private static int WINDOW_HEIGHT = 600;
    private static String WINDOW_TITLE = "Space Shooter";

    public static void main(String[] args) {
        MainWindow window = new MainWindow(FPS, WINDOW_WIDTH, WINDOW_HEIGHT, WINDOW_TITLE);

        Game spaceGame = new SpaceGame(window);
        window.setGame(spaceGame);

        window.run();
    }
}
