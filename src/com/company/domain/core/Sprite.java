package com.company.domain.core;

import com.company.domain.Window;
import com.company.domain.models.TextureKey;
import com.company.domain.utils.RectangleUtils;

import java.awt.*;

/**
 * Created by max on 5/2/17.
 */
public abstract class Sprite extends GameObject {

    private Drawer drawer;
    private TextureKey textureKey;

    public Sprite(Window window, Dimension dimension, TextureKey textureKey, Drawer drawer) {
        super(window, dimension);
        this.textureKey = textureKey;
        this.drawer = drawer;
    }

    public Sprite(Window window, Point position, Dimension dimension, TextureKey textureKey, Drawer drawer) {
        super(window, position,dimension);
        this.textureKey = textureKey;
        this.drawer = drawer;
    }

    @Override
    public void render() {
        if(isAlive){
            Rectangle rectangle = RectangleUtils.getRectFromGameObject(this);
            drawer.drawWithTexture(rectangle, textureKey);
        }
    }
}
