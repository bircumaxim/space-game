package com.company.presentation;

import com.company.data.TextureMng;
import com.company.domain.core.Drawer;
import com.company.domain.models.TextureKey;
import com.company.presentation.utils.Draw;

import java.awt.*;

/**
 * Created by max on 5/2/17.
 */
public class DrawerImpl implements Drawer {
    private static DrawerImpl instance = new DrawerImpl();

    private DrawerImpl() {
    }

    public static DrawerImpl getInstance() {
        return instance;
    }

    @Override
    public void drawWithTexture(Rectangle rectangle, TextureKey textureKey) {
        Draw.rectWithTexture(
                (int) rectangle.getX(),
                (int) rectangle.getY(),
                (int) rectangle.getWidth(),
                (int) rectangle.getHeight(),
                TextureMng.getInstance().loadTexture(textureKey)
        );
    }
}
