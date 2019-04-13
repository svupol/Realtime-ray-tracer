package main.input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MouseInputHandler implements MouseMotionListener {
    private int x, y;

    @Override
    public void mouseMoved(MouseEvent e) {
        x = e.getX(); y = e.getY();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }


    @Override
    public void mouseDragged(MouseEvent e) {

    }
}
