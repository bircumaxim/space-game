package com.company.domain;

import com.company.domain.core.Drawer;
import com.company.domain.core.AudioPlayer;
import com.company.domain.core.Sprite;
import com.company.domain.models.AudioKey;
import com.company.domain.models.Key;
import com.company.domain.models.TextureKey;
import com.company.domain.utils.RectangleUtils;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by max on 5/2/17.
 */
public class Player extends Sprite {


    private AudioPlayer pLayer;
    private Drawer drawer;

    private static final int VELOCITY = 2;
    private static final int PLAYER_SIZE = 42;
    private static final int FIRE_DELAY = 200;

    private boolean isFireAvailable;

    private ConcurrentLinkedQueue<Fire> fires;


    Player(Window window, AudioPlayer pLayer, Drawer drawer) {
        super(window, new Point(window.getWidth() / 2, 100), PLAYER_SIZE, PLAYER_SIZE);
        this.pLayer = pLayer;
        this.drawer = drawer;
        this.isFireAvailable = true;

        this.fires = new ConcurrentLinkedQueue<>();
    }

    @Override
    public void update() {
        move();
        if (window.isKeyDown(Key.KEY_SPACE) && isFireAvailable) {
            fire();
        }
        fireUpdate();
    }

    private void fireUpdate() {
        fires.forEach(fire -> {
            fire.update();
            if (!fire.isInWindow()) {
                fires.remove(fire);
            }
        });
    }

    @Override
    public void render() {
        Rectangle rectangle = RectangleUtils.getRectFromGameObject(this);
        drawer.drawWithTexture(rectangle, TextureKey.PLAYER);
        fires.forEach(Fire::render);
    }

    private void fire() {
        pLayer.play(AudioKey.FIRE);
        isFireAvailable = false;
        setFireAvailableAfter(FIRE_DELAY);

        fires.add(new Fire(window, drawer, new Point(position)));
    }

    private void move() {
        pLayer.stop(AudioKey.MOVING);
        if (window.isKeyDown(Key.KEY_W) && position.getY() + dimension.getHeight() / 2 < window.getHeight()) {
            position.translate(0, VELOCITY);
            pLayer.play(AudioKey.MOVING);
        }
        if (window.isKeyDown(Key.KEY_D) && position.getX() + dimension.getWidth() / 2 < window.getWidth()) {
            position.translate(VELOCITY, 0);
            pLayer.play(AudioKey.MOVING);
        }
        if (window.isKeyDown(Key.KEY_S) && position.getY() > dimension.getHeight() / 2) {
            position.translate(0, -VELOCITY);
            pLayer.play(AudioKey.MOVING);
        }
        if (window.isKeyDown(Key.KEY_A) && position.getX() > dimension.getWidth() / 2) {
            position.translate(-VELOCITY, 0);
            pLayer.play(AudioKey.MOVING);
        }
    }

    public void setFireAvailableAfter(long interval) {
        new Timer().schedule(
                new TimerTask() {
                    @Override
                    public void run() {
                        isFireAvailable = true;
                    }
                },
                interval
        );
    }
}
