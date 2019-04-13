package main;

import main.utils.Logger;

import javax.swing.JFrame;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

public class Display extends Canvas {
    private final Logger LOG = new Logger(Display.class.getName());

    private JFrame         frame;
    private BufferedImage  image;
    private BufferStrategy bufferStrategy;
    private int[]          pixels;
    private Graphics       g;

    private String         title;

    private int            width;
    private int            height;

    public Display(int width, int height, String title) {
        this.width = width;
        this.height = height;
        this.title = title;
    }

    public void create() {
        if (image == null) {
            image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
        }

        if (frame == null) {
            setPreferredSize(new Dimension(width, height));

            frame = new JFrame(title);

            frame.setResizable(false);
            frame.add(this);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        }

        if (bufferStrategy == null) {
            createBufferStrategy(3);

            bufferStrategy = getBufferStrategy();
            g = bufferStrategy.getDrawGraphics();
        }
    }

    public void render() {
        do {
            do {
                g = bufferStrategy.getDrawGraphics();
                g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
                g.dispose();
            } while (bufferStrategy.contentsRestored());

            bufferStrategy.show();
        } while (bufferStrategy.contentsLost());
    }

    public void drawPixel(int x, int y, int color) {
        pixels[y * width + x] = color;
    }

    public JFrame getFrame() {
        return frame;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    public float getAspectRatio() {
        return (float) width / height;
    }

    public String getTitle() {
        return title;
    }
}
