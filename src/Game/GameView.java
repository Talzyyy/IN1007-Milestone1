package game;

import city.cs.engine.UserView;

import javax.swing.ImageIcon;
import java.awt.Graphics2D;
import java.awt.Image;

/**
 * View renders the world and overlays HUD text.
 * - paintBackground: draws background image
 * - paintForeground: draws changing stats like score
 */
public class GameView extends UserView {

    private final GameWorld world;
    private final Image background;

    public GameView(GameWorld world, int width, int height) {
        super(world, width, height);
        this.world = world;

        // Load background image from /data folder
        background = new ImageIcon("data/background.png").getImage();
    }

    @Override
    protected void paintBackground(Graphics2D g) {
        // Draw background stretched to window size
        g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
    }

    @Override
    protected void paintForeground(Graphics2D g) {
        // Changing statistic (score) required by milestone 1
        g.drawString("Score: " + world.getScore(), 15, 20);
    }
}
