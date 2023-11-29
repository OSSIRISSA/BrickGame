import acm.graphics.GLabel;
import acm.program.GraphicsProgram;
import acm.util.SoundClip;

import java.awt.*;
/**
 * The Score class represents the scoring system in the game.
 * It extends GLabel and manages the current score, updating scores, and displaying them.
 */
public class Score extends GLabel {
    /** The current score of the game. */
    public static int currentScore = 0;
    /** The associated program for the score. */

    public GraphicsProgram program;
    /** The label displaying the maximum score reached. */
    public GLabel maxScoreLabel;
    /** The window to display victory. */
    public static Victory victoryWindow;
    /** The sound clip played on victory. */
    public SoundClip victory = new SoundClip("assets/victory.au");
    /**
     * Constructs the Score object.
     *
     * @param program The GraphicsProgram instance associated with the score.
     */

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
    /**
     * Updates the maximum score achieved.
     */
    private void updateMaxScore() {
        if (Main.maxScore<currentScore){
            Main.maxScore=currentScore;
            maxScoreLabel.setLabel("R: "+currentScore);
            maxScoreLabel.setLocation(Main.MAX_X/2.0 - maxScoreLabel.getWidth()*0.7, maxScoreLabel.getHeight() - 5);
        }
    }
    /**
     * Adds the score labels to the screen.
     */
    public void add() {
        program.add(this);
        program.add(maxScoreLabel);
    }
    /**
     * Updates the score based on the brick hit and checks for victory conditions.
     *
     * @param brick The brick that was hit.
     */
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