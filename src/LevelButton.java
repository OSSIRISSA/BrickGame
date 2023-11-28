import acm.program.GraphicsProgram;

import java.awt.*;

public class LevelButton extends Button{

    public LevelButton(GraphicsProgram program, double centerX, double centerY, double width, double height, Color buttonColor, String text, Color textColor, Font inFont, boolean isEnabled, String lockPath) {
        super(program, centerX, centerY, width, height, buttonColor, text, textColor, inFont, isEnabled, lockPath);
    }

    @Override
    public void show() {
        super.show();
    }

    @Override
    public void hide() {
        super.hide();
    }


}
