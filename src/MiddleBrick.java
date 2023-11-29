import acm.graphics.GImage;
import acm.program.GraphicsProgram;
import acm.util.SoundClip;
/**
 * The MiddleBrick class represents a brick with middle hardness in the game.
 * It extends the Brick class and contains functionality related to middle hardness bricks.
 */
public class MiddleBrick extends Brick {
    private final GImage crack;
    /**
     * Constructs a MiddleBrick object.
     *
     * @param program The GraphicsProgram instance to which the brick belongs.
     * @param x       The x-coordinate of the brick's position.
     * @param y       The y-coordinate of the brick's position.
     * @param width   The width of the brick.
     * @param height  The height of the brick.
     */
    public MiddleBrick(GraphicsProgram program, double x, double y, double width, double height) {
        super(program, x, y, width, height, "assets/middleBrick.png");
        this.hardness = Hardness.MIDDLE;
        crack = new GImage("assets/light-crack.png", x, y);
        crack.setSize(width, height);
    }
    /**
     * Simulates breaking the middle hardness brick.
     * Plays a cracking sound and updates the brick's state accordingly.
     */
    public void breakIt() {
        Crack = new SoundClip("assets/Crack.au");
        Crack.setVolume(1);
        Crack.play();
        if (this.hardness != Hardness.WEAK) {

                this.hardness = Hardness.WEAK;
                crack.setImage("assets/hard-crack.png");
                crack.setSize(this.getWidth(), this.getHeight());
                program.add(crack);
                program.add(this);

        } else {
            hide();
            LevelMaster.score.updateScore(this);
            program.remove(crack);
            this.IsBroken = true;
        }
    }
    /**
     * Hides the middle hardness brick.
     * Overrides the hide method of the parent class.
     */
    @Override
    public void hide() {
        super.hide();
    }
    /**
     * Shows the middle hardness brick.
     * Overrides the show method of the parent class.
     */
    @Override
    public void show() {
        super.show();
    }
}