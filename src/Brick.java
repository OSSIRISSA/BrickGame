import acm.graphics.GImage;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;
import acm.util.SoundClip;

import java.awt.*;

public class Brick extends GRect {
public boolean IsBroken;
    public SoundClip Crack = new SoundClip("assets/Crack.au");
    public GraphicsProgram program;
    public GImage brickImage;
    public Hardness hardness;
    public Brick(GraphicsProgram program,  double x, double y, double width, double height, String brickPath) {
        super(x, y, width, height);
        IsBroken=false;
        this.setColor(Color.BLACK);
        this.setFilled(false);
        this.program = program;
        brickImage = new GImage(brickPath);
        brickImage.setBounds(x, y, width, height);
    }
    public void breakIt(){
        IsBroken=true;
        Crack.setVolume(1);
        Crack.play();
        hide();
    }


    public void show(){
        program.add(brickImage);
        program.add(this);
    }

    public void hide(){
        program.remove(brickImage);
        program.remove(this);
    }


}