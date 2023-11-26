import acm.graphics.*;
import acm.program.GraphicsProgram;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ball extends GOval {
    private Brick brick;
    public double vx = 3.0;
    public double vy = 3.0;
    private final GraphicsProgram program;
    private final double radius;

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
        GObject objectUnderMouse = program.getElementAt(this.getX(), this.getY() + this.getHeight() + 1);
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
        if((underDot1!=null&&underDot1.getClass().equals(Brick.class))||(underDot2!=null&&underDot2.getClass().equals(Brick.class))){
            brick= ((Brick) underDot1);
            if(brick!=null){
                brick.breakIt();
            }
            brick= ((Brick) underDot2);
            if(brick!=null){
                brick.breakIt();
            }
            vy*=-1;
        }
        if((underDot3!=null&&underDot3.getClass().equals(Brick.class))||(underDot4!=null&&underDot4.getClass().equals(Brick.class))){
            brick= ((Brick) underDot3);
            if(brick!=null){
                brick.breakIt();
            }
            brick= ((Brick) underDot4);
            if(brick!=null){
                brick.breakIt();
            }
            vx*=-1;
        }
        if((underDot8!=null&&underDot8.getClass().equals(Brick.class))||(underDot7!=null&&underDot7.getClass().equals(Brick.class))){
            brick= ((Brick) underDot7);
            if(brick!=null){
                brick.breakIt();
            }
            brick= ((Brick) underDot8);
            if(brick!=null){
                brick.breakIt();
            }
            vx*=-1;
        }
        if((underDot6!=null&&underDot6.getClass().equals(Brick.class))||(underDot5!=null&&underDot5.getClass().equals(Brick.class))){
            brick= ((Brick) underDot5);
            if(brick!=null){
                brick.breakIt();
            }
            brick= ((Brick) underDot6);
            if(brick!=null){
                brick.breakIt();
            }
            vy*=-1;
        }
    }

    private void gameStarted(){

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
                }
                Ball.this.move(vx, vy);

            }
        };
        new Timer(10, taskPerformer).start();
    }

    public void show(){
        gameStarted();
        program.add(this);
    }

    public void hide(){
        program.remove(this);
    }
}
