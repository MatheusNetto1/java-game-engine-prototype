package game.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.EnumMap;

public class KeyManager implements KeyListener {
    public enum Key { UP, DOWN, LEFT, RIGHT, ACTION }

    private final EnumMap<Key, Boolean> state = new EnumMap<>(Key.class);

    public KeyManager() {
        for (Key k : Key.values()) state.put(k, false);
    }

    public boolean isDown(Key k) {
        return state.getOrDefault(k, false);
    }

    @Override
    public void keyTyped(KeyEvent e) { }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W, KeyEvent.VK_UP -> state.put(Key.UP, true);
            case KeyEvent.VK_S, KeyEvent.VK_DOWN -> state.put(Key.DOWN, true);
            case KeyEvent.VK_A, KeyEvent.VK_LEFT -> state.put(Key.LEFT, true);
            case KeyEvent.VK_D, KeyEvent.VK_RIGHT -> state.put(Key.RIGHT, true);
            case KeyEvent.VK_SPACE -> state.put(Key.ACTION, true);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W, KeyEvent.VK_UP -> state.put(Key.UP, false);
            case KeyEvent.VK_S, KeyEvent.VK_DOWN -> state.put(Key.DOWN, false);
            case KeyEvent.VK_A, KeyEvent.VK_LEFT -> state.put(Key.LEFT, false);
            case KeyEvent.VK_D, KeyEvent.VK_RIGHT -> state.put(Key.RIGHT, false);
            case KeyEvent.VK_SPACE -> state.put(Key.ACTION, false);
        }
    }
}