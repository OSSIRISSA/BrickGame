import acm.graphics.*;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;

import java.awt.*;

public class Ball extends GOval {
    private final static RandomGenerator random = RandomGenerator.getInstance();
    public double vx = 3.0;
    public double vy = 3.0;
    private GraphicsProgram program;


    public Ball(GraphicsProgram program, double centerX, double centerY, double radius, Color color) {
        super(centerX - radius, centerY - radius, radius * 2, radius * 2);
        this.program = program;
        this.setColor(color);
        this.setFilled(true);
        program.add(this);


        while (true) {
            if (this.getX() + radius * 2 + vx >= program.getWidth() || this.getX() + vx < 0) {
                    vx*=-1;
            }
            if (this.getY() + radius * 2 + vy >= program.getHeight() || this.getY() + vy < 0) {
                    vy*=-1;
            }
            if(this.collidesWithRacket() && vy>0){
                    vy*=-1;
            }
            this.move(vx, vy);
            pause(10);
        }

    }

    private boolean collidesWithRacket() {
        //GPoint last = new GPoint(this.getX());
        GObject objectUnderMouse = getParent().getElementAt(this.getX(), this.getY() + this.getHeight()+1);
        return (objectUnderMouse!=null && objectUnderMouse.equals(Main.racket));
    }
}
