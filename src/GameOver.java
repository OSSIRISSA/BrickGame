import acm.graphics.GLabel;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;
import acm.util.SoundClip;

import java.awt.*;

public class GameOver extends ScreenParent {
    public Button goToLevelSelection;
    public Button restartLevel;
    private GLabel header;

    private GRect menuBG;
    public final Color halfTransparent = new Color(0,0,0,101);

    private final SoundClip fail = new SoundClip("assets/fail.au");
    public GameOver(GraphicsProgram program) {
        super(program);
        initialize();
    }
    public void initialize(){
        menuBG = new GRect(Main.MAX_X*0.25,50+(Main.MAX_Y-50)*0.1,Main.MAX_X*0.5,(Main.MAX_Y-50)*0.8);
        menuBG.setFilled(true);
        menuBG.setColor(halfTransparent);

        header = new GLabel("Game Over");
        header.setFont(cyberFont.deriveFont(38f));
        header.setLocation(sizeX/2.0-header.getWidth()/2, 50+(sizeY-50)/2.0 - header.getHeight()*1.5);
        header.setColor(Color.yellow);

        restartLevel = new Button(program, sizeX/2.0, 50+(sizeY-50)/2.0, sizeX/4.0, sizeY/15.0, Color.LIGHT_GRAY, "  Restart level", Color.RED, cyberFont, true, "");

        goToLevelSelection = new Button(program, sizeX/2.0, restartLevel.getY()+restartLevel.getHeight()*2, sizeX/4.0, sizeY/15.0, Color.LIGHT_GRAY, "  Select level", Color.RED, cyberFont, true, "");
    }

    public Button getGoToLevelSelection() {
        return goToLevelSelection;
    }

    public Button getRestartLevel() {
        return restartLevel;
    }

    @Override
    public void addToScreen() {
        Heart.lifeCount=3;
        Main.racket.isGameStarted = false;

        program.add(menuBG);

        goToLevelSelection.show();
        restartLevel.show();

        Score.currentScore = 0;

        fail.setVolume(1);
        fail.play();
        program.add(header);
    }

    @Override
    public void removeFromScreen() {
        program.remove(menuBG);
        goToLevelSelection.hide();
        restartLevel.hide();
        program.remove(header);
    }
}