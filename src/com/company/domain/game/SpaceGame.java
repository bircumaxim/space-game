package com.company.domain.game;

import com.company.domain.*;
import com.company.domain.core.GameObject;
import com.company.domain.models.TextureKey;
import com.company.presentation.AudioPlayerImp;
import com.company.presentation.DrawerImpl;

import java.awt.*;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by max on 5/1/17.
 */
public class SpaceGame implements Game {

    private com.company.domain.Window window;
    private ConcurrentLinkedQueue<GameObject> enemies;
    private ConcurrentLinkedQueue<GameObject> fires;
    private Player player;

    public SpaceGame(com.company.domain.Window window) {
        this.window = window;
        this.enemies = new ConcurrentLinkedQueue<>();
        this.fires = new ConcurrentLinkedQueue<>();
        this.player = new Player(window, AudioPlayerImp.getInstance(), DrawerImpl.getInstance(), fires);

        addEnemyWithInterval();
    }

    @Override
    public void update() {
        player.update();
        updateOrDelete(enemies);
        updateOrDelete(fires);
        checkCollision();
    }

    @Override
    public void render() {
        drawBackground();
        player.render();
        enemies.forEach(GameObject::render);
        fires.forEach(GameObject::render);
    }

    private void updateOrDelete(ConcurrentLinkedQueue<GameObject> gameObjects) {
        gameObjects.forEach(gameObject -> {
            gameObject.update();
            if (!gameObject.isAlive()) {
                gameObjects.remove(gameObject);
            }
        });
    }

    private void checkCollision() {
        enemies.forEach(enemy -> {
            fireCollide(enemy);
            playerCollide(enemy);
        });
    }

    private void fireCollide(GameObject enemy) {
        fires.forEach(fire -> {
            if (fire.collide(enemy)) {
                fires.remove(fire);
                enemies.remove(enemy);
            }
        });
    }

    private void playerCollide(GameObject enemy) {
        if (player.collide(enemy)) {
            player.setAlive(false);

            restartTheGame();
        }
    }

    private void restartTheGame() {
        new Timer().schedule(
                new TimerTask() {
                    @Override
                    public void run() {
                        enemies.clear();
                        fires.clear();

                        player.setAlive(true);
                    }
                }, 2000
        );
    }

    private void drawBackground() {
        Rectangle rect = new Rectangle(0, 0, window.getWidth() * 2, window.getHeight() * 2);
        DrawerImpl.getInstance().drawWithTexture(rect, TextureKey.BACKGROUND);
    }

    private Point getRandomPositionForEnemy() {
        Random rand = new Random();
        int y = window.getHeight();
        int x = rand.nextInt(window.getWidth() - 100);
        return new Point(x, y);
    }

    private void addEnemyWithInterval() {
        new Timer().schedule(
                new TimerTask() {
                    @Override
                    public void run() {
                        enemies.add(new Enemy(window, getRandomPositionForEnemy(), DrawerImpl.getInstance()));
                        addEnemyWithInterval();
                    }
                }, 500
        );
    }
}
