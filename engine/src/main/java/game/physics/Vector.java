package game.physics;

public class Vector {
    public final double x;
    public final double y;

    public Vector(double x, double y) { this.x = x; this.y = y; }

    public Vector add(Vector o) { return new Vector(x + o.x, y + o.y); }
    public Vector multiply(double s) { return new Vector(x * s, y * s); }
    public double length() { return Math.sqrt(x*x + y*y); }
    public Vector normalized() {
        double len = length();
        return len == 0 ? new Vector(0,0) : new Vector(x/len, y/len);
    }
}