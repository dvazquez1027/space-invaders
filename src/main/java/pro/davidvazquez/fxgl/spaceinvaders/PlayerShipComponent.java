package pro.davidvazquez.fxgl.spaceinvaders;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.component.Component;
import com.almasb.fxgl.physics.PhysicsComponent;

public class PlayerShipComponent extends Component {
    private static final double SHIP_SPEED = 420;

    protected PhysicsComponent physics;

    public void left() {
        if (entity.getX() >= SHIP_SPEED / 60) {
            physics.setVelocityX(-SHIP_SPEED);
        } else {
            stop();
        }
    }

    public void right() {
        if (entity.getX() < FXGL.getAppWidth() - SHIP_SPEED / 60) {
            physics.setVelocityX(SHIP_SPEED);
        } else {
            stop();
        }
    }

    public void shoot() {

    }
    
    public void stop() {
        physics.setLinearVelocity(0, 0);
    }
}
