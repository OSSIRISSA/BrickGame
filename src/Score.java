import acm.graphics.GLabel;
import acm.program.GraphicsProgram;

import java.awt.*;

public class Score extends GLabel {

    public int currentScore = 0;

    public GraphicsProgram program;

    public Score(GraphicsProgram program) {
        super("0");
        this.setColor(Color.WHITE);
        this.setFont(Main.cyberFont.deriveFont(60f));
        this.program = program;
        this.setLocation(Main.MAX_X-this.getWidth()-10,this.getHeight()-5);
    }

    public void add() { program.add(this); }

    public void updateScore(Brick brick){
        if (brick.getClass().equals(HardBrick.class)){
            currentScore+=300;
        }
        if (brick.getClass().equals(MiddleBrick.class)){
            currentScore+=200;
        }
        if (brick.getClass().equals(WeakBrick.class)){
            currentScore+=100;
        }
        this.setLabel(""+currentScore);
        this.setLocation(Main.MAX_X-this.getWidth()-10,this.getHeight()-5);
    }
}
