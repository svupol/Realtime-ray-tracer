package main.tracer;

import main.Display;
import main.config.Config;
import main.input.EventDispatcher;
import main.input.KeyInputHandler;
import main.input.MouseInputHandler;
import main.tracer.scene.Model;
import main.tracer.scene.Illuminant;
import main.utils.mathUtils.Intersection;
import main.utils.mathUtils.Vector;
import main.tracer.scene.Scene;

import java.awt.event.KeyEvent;

public class Tracer {
    private Display display;
    private Scene scene;
    private Camera camera;
    private Viewport viewport;

    private final int BACKGROUND_COLOR = 0xFFFFFF;

    public Tracer(Display display) {
        this.display = display;

        viewport = new Viewport(display, Config.fov_horizontal);
        scene = new Scene();
        camera = new Camera(new Vector(0f, 0f, 0f), new Vector(0f, 0f, 1f));
    }

    public void render() {
        for (int y = 0; y < display.getHeight(); y++) {
            for (int x = 0; x < display.getWidth(); x++) {
                Ray ray = Ray.calcRay(x, y, display, viewport, camera);

                int color = traceRay(ray);
                display.drawPixel(x, y, color);
            }
        }
    }

    public void update(EventDispatcher eventDispatcher) {
        float displacement = 15;

        KeyInputHandler   key = eventDispatcher.getKeyInputHandler();
        MouseInputHandler mouse = eventDispatcher.getMouseInputHandler();

        if (key.isKeyPressed(KeyEvent.VK_W))
            camera.setPosition(new Vector(0, 0, displacement));
        if (key.isKeyPressed(KeyEvent.VK_S))
            camera.setPosition(new Vector(0, 0, -displacement));
        if (key.isKeyPressed(KeyEvent.VK_A))
            camera.setPosition(new Vector(-displacement, 0, 0));
        if (key.isKeyPressed(KeyEvent.VK_D))
            camera.setPosition(new Vector(displacement, 0, 0));
        if (key.isKeyPressed(KeyEvent.VK_SPACE))
            camera.setPosition(new Vector(0, displacement, 0));
        if (key.isKeyPressed(KeyEvent.VK_SHIFT))
            camera.setPosition(new Vector(0, -displacement, 0));


    }

    private int traceRay(Ray ray) {
        int color = BACKGROUND_COLOR;

        Model closestModel = null;
        Intersection closestI = null;

        for (Model model: scene.getModels()) {
            Intersection i = model.getPrimitive().intersect(ray);

            if (i != null && i.getT() > 0) {
                if (closestI == null) {
                    closestI = i;
                    closestModel = model;

                    continue;
                }

                // Ищем ближайшее пересечение
                boolean o = closestI.getPoint().length() > i.getPoint().length();
                closestI = o ? i : closestI;
                closestModel = o ? model : closestModel;
            }
        }

        if (closestI != null) {
            float alpha = computeLighting(closestI);

            color = closestModel.getMaterial().getRGB(alpha);
        }

        return color;
    }

    private float computeLighting(Intersection intersection) {
        float i = scene.ambientLight;

        for (Illuminant light: scene.getIlluminants()) {
            Vector modelNormal = intersection.getNormal();
            Vector L = light.getPosition().sub(intersection.getPoint());

            float dot = L.dotProduct(modelNormal);

            if (dot > 0) {
                i += light.getIntensity() * dot / L.length();
            }
        }

        if (i > 1) i = 1;

        return i;
    }
}
