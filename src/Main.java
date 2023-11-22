import acm.graphics.GObject;
import acm.graphics.GPoint;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;
import java.awt.*;
import java.awt.event.MouseEvent;

public class Main extends GraphicsProgram {

    public final static int MAX_X = 400;
    public final static int MAX_Y = 700;
    public final static double BALL_RADIUS = 5;
    private final RandomGenerator random = RandomGenerator.getInstance();

    public Button play;
    public Ball ball;
    public static Racket racket;

    public void run(){
        this.setSize(MAX_X+14, MAX_Y+60);
        addMouseListeners();
        game();
    }

    public void mouseClicked(MouseEvent e) {

        GPoint last = new GPoint(e.getPoint());
        GObject objectUnderMouse = getElementAt(last);

        if (objectUnderMouse != null && objectUnderMouse.equals(play)) {
            game();
            //removeAll();
        }

    }

    public void mouseMoved(MouseEvent e){
        GPoint last = new GPoint(e.getPoint());
        GObject objectUnderMouse = getElementAt(last);
        racket.movingToMouse(e.getX());
    }

    private void game() {
        racket = new Racket(this,MAX_X/2.0, this.getHeight()*0.9,100,10,Color.BLACK);
        ball = new Ball(this, random.nextDouble(1,MAX_X), random.nextDouble(0,MAX_Y),BALL_RADIUS,Color.BLACK);
    }

}