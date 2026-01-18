package pro.davidvazquez.fxgl.spaceinvaders;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityFactory;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.entity.Spawns;
import com.almasb.fxgl.entity.components.CollidableComponent;
import com.almasb.fxgl.physics.PhysicsComponent;
import com.almasb.fxgl.physics.box2d.dynamics.BodyType;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class SpaceInvadersFactory implements EntityFactory {
    @Spawns("playerShip")
    public Entity newBat(SpawnData data) {
        PhysicsComponent physics = new PhysicsComponent();
        physics.setBodyType(BodyType.KINEMATIC);
        return FXGL.entityBuilder(data)
                .type(EntityType.PLAYER_SHIP)
                .viewWithBBox(new Rectangle(25, 25, Color.LIGHTBLUE))
                .with(new CollidableComponent(true))
                .with(physics)
                .with(new PlayerShipComponent())
                .build();
    }

    @Spawns("enemyDivider")
    public Entity newEnemyDivider(SpawnData data) {
        PhysicsComponent physics = new PhysicsComponent();
        physics.setBodyType(BodyType.KINEMATIC);
        return FXGL.entityBuilder(data)
                .type(EntityType.ENEMY_DIVIDER)
                .viewWithBBox(new Rectangle(5, 300, Color.WHITE))
                .with(new CollidableComponent(true))
                .with(physics)
                .with(new EnemyDividerComponent())
                .build();
    }

    @Spawns("walls")
    public Entity newWalls(SpawnData data) {
        PhysicsComponent physics = new PhysicsComponent();
        physics.setBodyType(BodyType.STATIC);

        return FXGL.entityBuilder(data)
                .type(EntityType.WALL)
                .collidable()
                .buildScreenBounds(150);
    }
}
