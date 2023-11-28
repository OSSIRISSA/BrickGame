import acm.graphics.GLabel;
import acm.program.GraphicsProgram;
import acm.util.SoundClip;

import java.awt.*;

public class Score extends GLabel {

    public int currentScore = 0;

    public GraphicsProgram program;

    public SoundClip victory = new SoundClip("assets/victory.au");

    public Score(GraphicsProgram program) {
        super("0");
        this.setColor(Color.WHITE);
        this.setFont(Main.cyberFont.deriveFont(60f));
        this.program = program;
        this.setLocation(Main.MAX_X-this.getWidth()-10,this.getHeight()-5);
    }

    public void add() { program.add(this); }

    public void updateScore(Brick brick){
        if (brick.getClass().equals(HardBrick.class)&& !brick.IsBroken){
            currentScore+=300;
            LevelMaster.bricksLeft--;
        }
        if (brick.getClass().equals(MiddleBrick.class)&& !brick.IsBroken){
            currentScore+=200;
            LevelMaster.bricksLeft--;
        }
        if (brick.getClass().equals(WeakBrick.class)&& !brick.IsBroken){
            currentScore+=100;
            LevelMaster.bricksLeft--;
        }
        this.setLabel(""+currentScore);
        this.setLocation(Main.MAX_X-this.getWidth()-10,this.getHeight()-5);
        if(LevelMaster.bricksLeft==0){
            victory.setVolume(1);
            victory.play();
        }
    }
}
