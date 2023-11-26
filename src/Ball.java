import acm.graphics.*;
import acm.program.GraphicsProgram;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ball extends GOval {
    private Brick brick;
    private Brick brick2;
    public double vx = 3.0;
    public double vy = 3.0;
    private final GraphicsProgram program;
    private final double radius;
    public boolean isGameStarted=false;

    /**
     * Creates a ball
     * @param program - program, who called
     * @param centerX - x of the center of the ball
     * @param centerY - y of the center of the ball
     * @param radius - radius of the ball
     * @param color - color of the ball
     */
    public Ball(GraphicsProgram program, double centerX, double centerY, double radius, Color color) {
        super(centerX - radius, centerY - radius, radius * 2, radius * 2);
        this.program = program;
        this.radius=radius;
        this.setColor(Color.BLACK);
        this.setFilled(true);
        this.setFillColor(color);
        /*
            Hitting the ball from the walls and movement

        while (true) {
            if (this.getX() + radius * 2 + vx >= program.getWidth() || this.getX() + vx < 0) {
                vx *= -1;
            }
            if (this.getY() + radius * 2 + vy >= program.getHeight() || this.getY() + vy < 0) {
                vy *= -1;
            }
            if (this.collidesWithRacket() && vy > 0) {
                vy *= -1;
            }
            this.move(vx, vy);
            pause(10);
        }*/
    }

    /**
     * @return - condition "if ball touches the racket"
     */
    private boolean collidesWithRacket() {
        GObject objectUnderMouse = program.getElementAt(this.getX()+this.getWidth()/2, this.getY() + this.getHeight() + 1);
        return (objectUnderMouse != null && objectUnderMouse.equals(Main.racket));
    }

    private void collidesWithBrick(){
        GPoint dot1 = new GPoint(this.getX(),this.getY()-Math.abs(vy));
        GPoint dot2 = new GPoint(this.getX()+radius*2,this.getY()-Math.abs(vy));
        GPoint dot3 = new GPoint(this.getX()+radius*2+Math.abs(vx),this.getY());
        GPoint dot4 = new GPoint(this.getX()+radius*2+Math.abs(vx),this.getY()+radius*2);
        GPoint dot5 = new GPoint(this.getX()+radius*2,this.getY()+radius*2+Math.abs(vy));
        GPoint dot6 = new GPoint(this.getX(),this.getY()+radius*2+Math.abs(vy));
        GPoint dot7 = new GPoint(this.getX()-Math.abs(vx),this.getY()+radius*2);
        GPoint dot8 = new GPoint(this.getX()-Math.abs(vx),this.getY());
        GObject underDot1 = program.getElementAt(dot1);
        GObject underDot2 = program.getElementAt(dot2);
        GObject underDot3 = program.getElementAt(dot3);
        GObject underDot4 = program.getElementAt(dot4);
        GObject underDot5 = program.getElementAt(dot5);
        GObject underDot6 = program.getElementAt(dot6);
        GObject underDot7 = program.getElementAt(dot7);
        GObject underDot8 = program.getElementAt(dot8);
        if((underDot1!=null&&Brick.class.isAssignableFrom(underDot1.getClass()))||(underDot2!=null&&Brick.class.isAssignableFrom(underDot2.getClass()))){
            if(underDot1 instanceof Brick){
                brick= ((Brick) underDot1);
            }
            if(underDot2 instanceof Brick){
                brick2= ((Brick) underDot2);
            }
            if(brick.equals(brick2)){
                brick.breakIt();
            }
            else{
                if(brick!=null) brick.breakIt();
                if(brick2!=null) brick2.breakIt();
            }
            vy*=-1;
        }
        if((underDot3!=null&&Brick.class.isAssignableFrom(underDot3.getClass()))||(underDot4!=null&&Brick.class.isAssignableFrom(underDot4.getClass()))){
            if(underDot3 instanceof Brick){
                brick= ((Brick) underDot3);
            }
            if(underDot4 instanceof Brick){
                brick2= ((Brick) underDot4);
            }
            if(brick.equals(brick2)){
                brick.breakIt();
            }
            else{
                if(brick!=null) brick.breakIt();
                if(brick2!=null) brick2.breakIt();
            }
            vx*=-1;
        }
        if((underDot8!=null&&Brick.class.isAssignableFrom(underDot8.getClass()))||(underDot7!=null&&Brick.class.isAssignableFrom(underDot7.getClass()))){
            if(underDot8 instanceof Brick){
                brick= ((Brick) underDot8);
            }
            if(underDot7 instanceof Brick){
                brick2= ((Brick) underDot7);
            }
            if(brick.equals(brick2)){
                brick.breakIt();
            }
            else{
                if(brick!=null) brick.breakIt();
                if(brick2!=null) brick2.breakIt();
            }
            vx*=-1;
        }
        if((underDot6!=null&&Brick.class.isAssignableFrom(underDot6.getClass()))||(underDot5!=null&&Brick.class.isAssignableFrom(underDot5.getClass()))){
            if(underDot6 instanceof Brick){
                brick= ((Brick) underDot6);
            }
            if(underDot5 instanceof Brick){
                brick2= ((Brick) underDot5);
            }
            if(brick.equals(brick2)){
                brick.breakIt();
            }
            else{
                if(brick!=null) brick.breakIt();
                if(brick2!=null) brick2.breakIt();
            }
            vy*=-1;
        }
    }

    public void gameStarted(){

        /*
         *   TIMER
         */
        ActionListener taskPerformer = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {

                if (Ball.this.getX() + radius * 2 + vx >= program.getWidth() || Ball.this.getX() + vx < 0) {
                    vx *= -1;
                }
                if (Ball.this.getY() + radius * 2 + vy >= program.getHeight() || Ball.this.getY() + vy < 50) {
                    if(Ball.this.getY() + radius * 2 + vy>program.getHeight()*0.9){
                        Heart.lifeCount--;
                        Heart.updateLives();
                    }
                    vy *= -1;
                }
                if (Ball.this.collidesWithRacket() && vy > 0) {
                    vy *= -1;
                    vx=collideAngle();
                }
                collidesWithBrick();
                Ball.this.move(vx, vy);

            }
        };
        new Timer(10, taskPerformer).start();
    }

    private double collideAngle() {
        double vxMax=3.0;
        double vxMin=3.0*0.2;

        GObject ballCollider = program.getElementAt(this.getX()+this.getWidth()/2, this.getY() + this.getHeight() + 1);
        Racket racket = ((Racket) ballCollider);
        double ballMiddleX = this.getX()+this.getWidth()/2.0-racket.getX();
        double racketMiddleX = racket.getWidth()/2.0;

        if (racketMiddleX>ballMiddleX){
            ballMiddleX/=racketMiddleX;
            return -vxMax-((-vxMax+vxMin)*ballMiddleX-vxMin);
        } else {
            ballMiddleX-=racketMiddleX;
            ballMiddleX=racketMiddleX-ballMiddleX;
            ballMiddleX/=racketMiddleX;
            ballMiddleX=1-ballMiddleX;
            return (vxMax-vxMin)*ballMiddleX+vxMin;
        }
    }

    public void show(){
        program.add(this);
    }

    public void hide(){
        program.remove(this);
    }
}
