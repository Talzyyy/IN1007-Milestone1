package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

/**
 * Collision listener that:
 * - Detects Player touching Coin
 * - Increases score in the world
 * - Removes the coin
 */
public class CoinPickup implements CollisionListener {

    private final GameWorld world;

    public CoinPickup(GameWorld world) {
        this.world = world;
    }

    @Override
    public void collide(CollisionEvent e) {
        // reporting body = the body that owns this listener (Coin)
        // other body = the body it collided with (Player, platform, etc.)

        if (e.getOtherBody() instanceof game.Player) {
            // Update game state (score changes)
            world.addScore(1);

            // Remove the coin so it can't be collected twice
            e.getReportingBody().destroy();
        }
    }
}
