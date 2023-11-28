import acm.graphics.GLabel;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;
import acm.util.SoundClip;

import java.awt.*;

public class Victory extends ScreenParent {


    public Button goToLevelSelection;
    private GLabel header;

    private GRect menuBG;
    public final Color halfTransparent = new Color(0,0,0,101);

    private SoundClip fail = new SoundClip("assets/fail.au");
    public Victory(GraphicsProgram program) {
        super(program);
        initialize();
    }
    public void initialize(){
        header = new GLabel("Victory");
        header.setFont(cyberFont.deriveFont(38f));
        header.setLocation(sizeX/2.0-header.getWidth()/2, 50+(sizeY-50)/2.0 - header.getHeight()*1.5);
        header.setColor(Color.yellow);
        goToLevelSelection = new Button(program, sizeX/2.0, 50+(sizeY-50)/2.0, sizeX/4.0, sizeY/15.0, Color.LIGHT_GRAY, "  Select level", Color.RED, cyberFont, true, "");
    }

    public Button getGoToLevelSelection() {
        return goToLevelSelection;
    }

    @Override
    public void addToScreen() {
        Heart.lifeCount=3;
        Main.racket.isGameStarted = false;
        menuBG = new GRect(Main.MAX_X*0.25,50+(Main.MAX_Y-50)*0.1,Main.MAX_X*0.5,(Main.MAX_Y-50)*0.8);
        menuBG.setFilled(true);
        menuBG.setColor(halfTransparent);
        program.add(menuBG);
        goToLevelSelection.show();
        program.add(header);
    }

    @Override
    public void removeFromScreen() {
        program.remove(menuBG);
        goToLevelSelection.hide();
        program.remove(header);
    }
}
