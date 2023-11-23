import acm.graphics.*;
import acm.program.GraphicsProgram;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ball extends GOval {
    public double vx = 3.0;
    public double vy = 3.0;
    private final GraphicsProgram program;


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
        this.setColor(color);
        this.setFilled(true);
        program.add(this);


        /**
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
        }

         */
    }

    /**
     * @return - condition "if ball touches the racket"
     */
    private boolean collidesWithRacket() {
        GObject objectUnderMouse = getParent().getElementAt(this.getX(), this.getY() + this.getHeight() + 1);
        return (objectUnderMouse != null && objectUnderMouse.equals(Main.racket));
    }
}
