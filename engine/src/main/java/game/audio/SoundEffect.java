package game.audio;

public enum SoundEffect {
    JUMP("/sounds/jump.wav"),
    HIT("/sounds/hit.wav");

    private final String path;
    SoundEffect(String path) { this.path = path; }
    public String path() { return path; }
}
