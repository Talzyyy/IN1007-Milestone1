package game;

import city.cs.engine.BodyImage;
import city.cs.engine.CircleShape;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import city.cs.engine.World;

/**
 * Coin is a StaticBody so it doesn't fall.
 * When player touches it, it gets collected (destroyed).
 */
public class Coin extends StaticBody {

    private static final Shape SHAPE = new CircleShape(0.4f);
    private static final BodyImage IMAGE = new BodyImage("data/coin.png", 0.9f);

    public Coin(World world) {
        super(world, SHAPE);
        addImage(IMAGE);
    }
}
