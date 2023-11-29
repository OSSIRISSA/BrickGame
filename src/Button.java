import acm.graphics.GImage;
import acm.graphics.GLabel;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;

import java.awt.*;
/**
 * Represents a button object in the program.
 * Extends GRect.
 */
public class Button extends GRect {
    private final GRect buttonBG;
    private final GLabel buttonText;
    private GImage lock;
    public boolean isEnabled;
    public final GraphicsProgram program;
    public boolean isPressed;
    /**
     * Constructs a button object.
     *
     * @param program      The graphics program that called this method.
     * @param centerX      The x-coordinate of the center of the button.
     * @param centerY      The y-coordinate of the center of the button.
     * @param width        The width of the button.
     * @param height       The height of the button.
     * @param buttonColor  The color of the button.
     * @param text         The text displayed on the button.
     * @param textColor    The color of the text on the button.
     * @param inFont       The font of the text on the button.
     * @param isEnabled    Determines if the button is enabled.
     * @param lockPath     The path to the image representing the locked state of the button.
     */
    public Button(GraphicsProgram program, double centerX, double centerY, double width, double height, Color buttonColor, String text, Color textColor, Font inFont, boolean isEnabled, String lockPath) {

        /*
          Creates button background
         */
        super(centerX - width/2, centerY - height/2, width, height);

        this.program = program;

        buttonBG = new GRect(centerX - width/2, centerY - height/2, width, height);
        buttonBG.setFilled(true);
        buttonBG.setColor(buttonColor);


        /*
          Creates button text and normalizes it
         */
        buttonText = new GLabel(text, 0, 0);
        float size=2f;
        while (buttonText.getWidth()<this.getWidth()*0.9 && buttonText.getHeight()<this.getHeight()*0.9) {
            size += 1f;
            buttonText.setFont(inFont.deriveFont(size));
        }
        buttonText.setColor(textColor);
        buttonText.setLocation(centerX - buttonText.getWidth() *0.5, centerY + buttonText.getHeight() / 4);

        /*
          Creates transparent GRect to collide with mouse events
         */
        this.isEnabled = isEnabled;
        if(!isEnabled && !lockPath.isEmpty()){
            lock = new GImage(lockPath);
            lock.setBounds(centerX - width/2, centerY - height/2, width, height);
        }


        this.setBounds(centerX - width/2, centerY - height/2, width, height);
    }
    /**
     * Displays the button and its components on the screen.
     */
    public void show(){
        program.add(buttonBG);
        program.add(buttonText);
        if (!isEnabled) {
            program.add(lock);
        }
        program.add(this);
    }
    /**
     * Hides the button and its components from the screen.
     */
    public void hide(){
        program.remove(buttonBG);
        program.remove(buttonText);
        if (!isEnabled) {
            program.remove(lock);
        }
        program.remove(this);
    }
    /**
     * Sets the color of the button when it is pressed.
     */
    public void pressed(){
        buttonBG.setColor(Color.darkGray);
    }
    /**
     * Sets the color of the button when it is released after being pressed.
     */
    public void released(){
        buttonBG.setColor(Color.lightGray);
    }
    /**
     * Sets the color of the button when the mouse hovers over it.
     */
    public void hovered(){
        buttonBG.setColor(Color.GRAY);
    }
    /**
     * Retrieves the label associated with the button text.
     *
     * @return The label representing the button text.
     */
    public GLabel getButtonText() {
        return buttonText;
    }
}