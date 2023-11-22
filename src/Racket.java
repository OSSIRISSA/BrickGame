import acm.graphics.GLabel;
import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;

import java.awt.*;

public class Racket extends GRect {

    public Racket(GraphicsProgram program, double centerX, double centerY, double width, double height, Color color){
        super(centerX-width/2,centerY-height/2,width,height);
        this.setColor(color);
        this.setFilled(true);
        program.add(this);


    }

    public void movingToMouse(int x){
        while(this.getX()+getWidth()/2!=x){
            if(this.getX()+getWidth()/2<x){
                this.move(1,0);
            }
            if(this.getX()+getWidth()/2>x){
                this.move(-1,0);
            }
        }
    }
}
