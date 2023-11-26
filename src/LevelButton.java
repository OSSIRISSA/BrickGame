import acm.graphics.GImage;
import acm.program.GraphicsProgram;

import java.awt.*;

public class LevelButton extends Button{

    private GImage lock;

    public LevelButton(GraphicsProgram program, double centerX, double centerY, double width, double height, Color buttonColor, String text, Color textColor, Font inFont, boolean isEnabled, String lockPath) {
        super(program, centerX, centerY, width, height, buttonColor, text, textColor, inFont, isEnabled, lockPath);
    }

    /*public void setEnabled(boolean isEnabled){
        System.out.println(this.getButtonText().getLabel());
        this.isEnabled=isEnabled;
        if (isEnabled){
            program.remove(lock);
        } else program.add(lock);
    }*/

    @Override
    public void show() {
        super.show();
    }

    @Override
    public void hide() {
        super.hide();
    }


}
