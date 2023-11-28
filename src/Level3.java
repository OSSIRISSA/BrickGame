import acm.program.GraphicsProgram;

public class Level3 extends LevelMaster {

    public Level3(GraphicsProgram program) {
        super(program);
        initialize();
    }

    @Override
    public void addToScreen() {
        super.addToScreen();
    }

    @Override
    public void initialize() {
        super.initialize("assets/bg3.png");
    }

    @Override
    public void addBricks() {
        super.addBricks();
        this.BRICK_NUMBER_X = 9;
        this.BRICK_NUMBER_Y = 9;
        LevelMaster.bricksLeft = BRICK_NUMBER_X * BRICK_NUMBER_Y;
        this.BRICK_WIDTH = (double) sizeX / BRICK_NUMBER_X;
        this.BRICK_HEIGHT = BRICK_WIDTH / 2.0;
        for (int i = 1; i <= BRICK_NUMBER_Y; i++) {
            for (int j = 1; j <= BRICK_NUMBER_X; j++) {
                if (i == 1 || i == 9) {
                    brick = new WeakBrick(program, (j - 1) * BRICK_WIDTH, (i - 1) * BRICK_HEIGHT + 50, BRICK_WIDTH, BRICK_HEIGHT);
                    brick.show();
                }
                if (i == 2) {
                    if (j == 3 || j == 7) {
                        brick = new HardBrick(program, (j - 1) * BRICK_WIDTH, (i - 1) * BRICK_HEIGHT + 50, BRICK_WIDTH, BRICK_HEIGHT);
                        brick.show();
                    } else {
                        brick = new WeakBrick(program, (j - 1) * BRICK_WIDTH, (i - 1) * BRICK_HEIGHT + 50, BRICK_WIDTH, BRICK_HEIGHT);
                        brick.show();
                    }
                }
                if (i == 3) {
                    if ((j >= 2 && j <= 4) || (j >= 6 && j <= 8)) {
                        brick = new HardBrick(program, (j - 1) * BRICK_WIDTH, (i - 1) * BRICK_HEIGHT + 50, BRICK_WIDTH, BRICK_HEIGHT);
                        brick.show();
                    } else {
                        brick = new WeakBrick(program, (j - 1) * BRICK_WIDTH, (i - 1) * BRICK_HEIGHT + 50, BRICK_WIDTH, BRICK_HEIGHT);
                        brick.show();
                    }
                }
                if (i == 4 || i == 5) {
                    if (j >= 2 && j <= 8) {
                        brick = new HardBrick(program, (j - 1) * BRICK_WIDTH, (i - 1) * BRICK_HEIGHT + 50, BRICK_WIDTH, BRICK_HEIGHT);
                        brick.show();
                    } else {
                        brick = new WeakBrick(program, (j - 1) * BRICK_WIDTH, (i - 1) * BRICK_HEIGHT + 50, BRICK_WIDTH, BRICK_HEIGHT);
                        brick.show();
                    }
                }
                if (i == 6) {
                    if (j >= 3 && j <= 7) {
                        brick = new HardBrick(program, (j - 1) * BRICK_WIDTH, (i - 1) * BRICK_HEIGHT + 50, BRICK_WIDTH, BRICK_HEIGHT);
                        brick.show();
                    } else {
                        brick = new WeakBrick(program, (j - 1) * BRICK_WIDTH, (i - 1) * BRICK_HEIGHT + 50, BRICK_WIDTH, BRICK_HEIGHT);
                        brick.show();
                    }
                }
                if (i == 7) {
                    if (j >= 4 && j <= 6) {
                        brick = new HardBrick(program, (j - 1) * BRICK_WIDTH, (i - 1) * BRICK_HEIGHT + 50, BRICK_WIDTH, BRICK_HEIGHT);
                        brick.show();
                    } else {
                        brick = new WeakBrick(program, (j - 1) * BRICK_WIDTH, (i - 1) * BRICK_HEIGHT + 50, BRICK_WIDTH, BRICK_HEIGHT);
                        brick.show();
                    }
                }
                if (i == 8) {
                    if (j == 5) {
                        brick = new HardBrick(program, (j - 1) * BRICK_WIDTH, (i - 1) * BRICK_HEIGHT + 50, BRICK_WIDTH, BRICK_HEIGHT);
                        brick.show();
                    } else {
                        brick = new WeakBrick(program, (j - 1) * BRICK_WIDTH, (i - 1) * BRICK_HEIGHT + 50, BRICK_WIDTH, BRICK_HEIGHT);
                        brick.show();
                    }
                }
            }
        }
    }
}
