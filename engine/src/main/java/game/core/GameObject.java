package game.core;

import java.awt.*;
import game.physics.Vector;

public abstract class GameObject {
    protected double x, y;
    protected int width, height;
    private Vector velocity = new Vector(0,0);

    public GameObject(double x, double y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public Rectangle getBounds() {
        return new Rectangle((int)x, (int)y, width, height);
    }

    public abstract void update(double dt);
    public abstract void render(Graphics2D g);

    public double getX() { return x; }
    public double getY() { return y; }

    public Vector getVelocity() { return velocity; }
    public void setVelocity(Vector v) { this.velocity = v; }

    public void translate(double dx, double dy) {
        this.x += dx;
        this.y += dy;
    }
}