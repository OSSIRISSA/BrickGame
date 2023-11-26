import acm.graphics.GImage;
import acm.graphics.GLabel;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;

import java.awt.*;

public class Button extends GRect {

    private final GRect buttonBG;
    private final GLabel buttonText;
    private GImage lock;
    public boolean isEnabled;
    public final GraphicsProgram program;
    public boolean isPressed;

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
        buttonText.setLocation(centerX - buttonText.getWidth() / 2, centerY + buttonText.getHeight() / 4);

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

    public void show(){
        program.add(buttonBG);
        program.add(buttonText);
        if (!isEnabled) {
            program.add(lock);
        }
        program.add(this);
    }

    public void hide(){
        program.remove(buttonBG);
        program.remove(buttonText);
        if (!isEnabled) {
            program.remove(lock);
        }
        program.remove(this);
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

    public GLabel getButtonText() {
        return buttonText;
    }
}
