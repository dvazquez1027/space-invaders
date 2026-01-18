package pro.davidvazquez.fxgl.spaceinvaders;

import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.component.Component;
import com.almasb.fxgl.physics.PhysicsComponent;

public class EnemyDividerComponent extends Component {
    private static final double DIVIDER_SPEED = 40;

    protected FleetDirection direction = FleetDirection.RIGHT;
    protected PhysicsComponent physics;

    @Override
    public void onUpdate(double tpf) {
        if (direction == FleetDirection.RIGHT) {
            physics.setVelocityX(DIVIDER_SPEED);
        } else {
            physics.setVelocityX(-DIVIDER_SPEED);
        }
    }

    public FleetDirection getDirection() {
        return direction;
    }

    public void setDirection(FleetDirection direction) {
        this.direction = direction;
    }
}
