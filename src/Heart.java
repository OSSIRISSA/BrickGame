import acm.graphics.GImage;
import acm.program.GraphicsProgram;

public class Heart extends GImage {
    /**
     * Represents a heart object in the program.
     * Extends GImage.
     */
    public static int lifeCount = 3;
    public static GraphicsProgram program;

    public static GameOver gameOver;
    /**
     * Constructs a heart object.
     *
     * @param program   The graphics program that called this method.
     * @param centerX   The x-coordinate of the center of the heart.
     * @param centerY   The y-coordinate of the center of the heart.
     * @param width     The width of the heart.
     * @param height    The height of the heart.
     * @param image     The image representing the heart.
     */
    public Heart(GraphicsProgram program, double centerX, double centerY, double width, double height, String image){
        super(image,centerX-width/2,centerY-height/2);
        Heart.program = program;
        gameOver = new GameOver(program);
        Main.gameOver=gameOver;
    }
    /**
     * Updates the number of lives and manages the hearts displayed on the screen.
     */
    public static void updateLives(){
        if(lifeCount==2){
            program.remove(LevelMaster.life3);
        }
        if(lifeCount==1){
            program.remove(LevelMaster.life2);
        }
        if(lifeCount==0){
            program.remove(LevelMaster.life1);
            Main.waitingForStart=false;
            gameOver.addToScreen();
        }
    }
    /**
     * Displays the heart on the screen.
     */
    public void show(){
        program.add(this);
    }
    /**
     * Hides the heart from the screen.
     */
    public void hide(){
        program.remove(this);
    }
}