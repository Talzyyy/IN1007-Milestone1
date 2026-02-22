package game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Handles keyboard input. This is based on the demo idea,
 * but modified to use WASD + arrows + space.
 */
public class PlayerController extends KeyAdapter {

    private static final float SPEED = 6f;
    private final game.Player player;

    public PlayerController(game.Player player) {
        this.player = player;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_A || code == KeyEvent.VK_LEFT) {
            player.startWalking(-SPEED);
        } else if (code == KeyEvent.VK_D || code == KeyEvent.VK_RIGHT) {
            player.startWalking(SPEED);
        } else if (code == KeyEvent.VK_W || code == KeyEvent.VK_UP || code == KeyEvent.VK_SPACE) {
            player.doJump();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        // Stop only when releasing left/right keys
        if (code == KeyEvent.VK_A || code == KeyEvent.VK_LEFT
                || code == KeyEvent.VK_D || code == KeyEvent.VK_RIGHT) {
            player.stopWalking();
        }
    }
}
