import acm.program.GraphicsProgram;
/**
 * The WeakBrick class represents a type of brick with weak hardness that can be broken during gameplay.
 * It extends the Brick class.
 */
public class WeakBrick extends Brick{
    /**
     * Creates a WeakBrick object with the specified parameters.
     *
     * @param program The GraphicsProgram instance associated with this brick.
     * @param x       The x-coordinate of the brick's position.
     * @param y       The y-coordinate of the brick's position.
     * @param width   The width of the brick.
     * @param height  The height of the brick.
     */
    public WeakBrick(GraphicsProgram program, double x, double y, double width, double height) {
        super(program, x, y, width, height, "assets/weakBrick.png");
        this.hardness = Hardness.WEAK;
    }
    /**
     * Breaks the weak brick, updates the score, and hides the brick.
     * Overrides the superclass method.
     */
    public void breakIt(){
        LevelMaster.score.updateScore(this);
        super.breakIt();
        IsBroken=true;
        hide();
    }

}