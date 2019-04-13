package main;

import main.input.EventDispatcher;
import main.tracer.Tracer;
import main.utils.Logger;
import main.utils.Time;

public class Engine {
    private final Logger LOG = new Logger(Engine.class.getName());

    private Display         display;
    private Tracer          tracer;
    private EventDispatcher eventDispatcher;

    private boolean isRunning;

    public Engine(Display display) {
        this.display = display;

        tracer = new Tracer(display);
        eventDispatcher = new EventDispatcher(display);
    }

    public void start() {
        if (isRunning) return;

        isRunning = true;
        LOG.printMessage("Engine instance has been started!");
        run();
    }

    public void stop() {
        if (!isRunning) return;

        isRunning = false;
        LOG.printMessage("Engine instance has stopped!");
    }

    private void run() {
        Time.init();

        while (isRunning) {
            Time.updateDelta();

            if (Time.getDelta() >= Time.timeToUpdateFrame) {
                update();
                Time.resetDelta();
            }

            render();
            display.render();
            Time.updateFPS(display);

            try {
                Thread.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void update() {
        tracer.update(eventDispatcher);
    }

    private void render() {
        tracer.render();
    }
}
