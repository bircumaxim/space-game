package com.company.domain.models;

/**
 * Created by max on 5/2/17.
 */
public enum AudioKey {
    FIRE("fire","ogg"),
    MOVING("moving", "ogg");

    private String name;
    private String format;

    AudioKey(String name, String format) {
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
