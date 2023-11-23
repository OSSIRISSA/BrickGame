import acm.graphics.GLabel;
import acm.graphics.GObject;
import acm.graphics.GPoint;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

public class Main extends GraphicsProgram {

    public final static int MAX_X = 400;
    public final static int MAX_Y = 700;
    public final static double BALL_RADIUS = 5;
    private final RandomGenerator random = RandomGenerator.getInstance();

    Font cyberFont = Font.createFont(Font.TRUETYPE_FONT, new File("assets/SpaceMonkey.ttf")).deriveFont(12f);

    public Button play;
    public Ball ball;
    public static Racket racket;

    public Heart life1;
    public Heart life2;
    public Heart life3;

    public Main() throws IOException, FontFormatException {
    }

    public void run(){
        this.setSize(MAX_X+14, MAX_Y+60);
        addMouseListeners();

        play = new Button(this, MAX_X/2.0, MAX_Y/2.0, MAX_X/2.0, MAX_Y/10, Color.LIGHT_GRAY, "Start Game", Color.RED, cyberFont);
    }

    public void mouseClicked(MouseEvent e) {

        GPoint last = new GPoint(e.getPoint());
        GObject objectUnderMouse = getElementAt(last);

        if (objectUnderMouse != null && objectUnderMouse.equals(play)) {
            removeAll();
            game();
        }
    }

    public void mouseMoved(MouseEvent e){
        GPoint last = new GPoint(e.getPoint());
        GObject objectUnderMouse = getElementAt(last);
        if (racket!=null) {
            racket.movingToMouse(e.getX());
        }

        if (objectUnderMouse != null && objectUnderMouse.equals(play) && !play.isPressed) {
            play.hovered();
        } else play.released();
    }

    private void game() {
        GRect bar = new GRect(0,0,MAX_X,MAX_Y/10);
        bar.setFilled(true);
        add(bar);
        racket = new Racket(this,MAX_X/2.0, this.getHeight()*0.9,100,10,Color.BLACK);
        ball = new Ball(this, random.nextDouble(1,MAX_X), random.nextDouble(0,MAX_Y),BALL_RADIUS,Color.BLACK);
        life1 = new Heart(this,25.0,25.0,50.0,50.0,"heart.gif");
    }


    public void mousePressed(MouseEvent e) {

        GPoint last = new GPoint(e.getPoint());
        GObject objectUnderMouse = getElementAt(last);

        if (objectUnderMouse != null && objectUnderMouse.equals(play)) {
            play.pressed();
            play.isPressed=true;
        }
    }


    public void mouseReleased(MouseEvent e) {
        if (play.isPressed) {
            play.released();
            play.isPressed=false;
        }
    }
}