import acm.graphics.GImage;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;
import java.awt.*;

public class Heart extends GImage {

    public Heart(GraphicsProgram program, double centerX, double centerY, double width, double height, String image){
        super(image,centerX-width/2,centerY-height/2);
        program.add(this);
    }

    /*public void movingToMouse(int x){
        while(this.getX()+getWidth()/2!=x){
            if(this.getX()+getWidth()/2<x){
                this.move(1,0);
            }
            if(this.getX()+getWidth()/2>x){
                this.move(-1,0);
            }
        }
    }*/
}
