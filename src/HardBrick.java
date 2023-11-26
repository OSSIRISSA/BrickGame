import acm.graphics.GImage;
import acm.program.GraphicsProgram;

import java.awt.*;

public class HardBrick extends Brick{
    private GImage crack;
    public HardBrick(GraphicsProgram program, double x, double y, double width, double height, Color color) {
        super(program, x, y, width, height, color);
        this.hardness=Hardness.HARD;
    }
    public void breakIt() {

        Crack.setVolume(1);
        Crack.play();
        if (this.hardness != Hardness.WEAK) {
            if (this.hardness != Hardness.MIDDLE) {
                this.hardness = Hardness.MIDDLE;
                crack = new GImage("assets/lightcrack.png", this.getX(), this.getY());
                crack.setSize(this.getWidth(), this.getHeight());
                program.add(crack);
            } else {
                this.hardness = Hardness.WEAK;
                crack.setImage("assets/hardcrack.png");
                crack.setSize(this.getWidth(), this.getHeight());
            }
        } else {
            program.remove(this);
            program.remove(crack);
            this.IsBroken = true;
        }
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
