import acm.program.GraphicsProgram;

import java.awt.*;
/**
 * Represents a button specifically designed for level selection.
 * Extends Button class.
 */
public class LevelButton extends Button{
    /**
     * Constructs a LevelButton object.
     *
     * @param program   The graphics program that called this method.
     * @param centerX   The X-coordinate of the center of the button.
     * @param centerY   The Y-coordinate of the center of the button.
     * @param width     The width of the button.
     * @param height    The height of the button.
     * @param buttonColor The color of the button.
     * @param text      The text displayed on the button.
     * @param textColor The color of the text displayed on the button.
     * @param inFont    The font used for the button text.
     * @param isEnabled Determines if the button is enabled or disabled.
     * @param lockPath  The file path for the lock image (if the button is locked).
     */
    public LevelButton(GraphicsProgram program, double centerX, double centerY, double width, double height, Color buttonColor, String text, Color textColor, Font inFont, boolean isEnabled, String lockPath) {
        super(program, centerX, centerY, width, height, buttonColor, text, textColor, inFont, isEnabled, lockPath);
    }
    /**
     * Displays the level button on the screen.
     */
    @Override
    public void show() {
        super.show();
    }
    /**
     * Hides the level button from the screen.
     */
    @Override
    public void hide() {
        super.hide();
    }


}
