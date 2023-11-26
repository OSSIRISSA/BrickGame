import acm.graphics.GImage;
import acm.program.GraphicsProgram;

import java.awt.*;

public class WeakBrick extends Brick{
    public WeakBrick(GraphicsProgram program, double x, double y, double width, double height, String brickPath) {
        super(program, x, y, width, height, brickPath);
        this.hardness = Hardness.WEAK;
    }
    public void breakIt(){
        super.breakIt();
    }

}
