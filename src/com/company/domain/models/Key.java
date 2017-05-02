package com.company.domain.models;

/**
 * Created by max on 5/2/17.
 */
public enum Key {
    KEY_W(17),
    KEY_D(32),
    KEY_S(31),
    KEY_A(30),
    KEY_SPACE(57);

    private int keyID;

    Key(int keyID) {
        this.keyID = keyID;
    }

    public int getKeyID() {
        return keyID;
    }
}
