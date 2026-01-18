package pro.davidvazquez.fxgl.spaceinvaders;

import static com.almasb.fxgl.dsl.FXGL.getAppHeight;
import static com.almasb.fxgl.dsl.FXGL.getAppWidth;
import static com.almasb.fxgl.dsl.FXGL.getDialogService;
import static com.almasb.fxgl.dsl.FXGL.getGameController;
import static com.almasb.fxgl.dsl.FXGL.getGameScene;
import static com.almasb.fxgl.dsl.FXGL.getGameWorld;
import static com.almasb.fxgl.dsl.FXGL.getInput;
import static com.almasb.fxgl.dsl.FXGL.getPhysicsWorld;
import static com.almasb.fxgl.dsl.FXGL.getUIFactoryService;
import static com.almasb.fxgl.dsl.FXGL.getWorldProperties;
import static com.almasb.fxgl.dsl.FXGL.inc;
import static com.almasb.fxgl.dsl.FXGL.spawn;

import java.util.Map;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.input.UserAction;
import com.almasb.fxgl.physics.CollisionHandler;
import com.almasb.fxgl.physics.HitBox;

import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class SpaceInvadersApp extends GameApplication {
    private PlayerShipComponent playerShip;

    @Override
    protected void initSettings(com.almasb.fxgl.app.GameSettings settings) {
        settings.setTitle("Space Invaders FXGL");
        settings.setWidth(800);
        settings.setHeight(600);
    }

    @Override
    protected void initInput() {
        getInput().addAction(new UserAction("Up") {
            @Override
            protected void onAction() {
                playerShip.left();
            }

            @Override
            protected void onActionEnd() {
                playerShip.stop();
            }
        }, KeyCode.A);

        getInput().addAction(new UserAction("Down") {
            @Override
            protected void onAction() {
                playerShip.right();
            }

            @Override
            protected void onActionEnd() {
                playerShip.stop();
            }
        }, KeyCode.D);

        getInput().addAction(new UserAction("Shoot") {
            @Override
            protected void onAction() {
                playerShip.shoot();
            }
        }, KeyCode.SPACE);
    }

    @Override
    protected void initGameVars(Map<String, Object> vars) {
        vars.put("player1Score", 0);
        vars.put("player2Score", 0);
    }
    
    @Override
    protected void initGame() {
        getWorldProperties().<Integer>addListener("player1Score", (oldScore, newScore) -> {
            if (newScore == 11) {
                showGameOver("Player 1");
            }
        });

        getWorldProperties().<Integer>addListener("player2Score", (oldScore, newScore) -> {
            if (newScore == 11) {
                showGameOver("Player 2");
            }
        });

        getGameWorld().addEntityFactory(new SpaceInvadersFactory());

        getGameScene().setBackgroundColor(Color.rgb(5, 5, 5));

        initGameObjects();
    }

    private void showGameOver(String winner) {
        getDialogService().showMessageBox("Game Over! " + winner + " won!", getGameController()::exit);
    }

    private void initGameObjects() {
        playerShip = spawn("playerShip", getAppWidth() / 2 - 12.5, getAppHeight() - 50).getComponent(PlayerShipComponent.class);

        for (int i = 0; i < 12;  ++i) {
            spawn("enemyDivider", new SpawnData(50 + i * 40, 125));
        }

    }

    @Override
    protected void initPhysics() {
        getPhysicsWorld().setGravity(0, 0);
        getPhysicsWorld().addCollisionHandler(new CollisionHandler(EntityType.ENEMY_DIVIDER, EntityType.WALL) {
            @Override
            protected void onHitBoxTrigger(Entity a, Entity b, HitBox boxA, HitBox boxB) {
            }
        });
    }

    @Override
    protected void initUI() {
        // Player 1 Score
        var textPlayer1 = getUIFactoryService().newText("", Color.WHITE, 24);
        textPlayer1.setTranslateX(50);
        textPlayer1.setTranslateY(50);
        textPlayer1.textProperty().bind(getWorldProperties().intProperty("player1Score").asString("Player 1: %d"));
        getGameScene().addUINode(textPlayer1);

        // Player 2 Score
        var textPlayer2 = getUIFactoryService().newText("", Color.WHITE, 24);
        textPlayer2.setTranslateX(getAppWidth() - 150);
        textPlayer2.setTranslateY(50);
        textPlayer2.textProperty().bind(getWorldProperties().intProperty("player2Score").asString("Player 2: %d"));
        getGameScene().addUINode(textPlayer2);
    }

    public static void main(String[] args) {
        launch(args);
    }
}