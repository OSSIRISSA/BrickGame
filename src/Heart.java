import acm.graphics.GImage;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;
import java.awt.*;


public class Heart extends GImage {

    public static int lifeCount = 3;
    public static GraphicsProgram program;


    public Heart(GraphicsProgram program, double centerX, double centerY, double width, double height, String image){
        super(image,centerX-width/2,centerY-height/2);
        this.program = program;
        program.add(this);
    }

    public static void updateLives(){
        if(lifeCount==2){
            program.remove(Main.life3);
        }
        if(lifeCount==1){
            program.remove(Main.life2);
        }
        if(lifeCount==0){
            program.remove(Main.life1);
            System.out.println("fail");
        }
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
