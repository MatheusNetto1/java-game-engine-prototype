package game.graphics;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.function.Consumer;

public class Renderer extends Canvas {
    private final Consumer<Graphics2D> renderCallback;

    public Renderer(int width, int height, Consumer<Graphics2D> renderCallback) {
        this.renderCallback = renderCallback;
        setPreferredSize(new Dimension(width, height));
        setIgnoreRepaint(true);
    }

    public void render() {
        BufferStrategy bs = getBufferStrategy();
        if (bs == null) {
            createBufferStrategy(2);
            return;
        }

        Graphics g = bs.getDrawGraphics();
        try {
            Graphics2D g2d = (Graphics2D) g;
            renderCallback.accept(g2d);
        } finally {
            g.dispose();
        }
        bs.show();
        Toolkit.getDefaultToolkit().sync();
    }

    @Override
    public void addNotify() {
        super.addNotify();
        requestFocus();
    }
}