import acm.graphics.GImage;
import acm.program.GraphicsProgram;

import java.awt.*;

public class WeakBrick extends Brick{
private GImage crack;
    public WeakBrick(GraphicsProgram program, double x, double y, double width, double height, Color color) {
        super(program, x, y, width, height, color);
        this.hardness = Hardness.WEAK;
        crack = new GImage("assets/hardcrack.png", x, y);
        crack.setSize(width, height);
        program.add(crack);
    }
    public void breakIt(){
        IsBroken=true;
        Crack.setVolume(1);
        Crack.play();
        program.remove(this);
        program.remove(crack);
    }

}
