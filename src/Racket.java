import acm.graphics.GImage;
import acm.program.GraphicsProgram;

public class Racket extends GImage {

    GraphicsProgram program;
    public boolean isGameStarted=false;

    /**
     * Creates a racket
     * @param program - program, who called
     * @param centerX - x of the center of the racket
     * @param centerY - y of the center of the racket
     */
    public Racket(GraphicsProgram program, String image, double centerX, double centerY){
        super(image);
        this.program=program;
        this.setLocation(centerX-this.getWidth()/2,centerY-this.getHeight()/2);
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

    public void show(){
        program.add(this);
    }

    public void hide(){
        isGameStarted=false;
        program.remove(this);
    }
}