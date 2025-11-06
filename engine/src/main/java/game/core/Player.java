package game.core;

import game.input.KeyManager;
import game.physics.Vector;
import game.config.Config;

import java.awt.*;

public class Player extends GameObject {
    private final KeyManager keys;

    public Player(double x, double y, int w, int h, KeyManager keys) {
        super(x, y, w, h);
        this.keys = keys;
    }

    @Override
    public void update(double dt) {
        double vx = 0, vy = 0;
        if (keys.isDown(KeyManager.Key.LEFT)) vx -= 1;
        if (keys.isDown(KeyManager.Key.RIGHT)) vx += 1;
        if (keys.isDown(KeyManager.Key.UP)) vy -= 1;
        if (keys.isDown(KeyManager.Key.DOWN)) vy += 1;

        Vector dir = new Vector(vx, vy);
        if (dir.length() > 0) {
            dir = dir.normalized().multiply(Config.PLAYER_SPEED);
        }

        this.setVelocity(dir);
        translate(getVelocity().x * dt, getVelocity().y * dt);
    }

    @Override
    public void render(Graphics2D g) {
        g.setColor(Color.CYAN);
        g.fillRect((int)x, (int)y, width, height);
        g.setColor(Color.BLACK);
        g.drawRect((int)x, (int)y, width, height);
    }
}