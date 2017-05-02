package com.company.domain.models;

/**
 * Created by max on 5/2/17.
 */
public enum TextureKey {
    PLAYER("player", "png"),
    FIRE("fire", "png"),
    ENEMY("enemy", "png"),
    BACKGROUND("background", "png");

    private String name;
    private String format;

    TextureKey(String name, String format) {
        this.name = name;
        this.format = format;
    }

    public String getName() {
        return name;
    }

    public String getFormat() {
        return format;
    }
}
