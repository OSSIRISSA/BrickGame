import acm.graphics.GLabel;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;

import java.awt.*;

public class Button extends GRect {
    public Button(GraphicsProgram program, double centerX, double centerY, double width, double height, Color buttonColor, String text, Color textColor) {

        /*
          Creates button background
         */
        super(centerX - width/2, centerY - height/2, width, height);

        GRect buttonGlass = new GRect(centerX - width/2, centerY - height/2, width, height);
        buttonGlass.setFilled(true);
        buttonGlass.setColor(buttonColor);
        program.add(buttonGlass);

        /*
          Creates button text and normalizes it
         */
        GLabel buttonText = new GLabel(text, 0, 0);
        int size=2;
        while (buttonText.getHeight()/0.8<this.getHeight() && buttonText.getWidth()/0.9<this.getWidth()) {
            size += 1;
            String font = "italic-" + size;
            buttonText.setFont(font);
        }
        buttonText.setColor(textColor);
        program.add(buttonText, centerX - buttonText.getWidth() / 2, centerY + buttonText.getHeight() / 4);


        /*
          Creates transparent GRect to collide with mouse events
         */
        this.setBounds(centerX - width/2, centerY - height/2, width, height);
        program.add(this);
    }
}
