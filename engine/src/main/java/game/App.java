package game;

import game.core.Game;

public class App {
    public static void main(String[] args) {
        Game game = new Game("ProtoEngine - Demo", 800, 600);
        game.start();
    }
}