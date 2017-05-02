package com.company.domain;

import com.company.domain.core.Drawer;
import com.company.domain.core.GameObject;
import com.company.domain.models.TextureKey;
import com.company.presentation.AudioPlayerImp;
import com.company.presentation.DrawerImpl;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by max on 5/1/17.
 */
public class SpaceGame implements Game {

    private Window window;
    private ConcurrentLinkedQueue<GameObject> gameObjects;

    public SpaceGame(Window window) {
        this.window = window;
        this.gameObjects = new ConcurrentLinkedQueue<>();
        this.gameObjects.add(new Player(window, AudioPlayerImp.getInstance(), DrawerImpl.getInstance()));

        addEnemyWithInterval();
    }

    @Override
    public void update() {
        gameObjects.forEach(GameObject::update);
    }

    @Override
    public void render() {
        drawBackground();
        gameObjects.forEach(GameObject::render);
    }

    private void drawBackground() {
        Rectangle rect = new Rectangle(0, 0, window.getWidth() * 2, window.getHeight() * 2);
        DrawerImpl.getInstance().drawWithTexture(rect, TextureKey.BACKGROUND);
    }

    private Point getRandomPositionForEnemy() {
        Random rand = new Random();
        int y = window.getHeight();
        int x = rand.nextInt(window.getWidth() - 100) + 0;
        return new Point(x, y);
    }

    private void addEnemyWithInterval() {
        new Timer().schedule(
                new TimerTask() {
                    @Override
                    public void run() {
                        gameObjects.add(new Enemy(window, getRandomPositionForEnemy(), DrawerImpl.getInstance()));
                        addEnemyWithInterval();
                    }
                }, 500
        );
    }
}
