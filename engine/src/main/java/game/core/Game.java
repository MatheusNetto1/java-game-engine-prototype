package game.core;

import game.config.Config;
import game.graphics.Renderer;
import game.input.KeyManager;
import game.physics.PhysicsEngine;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Game {
    private final String title;
    private final int width, height;
    private final JFrame window;
    private final Renderer renderer;
    private final KeyManager keyManager;
    private final PhysicsEngine physics;

    private final List<GameObject> objects = new ArrayList<>();
    private GameLoop loop;

    public Game(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;

        window = new JFrame(title);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setResizable(false);

        renderer = new Renderer(width, height, this::render);
        renderer.setPreferredSize(new Dimension(width, height));

        keyManager = new KeyManager();
        renderer.addKeyListener(keyManager);
        renderer.setFocusable(true);
        renderer.requestFocus();

        physics = new PhysicsEngine();

        window.getContentPane().add(renderer, BorderLayout.CENTER);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);

        createDemoScene();
    }

    private void createDemoScene() {
        Player player = new Player(100, 100, 32, 32, keyManager);
        objects.add(player);

        // some obstacles
        objects.add(new Obstacle(300, 200, 100, 20));
        objects.add(new Obstacle(160, 360, 200, 20));
        objects.add(new Obstacle(520, 420, 50, 150));
    }

    public List<GameObject> getObjects() {
        return objects;
    }

    public PhysicsEngine getPhysics() {
        return physics;
    }

    public void start() {
        loop = new GameLoop(this, Config.TIME_STEP, renderer);
        loop.start();
    }

    public void update(double dt) {
        for (GameObject obj : new ArrayList<>(objects)) {
            obj.update(dt);
        }
        physics.step(objects, dt);
    }

    private void render(Graphics2D g) {
        g.setColor(Color.DARK_GRAY);
        g.fillRect(0, 0, renderer.getWidth(), renderer.getHeight());

        for (GameObject obj : objects) {
            obj.render(g);
        }

        g.setColor(Color.WHITE);
        g.drawString("Objects: " + objects.size(), 10, 20);
    }
}