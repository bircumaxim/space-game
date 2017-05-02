package com.company.domain.core;

import com.company.domain.models.TextureKey;

import java.awt.*;

/**
 * Created by max on 5/2/17.
 */
public interface Drawer {
    public void drawWithTexture(Rectangle rectangle, TextureKey texture);
}
