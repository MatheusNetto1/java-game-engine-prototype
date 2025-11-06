package game.graphics;

/**
 * Simple shader placeholder class — simulates color tint or brightness.
 */
public class Shader {
    private float brightness = 1.0f;

    public void setBrightness(float brightness) {
        this.brightness = Math.max(0, Math.min(brightness, 2.0f));
    }

    public float getBrightness() {
        return brightness;
    }

    public int apply(int rgb) {
        int r = (rgb >> 16) & 0xFF;
        int g = (rgb >> 8) & 0xFF;
        int b = rgb & 0xFF;
        r = Math.min(255, (int)(r * brightness));
        g = Math.min(255, (int)(g * brightness));
        b = Math.min(255, (int)(b * brightness));
        return (r << 16) | (g << 8) | b;
    }
}