import acm.graphics.GRect;
import acm.program.GraphicsProgram;
import java.awt.*;

public class Racket extends GRect {

    /**
     * Creates a racket
     * @param program - program, who called
     * @param centerX - x of the center of the racket
     * @param centerY - y of the center of the racket
     * @param width - width of the racket
     * @param height - height of the racket
     * @param color - color of the racket
     */
    public Racket(GraphicsProgram program, double centerX, double centerY, double width, double height, Color color){
        super(centerX-width/2,centerY-height/2,width,height);
        this.setColor(color);
        this.setFilled(true);
        program.add(this);


    }

    /**
     * Moves the racket to the position of mouse (for x)
     * @param x - x of the mouse
     */
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
