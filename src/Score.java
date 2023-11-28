import acm.graphics.GLabel;
import acm.program.GraphicsProgram;
import acm.util.SoundClip;

import java.awt.*;

public class Score extends GLabel {
    public static int currentScore = 0;

    public GraphicsProgram program;
    public GLabel maxScoreLabel;
    public static Victory victoryWindow;
    public SoundClip victory = new SoundClip("assets/victory.au");

    public Score(GraphicsProgram program) {
        super("0");
        this.setLabel(String.valueOf(currentScore));
        this.setColor(Color.WHITE);
        this.setFont(Main.cyberFont.deriveFont(48f));
        this.program = program;
        this.setLocation(Main.MAX_X - this.getWidth() - 10, this.getHeight() - 5);

        maxScoreLabel = new GLabel("R: "+Main.maxScore);
        maxScoreLabel.setColor(Color.white);
        maxScoreLabel.setFont(Main.cyberFont.deriveFont(48f));
        maxScoreLabel.setLocation(Main.MAX_X/2.0 - maxScoreLabel.getWidth()*0.7, maxScoreLabel.getHeight() - 5);
        updateMaxScore();
    }

    private void updateMaxScore() {
        if (Main.maxScore<currentScore){
            Main.maxScore=currentScore;
            maxScoreLabel.setLabel("R: "+currentScore);
            maxScoreLabel.setLocation(Main.MAX_X/2.0 - maxScoreLabel.getWidth()*0.7, maxScoreLabel.getHeight() - 5);
        }
    }

    public void add() {
        program.add(this);
        program.add(maxScoreLabel);
    }

    public void updateScore(Brick brick) {
        if (brick.getClass().equals(HardBrick.class) && !brick.IsBroken) {
            currentScore += 300;
            LevelMaster.bricksLeft--;
            updateMaxScore();
        }
        if (brick.getClass().equals(MiddleBrick.class) && !brick.IsBroken) {
            currentScore += 200;
            LevelMaster.bricksLeft--;
            updateMaxScore();
        }
        if (brick.getClass().equals(WeakBrick.class) && !brick.IsBroken) {
            currentScore += 100;
            LevelMaster.bricksLeft--;
            updateMaxScore();
        }
        this.setLabel("" + currentScore);
        this.setLocation(Main.MAX_X - this.getWidth() - 10, this.getHeight() - 5);
        if (LevelMaster.bricksLeft == 0) {
            LevelMaster.ball.turnTimerOff = true;

            victoryWindow = new Victory(program);
            Main.victoryWindow = victoryWindow;

            victory.setVolume(1);
            victory.play();
            victoryWindow.addToScreen();
        }
    }
}