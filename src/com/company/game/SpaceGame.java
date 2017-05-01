package com.company.game;

import com.company.Game;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by max on 5/1/17.
 */
public class SpaceGame implements Game {

    private List<GameObject> gameObjects;

    public SpaceGame() {
        this.gameObjects = new ArrayList<>();
        this.gameObjects.add(new SquareObject(20, 20));
    }

    @Override
    public void init() {

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
