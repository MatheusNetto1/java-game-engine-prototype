package game.config;

public final class Config {
    private Config() {}

    public static final int TARGET_FPS = 60;
    public static final double TIME_STEP = 1.0 / TARGET_FPS; // 60 updates per second
    public static final double PLAYER_SPEED = 200.0;   // pixels per second
    public static final double GRAVITY = 9.8;
}