# Java Game Engine Prototype

A lightweight 2D Java game engine prototype, designed from scratch to demonstrate a custom game loop, physics system, rendering pipeline, and basic input management — all built without relying on external frameworks.
> This project aims to serve as both a learning tool and a foundation for more advanced engine development in Java (e.g., entity systems, shaders, scenes, and texture management).

---

## Features

* Custom Game Loop – Fixed time step for consistent updates at 60 FPS
* Real-Time Rendering – Double-buffered graphics using BufferStrategy
* Physics Engine – AABB collision detection and simple response system
* Keyboard Input – WASD + Arrow key movement via a centralized manager
* Scene Management – Dynamic object list with update and render phases
* Extensible Design – Easy to add new game objects or systems
* Object-Oriented Architecture – Clean modular package structure

---

## Architecture Overview

```
game/
├── audio/
│   ├── AudioManager.java
│   └── SoundEffect.java
├── config/
│   └── Config.java             # Game constants (FPS, speed, gravity, etc.)
├── core/
│   ├── Game.java               # Main game manager
│   ├── GameLoop.java           # Time step loop (update + render)
│   ├── GameObject.java         # Base entity class
│   ├── Player.java             # Example movable entity
│   └── Obstacle.java           # Example static entity
├── graphics/
│   ├── Renderer.java           # Rendering pipeline
│   ├── Shader.java             # Brightness manipulation helper
│   └── Texture.java            # Texture loader
├── input/
│   └── KeyManager.java         # Keyboard input handler
├── physics/
│   ├── Collider.java           # AABB intersection logic
│   ├── PhysicsEngine.java      # Object movement and collision handling
│   └── Vector.java             # Math utility class
└── App.java                    # Entry point         
```

---

## How It Works

* **Game Loop**: Runs at a fixed `TIME_STEP` defined in `Config`, ensuring deterministic updates.
* **Renderer**: Uses Java’s `BufferStrategy` to draw graphics at up to 120Hz refresh rate.
* **Physics Engine**: Checks collisions via axis-aligned bounding boxes and adjusts positions accordingly.
* **Input System**: `KeyManager` tracks the current state of keys (`UP`, `DOWN`, `LEFT`, `RIGHT`, `ACTION`).
* **Entities**: Every game element extends `GameObject` and implements `update()` and `render()`.

---

## Controls

| Key   | Action |
| :----: | :-----: |
| W / ↑ | Move up |
| S / ↓ | Move down |
| A / ← | Move left |
| D / → | Move right |
| SPACE | Action (reserved for future features) |

---

## Learning Focus

This project was built to explore:
* Game loop synchronization (`update()` vs `render()`)
* Time-step based physics updates
* Real-time rendering using Java’s AWT
* Keyboard event-driven movement
* Collision handling logic (AABB)
* Clean OOP architecture for game engines

---

## Future Improvements

* Add sprite-based rendering
* Implement jump and gravity-based physics
* Add simple UI / HUD system
* Scene and level management
* Expand Shader and Texture systems
* Switch to OpenGL (LWJGL) for hardware acceleration

---

## Author

**Matheus Netto**<br>
Software Engineering Student | Game & Engine Development Enthusiast | 
[LinkedIn](http://linkedin.com/in/matheusnetto-) | 
[Github](https://github.com/MatheusNetto1)

---

## License
This project is licensed under the [MIT License](https://github.com/MatheusNetto1/java-game-engine-prototype/blob/main/LICENSE) — feel free to use, modify, and learn from it.