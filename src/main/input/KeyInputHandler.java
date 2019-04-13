package main.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyInputHandler implements KeyListener {
    private boolean[] keys;

    public KeyInputHandler() {
        keys = new boolean[255];
    }

    public boolean isKeyPressed(int keyCode) {
        return keys[keyCode];
    }

    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
}
