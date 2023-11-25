import acm.graphics.GImage;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;

import java.awt.*;

public class LevelMaster extends ScreenParent {

    public double radius;
    private final RandomGenerator random = RandomGenerator.getInstance();
    public GImage bg;
    public GRect bar;
    public Ball ball;
    public Racket racket;
    public static Brick brick;
    public static Heart life1;
    public static Heart life2;
    public static Heart life3;

    private final static int  BRICK_NUMBER_X= 16;
    private final static int BRICK_NUMBER_Y= 3;
    private final static int BRICK_WIDTH = sizeX /BRICK_NUMBER_X;
    private final static int BRICK_HEIGHT = 40;
    public LevelMaster(GraphicsProgram program) {
        super(program);
        this.radius = Main.BALL_RADIUS;
    }

    public void initialize() {
        bg = new GImage("assets/bg1.jpg");
        bar = new GRect(0,0,sizeX,49);
        bar.setFilled(true);

        racket = new Racket(program, "assets/board.png", sizeX/2.0, sizeY*0.9);
        Main.racket = this.racket;
        ball = new Ball(program, random.nextDouble(1,sizeX-radius*2-1), random.nextDouble(50,sizeY-100),radius, Color.CYAN);
        life1 = new Heart(program,25.0,25.0,50.0,50.0,"assets/heart1.gif");
        life2 = new Heart(program,75.0,25.0,50.0,50.0,"assets/heart3.gif");
        life3 = new Heart(program,125.0,25.0,50.0,50.0,"assets/heart2.gif");
    }

    @Override
    public void addToScreen() {
        program.add(bg);
        program.add(bar);
        racket.show();
        ball.show();
        life1.show();
        life2.show();
        life3.show();
    }

    @Override
    public void removeFromScreen() {
        program.remove(bg);
        program.remove(bar);
        racket.hide();
        ball.hide();
        life1.hide();
        life2.hide();
        life3.hide();
    }
}
