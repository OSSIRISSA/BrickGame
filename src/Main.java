import acm.graphics.*;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;
import acm.util.SoundClip;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

public class Main extends GraphicsProgram {

    public final static int MAX_X = 700;
    public final static int MAX_Y = 700;
    public final static double BALL_RADIUS = 5;
    private final RandomGenerator random = RandomGenerator.getInstance();
    private SoundClip Crack = new SoundClip("assets/Crack.au");

    private final static int  BRICK_NUMBER_X= 16;
    private final static int BRICK_NUMBER_Y= 3;
    private final static int BRICK_WIDTH = MAX_X /BRICK_NUMBER_X;
    private final static int BRICK_HEIGHT = 40;
    Font cyberFont = Font.createFont(Font.TRUETYPE_FONT, new File("assets/SpaceMonkey.ttf")).deriveFont(12f);

    public Button play;
    public Ball ball;
    public static Racket racket;

    public static Brick brick;
    public static Heart life1;
    public static Heart life2;
    public static Heart life3;


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
        }// else play.released();
    }

    private void game() {

        GImage bg = new GImage("assets/bg1.jpg");
        add(bg);

        GRect bar = new GRect(0,0,MAX_X,49);
        bar.setFilled(true);
        add(bar);
        racket = new Racket(this, "assets/board.png", MAX_X/2.0, this.getHeight()*0.9);
        ball = new Ball(this, random.nextDouble(1,MAX_X-BALL_RADIUS*2-1), random.nextDouble(50,MAX_Y-100),BALL_RADIUS,Color.CYAN);
        life1 = new Heart(this,25.0,25.0,50.0,50.0,"assets/heart1.gif");
        life2 = new Heart(this,75.0,25.0,50.0,50.0,"assets/heart3.gif");
        life3 = new Heart(this,125.0,25.0,50.0,50.0,"assets/heart2.gif");
        brick = new HardBrick(this, 100, 200, BRICK_WIDTH, BRICK_HEIGHT,Color.RED);
    }


    public void mousePressed(MouseEvent e) {
        brick.breakIt();
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