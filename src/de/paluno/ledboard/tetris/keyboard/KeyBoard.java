package de.paluno.ledboard.tetris.keyboard;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class KeyBoard implements KeyListener {

    private final List<Key> pressedKeys;
    public KeyBoard(List<Key> pressedKeys) {
        this.pressedKeys = pressedKeys;
    }

    public synchronized List<Key> deliverPressedKeys() {
        List<Key> deliveredKeys = new ArrayList<>();
        for (Key pressedKey : this.pressedKeys) {
            deliveredKeys.add(pressedKey);
        }
        this.pressedKeys.clear();
        return deliveredKeys;
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        Optional<Key> pressedKey = Key.fromKeyCode(e.getKeyCode());
        pressedKey.ifPresent(key -> pressedKeys.add(key));
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }


}
