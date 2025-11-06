package game.audio;

import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;

public class AudioManager {
    public static void playSound(String resourcePath) {
        try {
            URL url = AudioManager.class.getResource(resourcePath);
            if (url == null) return;
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.err.println("Couldn't play sound: " + e.getMessage());
        }
    }
}