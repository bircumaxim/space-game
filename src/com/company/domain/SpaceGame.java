package com.company.domain;

import com.company.domain.core.GameObject;
import com.company.presentation.AudioPlayerImp;
import com.company.presentation.DrawerImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by max on 5/1/17.
 */
public class SpaceGame implements Game {

    private Window window;
    private List<GameObject> gameObjects;

    public SpaceGame(Window window) {
        this.window = window;
        this.gameObjects = new ArrayList<>();

        this.gameObjects.add(new Player(window, AudioPlayerImp.getInstance(), DrawerImpl.getInstance()));
    }

    @Override
    public void update() {
        gameObjects.forEach(GameObject::update);
    }

    @Override
    public void render() {
        gameObjects.forEach(GameObject::render);
    }

}
