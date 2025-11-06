package game.core;

import java.awt.*;

public class Obstacle extends GameObject {
    public Obstacle(double x, double y, int w, int h) {
        super(x, y, w, h);
    }

    @Override
    public void update(double dt) {
        // static for now
    }

    @Override
    public void render(Graphics2D g) {
        g.setColor(Color.RED);
        g.fillRect((int)x, (int)y, width, height);
    }
}