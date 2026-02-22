package game;

import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import city.cs.engine.World;
import org.jbox2d.common.Vec2;

/**
 * GameWorld is responsible for:
 * - Creating static environment (ground/platforms)
 * - Spawning the player and objects (coins)
 */
public class GameWorld extends World {

    // Encapsulation: keep player private and expose via getter
    private final game.Player player;

    // Encapsulation: score stored here (could also live in controller later)
    private int score = 0;

    public GameWorld() {
        super();

        // ----- Ground (StaticBody) -----
        Shape groundShape = new BoxShape(20f, 0.5f);
        StaticBody ground = new StaticBody(this, groundShape);
        ground.setPosition(new Vec2(0f, -11f));

        // ----- Platform (StaticBody) -----
        Shape platformShape = new BoxShape(6f, 0.4f);
        StaticBody platform = new StaticBody(this, platformShape);
        platform.setPosition(new Vec2(-6f, -4f));

        // ----- Player (Walker via inheritance) -----
        player = new game.Player(this);
        player.setPosition(new Vec2(-10f, -9f));

        // ----- Coins (collisions change state: score + destroy coin) -----
        spawnCoin(new Vec2(-6f, -2.5f));
        spawnCoin(new Vec2(0f, -9f));
        spawnCoin(new Vec2(8f, -9f));
    }

    /**
     * Spawns a coin and attaches a collision listener so the player
     * can collect it and increase score.
     */
    private void spawnCoin(Vec2 position) {
        game.Coin coin = new game.Coin(this);
        coin.setPosition(position);
        coin.addCollisionListener(new game.CoinPickup(this));
    }

    // Getter for player (needed by controller + view)
    public game.Player getPlayer() {
        return player;
    }

    // Score methods (encapsulation: no direct public field access)
    public int getScore() {
        return score;
    }

    public void addScore(int amount) {
        score += amount;
    }
}
