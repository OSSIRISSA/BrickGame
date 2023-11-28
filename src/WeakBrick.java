import acm.graphics.GImage;
import acm.program.GraphicsProgram;
import acm.util.SoundClip;

import java.awt.*;

public class WeakBrick extends Brick{
    public WeakBrick(GraphicsProgram program, double x, double y, double width, double height) {
        super(program, x, y, width, height, "assets/weakBrick.png");
        this.hardness = Hardness.WEAK;
    }
    public void breakIt(){
        LevelMaster.score.updateScore(this);
        super.breakIt();
        IsBroken=true;
        hide();
    }

}
