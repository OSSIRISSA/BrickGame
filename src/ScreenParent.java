import acm.program.GraphicsProgram;

import java.awt.*;

public class ScreenParent{

    public Font cyberFont = Main.cyberFont;
    public static int sizeX = Main.MAX_X;
    public static int sizeY = Main.MAX_Y;

    public GraphicsProgram program;
    public ScreenParent(GraphicsProgram program) {
        this.program=program;
    }

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
