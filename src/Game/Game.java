package game;

import javax.swing.JFrame;

/**
 * Entry point: creates the window, world, and view.
 * Keeps main minimal and readable for the viva.
 */
public class Game {

    public static void main(String[] args) {
        // 1) Create the physics world
        GameWorld world = new GameWorld();

        // 2) Create a view to render the world
        GameView view = new GameView(world, 800, 600);

        // 3) Create the window and add the view
        JFrame frame = new JFrame("IN1007 Milestone 1 Game");
        frame.add(view);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);

        // 4) Add keyboard control (modified demo pattern)
        PlayerController controller = new PlayerController(world.getPlayer());
        frame.addKeyListener(controller);
        view.addKeyListener(controller);

        // 5) Start the simulation
        world.start();

        // Helpful: ensure keyboard input goes to the view
        view.requestFocus();
    }
}
