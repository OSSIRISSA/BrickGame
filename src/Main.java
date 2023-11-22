import acm.graphics.GObject;
import acm.graphics.GPoint;
import acm.program.GraphicsProgram;

import java.awt.*;
import java.awt.event.MouseEvent;

public class Main extends GraphicsProgram {

    private final static int MAX_X = 300;
    private final static int MAX_Y = 600;

    private Button play;

    public void run(){
        this.setSize(MAX_X, MAX_Y);
        addMouseListeners();
        play = new Button(this, MAX_X/2.0, MAX_Y/2.0, 150, 50, Color.lightGray, "Start Game", Color.RED);
    }

    public void mouseClicked(MouseEvent e) {

        GPoint last = new GPoint(e.getPoint());
        GObject objectUnderMouse = getElementAt(last);

        if (objectUnderMouse != null && objectUnderMouse.equals(play)) {
            removeAll();
        }

    }

}