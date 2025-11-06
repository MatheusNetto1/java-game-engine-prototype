package game.physics;

import game.core.GameObject;

import java.awt.*;
import java.util.List;

public class PhysicsEngine {
    public void step(List<GameObject> objects, double dt) {
        for (GameObject a : objects) {
            Rectangle ra = a.getBounds();
            Vector vel = a.getVelocity();

            double nextX = a.getX() + vel.x * dt;
            double nextY = a.getY() + vel.y * dt;
            Rectangle rNext = new Rectangle((int)nextX, (int)nextY, ra.width, ra.height);

            for (GameObject b : objects) {
                if (a == b) continue;
                Rectangle rb = b.getBounds();
                if (Collider.aabbIntersect(rNext, rb)) {
                    if (vel.x > 0) nextX = rb.x - ra.width;
                    else if (vel.x < 0) nextX = rb.x + rb.width;
                    if (vel.y > 0) nextY = rb.y - ra.height;
                    else if (vel.y < 0) nextY = rb.y + rb.height;

                    vel = new Vector(0,0);
                    a.setVelocity(vel);
                }
            }
            a.translate(nextX - a.getX(), nextY - a.getY());
        }
    }
}