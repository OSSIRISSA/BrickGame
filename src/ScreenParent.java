import acm.program.GraphicsProgram;

import java.awt.*;
/**
 * The ScreenParent class serves as a template for different screens in the game.
 * It manages common properties and methods shared among various screens.
 */
public class ScreenParent{
    /** The cyber font used across screens. */
    public Font cyberFont = Main.cyberFont;
    /** The width of the screen. */
    public static int sizeX = Main.MAX_X;
    /** The height of the screen. */
    public static int sizeY = Main.MAX_Y;
    /** The associated GraphicsProgram instance. */

    public GraphicsProgram program;
    /**
     * Constructs a ScreenParent object.
     *
     * @param program The GraphicsProgram instance associated with this screen.
     */
    public ScreenParent(GraphicsProgram program) {
        this.program=program;
    }
    /** Initializes the screen. */

    public void initialize(){}

    /**
     * Call this method if you want to add everything from this screen to main GraphicsProgram
     */
    public void addToScreen(){}

    /**
     * Call this method if you want to remove everything on specific game screen from GraphicsProgram
     */
    public void removeFromScreen(){}
}