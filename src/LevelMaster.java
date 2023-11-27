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
    public static Ball ball;
    public static Racket racket;
    public static Brick brick;
    public static Heart life1;
    public static Heart life2;
    public static Heart life3;

    public static Score score;

    public int  BRICK_NUMBER_X;
    public int BRICK_NUMBER_Y;
    public double BRICK_WIDTH;
    public double BRICK_HEIGHT;
    public LevelMaster(GraphicsProgram program) {
        super(program);
        this.radius = Main.BALL_RADIUS;
    }

    public void initialize() {
        bg = new GImage("assets/bg1.jpg");
        bar = new GRect(0,0,sizeX,49);
        bar.setFilled(true);

        racket = new Racket(program, "assets/board.png", sizeX/2.0, sizeY*0.9);
        Main.racket = racket;
        ball = new Ball(program, racket.getX()+racket.getWidth()/2.0, racket.getY()-radius-3, radius, Color.CYAN);
        Main.ball = ball;
        life1 = new Heart(program,25.0,25.0,50.0,50.0,"assets/heart1.gif");
        life2 = new Heart(program,75.0,25.0,50.0,50.0,"assets/heart3.gif");
        life3 = new Heart(program,125.0,25.0,50.0,50.0,"assets/heart2.gif");
        score = new Score(program);
    }

    public void addBricks(){
    }

    @Override
    public void addToScreen() {
        program.add(bg);
        program.add(bar);
        racket.show();
        addBricks();
        ball.show();
        life1.show();
        life2.show();
        life3.show();
        score.add();
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
