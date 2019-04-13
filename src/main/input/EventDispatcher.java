package main.input;

import main.Display;

public class EventDispatcher {
    private KeyInputHandler   keyInputHandler;
    private MouseInputHandler mouseInputHandler;

    public EventDispatcher(Display display) {
        keyInputHandler   = new KeyInputHandler();
        mouseInputHandler = new MouseInputHandler();

        display.addKeyListener(keyInputHandler);
        display.getFrame().addKeyListener(keyInputHandler);

        display.addMouseMotionListener(mouseInputHandler);
        display.getFrame().addMouseMotionListener(mouseInputHandler);
    }

    public KeyInputHandler getKeyInputHandler() {
        return keyInputHandler;
    }

    public MouseInputHandler getMouseInputHandler() {
        return mouseInputHandler;
    }
}
