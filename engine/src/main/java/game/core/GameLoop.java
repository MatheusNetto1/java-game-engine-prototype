package game.core;

import game.config.Config;
import game.graphics.Renderer;

public class GameLoop extends Thread {
    private final Game game;
    private final double timeStep;
    private final Renderer renderer;
    private volatile boolean running = false;

    public GameLoop(Game game, double timeStep, Renderer renderer) {
        this.game = game;
        this.timeStep = timeStep;
        this.renderer = renderer;
    }

    @Override
    public void run() {
        running = true;
        long lastTime = System.nanoTime();
        double accumulator = 0.0;
        final double nsPerSec = 1_000_000_000.0;

        while (running) {
            long now = System.nanoTime();
            double frameTime = (now - lastTime) / nsPerSec;
            lastTime = now;
            accumulator += frameTime;

            while (accumulator >= timeStep) {
                game.update(timeStep);
                accumulator -= timeStep;
            }

            renderer.render();

            try {
                Thread.sleep((long)(1000.0 / Config.TARGET_FPS));
            } catch (InterruptedException ignored) {}
        }
    }

    public void stopLoop() {
        running = false;
    }
}