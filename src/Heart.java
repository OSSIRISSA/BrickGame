import acm.graphics.GImage;
import acm.program.GraphicsProgram;

public class Heart extends GImage {

    public static int lifeCount = 3;
    public static GraphicsProgram program;

    public static GameOver gameOver;


    public Heart(GraphicsProgram program, double centerX, double centerY, double width, double height, String image){
        super(image,centerX-width/2,centerY-height/2);
        Heart.program = program;
        gameOver = new GameOver(program);
        Main.gameOver=gameOver;
    }

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

    public void show(){
        program.add(this);
    }

    public void hide(){
        program.remove(this);
    }
}
