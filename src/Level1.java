import acm.program.GraphicsProgram;

public class Level1 extends LevelMaster{

    private WeakBrick brick;
    public Level1(GraphicsProgram program) {
        super(program);
        initialize();
    }


    @Override
    public void addToScreen() {
        super.addToScreen();
    }

    @Override
    public void initialize() {
        super.initialize();
    }

    @Override
    public void addBricks() {
        super.addBricks();
        this.BRICK_NUMBER_X = 1;
        this.BRICK_NUMBER_Y = 1;
        LevelMaster.bricksLeft = BRICK_NUMBER_X*BRICK_NUMBER_Y;
        this.BRICK_WIDTH = (double) sizeX /BRICK_NUMBER_X;
        this.BRICK_HEIGHT = BRICK_WIDTH/2.0;
        for (int i=1; i<= BRICK_NUMBER_Y; i++){
            for (int j=1; j<=BRICK_NUMBER_X; j++){
                brick= new WeakBrick(program, (j-1)*BRICK_WIDTH, (i-1)*BRICK_HEIGHT+50, BRICK_WIDTH, BRICK_HEIGHT);
                brick.show();
                //System.out.println("added");
            }
        }
    }
}
