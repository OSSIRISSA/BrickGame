import acm.program.GraphicsProgram;
/**
 * Represents the second level of the game.
 * Extends LevelMaster.
 */
public class Level2 extends LevelMaster{
    /**
     * Constructs the Level2 object.
     *
     * @param program The graphics program that called this method.
     */
    public Level2(GraphicsProgram program) {
        super(program);
        initialize();
    }
    /**
     * Adds this level's components to the screen.
     */
    @Override
    public void addToScreen() {
        super.addToScreen();
    }
    /**
     * Initializes the second level.
     */
    @Override
    public void initialize() {
        super.initialize("assets/bg2.png");
    }
    /**
     * Adds bricks for the second level.
     */
    @Override
    public void addBricks() {
        super.addBricks();
        this.BRICK_NUMBER_X = 7;
        this.BRICK_NUMBER_Y = 6;
        LevelMaster.bricksLeft = BRICK_NUMBER_X*BRICK_NUMBER_Y;
        this.BRICK_WIDTH = (double) sizeX /BRICK_NUMBER_X;
        this.BRICK_HEIGHT = BRICK_WIDTH/2.0;
        for (int i=1; i<= BRICK_NUMBER_Y; i++){
            for (int j=1; j<=BRICK_NUMBER_X; j++){
                if(i<=2){
                    brick= new HardBrick(program, (j-1)*BRICK_WIDTH, (i-1)*BRICK_HEIGHT+50, BRICK_WIDTH, BRICK_HEIGHT);
                    brick.show();
                }
                if(i<=4&&i>2){
                    brick= new MiddleBrick(program, (j-1)*BRICK_WIDTH, (i-1)*BRICK_HEIGHT+50, BRICK_WIDTH, BRICK_HEIGHT);
                    brick.show();
                }
                if(i>4){
                    brick= new WeakBrick(program, (j-1)*BRICK_WIDTH, (i-1)*BRICK_HEIGHT+50, BRICK_WIDTH, BRICK_HEIGHT);
                    brick.show();
                }
            }
        }
    }
}