import acm.graphics.GObject;
import acm.graphics.GPoint;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;

import java.awt.*;
import java.awt.event.MouseEvent;

public class Main extends GraphicsProgram {

    public final static int MAX_X = 300;
    public final static int MAX_Y = 600;
    public final static double BALL_RADIUS = 5;
    private RandomGenerator rgen = RandomGenerator.getInstance();

    public Button play;
    public Ball ball;
    public static Racket racket;

    public void run(){
        this.setSize(MAX_X, MAX_Y);
        addMouseListeners();
        game();
        //play = new Button(this, MAX_X/2.0, MAX_Y/2.0, 150, 50, Color.lightGray, "Start Game", Color.RED);
    }

    public void mouseClicked(MouseEvent e) {

        GPoint last = new GPoint(e.getPoint());
        GObject objectUnderMouse = getElementAt(last);

        if (objectUnderMouse != null && objectUnderMouse.equals(play)) {
            game();
            //removeAll();
            //game();
        }

    }

    public void mouseMoved(MouseEvent e){
        GPoint last = new GPoint(e.getPoint());
        //GObject objectUnderMouse = getElementAt(last);
        racket.movingToMouse(e.getX());
    }

    private void game() {
        racket = new Racket(this,MAX_X/2, this.getHeight()*0.9,100,10,Color.BLACK);
        ball = new Ball(this, rgen.nextDouble(0,MAX_X), rgen.nextDouble(0,MAX_Y),BALL_RADIUS,Color.BLACK);
    }

}