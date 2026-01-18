# Space Invaders FXGL

A classic Space Invaders game implementation built with FXGL (JavaFX Game Library).

## Description

This is a Space Invaders game featuring:
- Player-controlled spaceship
- Enemy fleet with synchronized movement
- Score tracking system
- Physics-based collision detection
- Retro-style space theme with dark background

## Requirements

- Java 25
- Maven 3.x
- FXGL 21.1

## Project Structure

```
space-invaders/
├── src/
│   └── main/
│       ├── java/
│       │   └── pro/davidvazquez/fxgl/spaceinvaders/
│       │       ├── SpaceInvadersApp.java       # Main application class
│       │       ├── SpaceInvadersFactory.java   # Entity factory
│       │       ├── PlayerShipComponent.java    # Player ship behavior
│       │       ├── EnemyDividerComponent.java  # Enemy fleet behavior
│       │       ├── FleetDirection.java         # Fleet direction enum
│       │       └── EntityType.java             # Entity type definitions
│       └── resources/
├── pom.xml
└── README.md
```

## Building the Project

```bash
mvn clean compile
```

## Running the Game

```bash
mvn exec:java -Dexec.mainClass="pro.davidvazquez.fxgl.spaceinvaders.SpaceInvadersApp"
```

Or run the main class directly from your IDE:
```
pro.davidvazquez.fxgl.spaceinvaders.SpaceInvadersApp
```

## How to Play

### Controls
- **A** - Move spaceship left
- **D** - Move spaceship right
- **SPACE** - Shoot missiles

### Rules
- Control your spaceship at the bottom of the screen
- Destroy enemy invaders before they reach you
- Avoid enemy missiles
- Score points for each enemy destroyed
- First to reach 11 points wins
- Game ends when enemies reach the bottom or you're destroyed

## Game Components

### SpaceInvadersApp
The main application class that initializes the game, sets up input controls, manages game state, and handles UI rendering.

### PlayerShipComponent
Controls player spaceship movement (left and right) and shooting mechanics.

### EnemyDividerComponent
Manages enemy fleet movement patterns and synchronized behavior across the enemy formation.

### FleetDirection
Enum defining the direction of enemy fleet movement (LEFT, RIGHT, DOWN).

### SpaceInvadersFactory
Factory class responsible for spawning game entities (player ship, enemies, missiles, and walls).

## Dependencies

This project uses FXGL 21.1, a comprehensive JavaFX game development framework that provides:
- Entity-component system
- Physics engine
- Input handling
- Collision detection
- UI utilities

## Resources

This project was developed following concepts from **"Learn JavaFX Game and App Development"** by Almas Baimagambetov, which provides comprehensive guidance on building games and applications with JavaFX and FXGL.

## License

This is a learning project demonstrating FXGL game development capabilities.

## Author

David Vazquez
