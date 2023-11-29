import acm.graphics.GImage;
import acm.program.GraphicsProgram;
import acm.util.SoundClip;
/**
 * Represents a hard brick object in the program.
 * Extends Brick.
 */
public class HardBrick extends Brick{
    private GImage crack;
    /**
     * Constructs a hard brick object.
     *
     * @param program The graphics program that called this method.
     * @param x       The x-coordinate of the hard brick.
     * @param y       The y-coordinate of the hard brick.
     * @param width   The width of the hard brick.
     * @param height  The height of the hard brick.
     */
    public HardBrick(GraphicsProgram program, double x, double y, double width, double height) {
        super(program, x, y, width, height, "assets/hardBrick.png");
        this.hardness=Hardness.HARD;
    }
    /**
     * Breaks the hard brick.
     */
    public void breakIt() {
        Crack = new SoundClip("assets/Crack.au");
        Crack.setVolume(1);
        Crack.play();
        if (this.hardness != Hardness.WEAK) {
            if (this.hardness != Hardness.MIDDLE) {
                this.hardness = Hardness.MIDDLE;
                crack = new GImage("assets/light-crack.png", this.getX(), this.getY());
                crack.setSize(this.getWidth(), this.getHeight());
                program.add(crack);
                program.add(this);
            } else {
                this.hardness = Hardness.WEAK;
                crack.setImage("assets/hard-crack.png");
                crack.setSize(this.getWidth(), this.getHeight());
            }
        } else {
            hide();
            LevelMaster.score.updateScore(this);
            program.remove(crack);
            this.IsBroken = true;
        }
    }
    /**
     * Displays the hard brick on the screen.
     */
    @Override
    public void show() {
        super.show();
    }
    /**
     * Hides the hard brick from the screen.
     */
    @Override
    public void hide() {
        super.hide();
    }
}
