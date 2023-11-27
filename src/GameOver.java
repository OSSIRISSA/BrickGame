import acm.graphics.GLabel;
import acm.program.GraphicsProgram;
import acm.util.SoundClip;

import java.awt.*;

public class GameOver extends ScreenParent {


    public Button goToLevelSelection;
    private GLabel header;

    private SoundClip fail = new SoundClip("assets/fail.au");
    public GameOver(GraphicsProgram program) {
        super(program);
        initialize();
    }
    public void initialize(){
        header = new GLabel("Game Over");
        header.setFont(cyberFont.deriveFont(60f));
        header.setLocation(sizeX/2.0-header.getWidth()/2, sizeY/2.0 - header.getHeight()*1.5);
        goToLevelSelection = new Button(program, sizeX/2.0, sizeY/2.0, sizeX/2.0, sizeY/10.0, Color.LIGHT_GRAY, "Try again", Color.RED, cyberFont, true, "");
    }

    public Button getGoToLevelSelection() {
        return goToLevelSelection;
    }

    @Override
    public void addToScreen() {
        Heart.lifeCount=3;
        program.removeAll();
        goToLevelSelection.show();
        fail.setVolume(1);
        fail.play();
        program.add(header);
    }

    @Override
    public void removeFromScreen() {
        goToLevelSelection.hide();
        program.remove(header);
    }
}
