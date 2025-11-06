package game.physics;

import java.awt.*;

public class Collider {
    public static boolean aabbIntersect(Rectangle a, Rectangle b) {
        return a.intersects(b);
    }
}