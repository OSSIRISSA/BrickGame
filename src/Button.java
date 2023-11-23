import acm.graphics.GLabel;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;

import java.awt.*;

public class Button extends GRect {

    private GRect buttonBG;
    public boolean isPressed;

    public Button(GraphicsProgram program, double centerX, double centerY, double width, double height, Color buttonColor, String text, Color textColor, Font inFont) {

        /*
          Creates button background
         */
        super(centerX - width/2, centerY - height/2, width, height);

        buttonBG = new GRect(centerX - width/2, centerY - height/2, width, height);
        buttonBG.setFilled(true);
        buttonBG.setColor(buttonColor);
        program.add(buttonBG);

        /*
          Creates button text and normalizes it
         */
        GLabel buttonText = new GLabel(text, 0, 0);
        float size=2f;
        while (buttonText.getWidth()<this.getWidth()*0.9 && buttonText.getHeight()<this.getHeight()*0.9) {
            size += 1f;
            buttonText.setFont(inFont.deriveFont(size));
        }
        buttonText.setColor(textColor);
        program.add(buttonText, centerX - buttonText.getWidth() / 2, centerY + buttonText.getHeight() / 4);


        /*
          Creates transparent GRect to collide with mouse events
         */
        this.setBounds(centerX - width/2, centerY - height/2, width, height);
        program.add(this);
    }

    public void pressed(){
        buttonBG.setColor(Color.darkGray);
    }

    public void released(){
        buttonBG.setColor(Color.lightGray);
    }

    public void hovered(){
        buttonBG.setColor(Color.GRAY);
    }
}
