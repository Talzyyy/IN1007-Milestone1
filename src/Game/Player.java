package game;

import city.cs.engine.BodyImage;
import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.Walker;
import city.cs.engine.World;

/**
 * Player is a Walker (dynamic body) so it can move using startWalking().
 * This demonstrates inheritance (Player extends Walker).
 */
public class Player extends Walker {

    private static final Shape SHAPE = new BoxShape(0.6f, 1.2f);

    // Image is optional, but nice. Replace path with your actual file.
    private static final BodyImage IMAGE = new BodyImage("data/player.png", 2.6f);

    public Player(World world) {
        super(world, SHAPE);

        // Attach sprite
        addImage(IMAGE);

        // Optional tuning: helps movement feel less floaty
        setGravityScale(1.6f);
    }

    /**
     * Jump with a fixed strength.
     * Encapsulated: jumping logic lives here, not in controller.
     */
    public void doJump() {
        // Simple approach: always allow jump (easy milestone 1)
        // Improvement later: only jump when on ground.
        jump(10);
    }
}
