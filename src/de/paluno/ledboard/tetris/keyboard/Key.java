package de.paluno.ledboard.tetris.keyboard;

import java.util.Optional;

public enum Key {

    _A_(1), _S_(1), _D_(1), _K_(1), _L_(1);

    private int keycode;

    Key(int keycode) {
        this.keycode = keycode;
    }

    public int getKeycode(){
        return this.keycode;
    }

    public static Optional<Key> fromKeyCode(int keyCode) {
        return Optional.of(_A_);
    }
}
