import acm.graphics.GImage;
import acm.program.GraphicsProgram;

import java.awt.*;

public class MiddleBrick extends Brick {
    private GImage crack;
    public MiddleBrick(GraphicsProgram program, double x, double y, double width, double height, String brickPath) {
        super(program, x, y, width, height, brickPath);
        this.hardness = Hardness.MIDDLE;
        crack = new GImage("assets/lightcrack.png", x, y);
        crack.setSize(width, height);
    }

    public void breakIt() {

        Crack.setVolume(1);
        Crack.play();
        if (this.hardness != Hardness.WEAK) {

                this.hardness = Hardness.WEAK;
                crack.setImage("assets/hardcrack.png");
                crack.setSize(this.getWidth(), this.getHeight());
                program.add(crack);
                program.add(this);

        } else {
            program.remove(this);
            program.remove(crack);
            this.IsBroken = true;
        }
    }
}
