import acm.graphics.GImage;
import acm.program.GraphicsProgram;

import java.awt.*;

public class LevelButton extends Button{

    public boolean isEnabled=false;
    private GImage lock;

    public LevelButton(GraphicsProgram program, double centerX, double centerY, double width, double height, Color buttonColor, String text, Color textColor, Font inFont, boolean isEnabled) {
        super(program, centerX, centerY, width, height, buttonColor, text, textColor, inFont);
        this.isEnabled=isEnabled;
        if(!this.isEnabled){
            lock = new GImage("assets/lock.png");
            lock.setBounds(centerX - width/2, centerY - height/2, width, height);
        }
    }

    public void setEnabled(boolean isEnabled){
        System.out.println(this.getButtonText().getLabel());
        this.isEnabled=isEnabled;
        if (isEnabled){
            program.remove(lock);
        } else program.add(lock);
    }

    @Override
    public void show() {
        super.show();
        if (!isEnabled){
            program.add(lock);
        }
    }

    @Override
    public void hide() {
        super.hide();
        program.remove(lock);
        System.out.println("hidden");
    }


}
