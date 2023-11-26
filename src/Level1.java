import acm.program.GraphicsProgram;

import java.awt.*;

public class Level1 extends LevelMaster{

    private HardBrick brick;
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
        this.BRICK_NUMBER_X = 14;
        this.BRICK_NUMBER_Y = 4;
        this.BRICK_WIDTH = sizeX/14.0;
        this.BRICK_HEIGHT = 40;
        for (int i=1; i<= BRICK_NUMBER_Y; i++){
            for (int j=1; j<=BRICK_NUMBER_X; j++){
                brick= new HardBrick(program, (j-1)*BRICK_WIDTH, (i-1)*BRICK_HEIGHT+50, BRICK_WIDTH, BRICK_HEIGHT, Color.RED);
                brick.show();
                //System.out.println("added");
            }
        }
    }
}
