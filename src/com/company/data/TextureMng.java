package com.company.data;

import com.company.domain.models.TextureKey;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

/**
 * Created by max on 5/2/17.
 */
public class TextureMng {
    private static TextureMng instance = new TextureMng();
    private static HashMap<TextureKey, Texture> loadedTextures = new HashMap<>();

    private TextureMng() {

    }

    public static TextureMng getInstance() {
        return instance;
    }

    public Texture loadTexture(TextureKey textureKey) {
        Texture texture = loadedTextures.get(textureKey);
        if (texture == null) {
            texture = loadTextureFromFile(textureKey);
            loadedTextures.put(textureKey, texture);
        }
        return texture;
    }

    private Texture loadTextureFromFile(TextureKey textureKey) {
        try {
            File textureFile = new File("res/" + textureKey.getName() + "." + textureKey.getFormat());
            return TextureLoader.getTexture(textureKey.getFormat(), new FileInputStream(textureFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
