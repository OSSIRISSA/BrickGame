import acm.graphics.GRect;
import acm.program.GraphicsProgram;
import acm.util.SoundClip;

import java.awt.*;

public class Brick extends GRect {
public boolean IsBroken;
    public SoundClip Crack = new SoundClip("assets/Crack.au");
    public GraphicsProgram program;
    public Hardness hardness;
    public Brick(GraphicsProgram program,  double x, double y, double width, double height, Color color) {
        super(x, y, width, height);
        IsBroken=false;
        this.setColor(Color.BLACK);
        this.setFilled(true);
        this.setFillColor(color);
        this.program = program;
        program.add(this);
    }
    public void breakIt(){
        IsBroken=true;
        Crack.setVolume(1);
        Crack.play();
        program.remove(this);
    }


}
