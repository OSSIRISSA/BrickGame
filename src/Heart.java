import acm.graphics.GImage;
import acm.program.GraphicsProgram;

public class Heart extends GImage {

    public static int lifeCount = 3;
    public static GraphicsProgram program;


    public Heart(GraphicsProgram program, double centerX, double centerY, double width, double height, String image){
        super(image,centerX-width/2,centerY-height/2);
        Heart.program = program;
    }

    public static void updateLives(){
        /*if(lifeCount==2){
            //program.remove(Main.life3);
        }
        if(lifeCount==1){
            //program.remove(Main.life2);
        }
        if(lifeCount==0){
            //program.remove(Main.life1);

        }*/
    }

    public void show(){
        program.add(this);
    }

    public void hide(){
        program.remove(this);
    }
}
