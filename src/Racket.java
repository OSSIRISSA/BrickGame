import acm.graphics.GCompound;
import acm.graphics.GImage;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;
import java.awt.*;

public class Racket extends GImage {

    /**
     * Creates a racket
     * @param program - program, who called
     * @param centerX - x of the center of the racket
     * @param centerY - y of the center of the racket
     */
    public Racket(GraphicsProgram program, String image, double centerX, double centerY){
        super(image);
        program.add(this, centerX-this.getWidth()/2,centerY-this.getHeight()/2);

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
