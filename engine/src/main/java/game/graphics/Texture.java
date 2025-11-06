package game.graphics;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

/**
 * Simple texture loader — wraps a BufferedImage.
 */
public class Texture {
    private BufferedImage image;

    public Texture(String resourcePath) {
        try {
            URL url = getClass().getResource(resourcePath);
            if (url == null) throw new IOException("Texture not found: " + resourcePath);
            image = ImageIO.read(url);
        } catch (IOException e) {
            System.err.println("Failed to load texture: " + e.getMessage());
        }
    }

    public void draw(Graphics2D g, int x, int y, int width, int height) {
        if (image != null) {
            g.drawImage(image, x, y, width, height, null);
        } else {
            g.setColor(Color.MAGENTA);
            g.fillRect(x, y, width, height);
        }
    }
}