import acm.graphics.GImage;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;
import acm.util.SoundClip;

import java.awt.*;

/**
 * Represents a brick object in the game.
 * Extends GRect.
 */
public class Brick extends GRect {
    public boolean IsBroken;
    public SoundClip Crack = new SoundClip("assets/Crack.au");
    public GraphicsProgram program;
    public GImage brickImage;
    public Hardness hardness;
    public final Color transparent = new Color(0, 0, 0, 0);

    /**
     * Constructs a brick object.
     *
     * @param program    The graphics program that called this method.
     * @param x          The x-coordinate of the brick.
     * @param y          The y-coordinate of the brick.
     * @param width      The width of the brick.
     * @param height     The height of the brick.
     * @param brickPath  The path to the image representing the brick.
     */
    public Brick(GraphicsProgram program, double x, double y, double width, double height, String brickPath) {
        super(x, y, width, height);
        IsBroken = false;
        this.setColor(transparent);
        this.setFilled(false);
        this.program = program;
        brickImage = new GImage(brickPath);
        brickImage.setBounds(x, y, width, height);
    }

    /**
     * Plays the sound clip representing the brick being broken.
     */
    public void breakIt() {
        Crack = new SoundClip("assets/Crack.au");
        Crack.setVolume(1);
        Crack.play();
    }

    /**
     * Displays the brick and its associated image on the screen.
     */
    public void show() {
        program.add(brickImage);
        program.add(this);
    }

    /**
     * Hides the brick and its associated image from the screen.
     */
    public void hide() {
        program.remove(brickImage);
        program.remove(this);
    }
}
