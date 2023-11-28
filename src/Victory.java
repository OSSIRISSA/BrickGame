import acm.graphics.GLabel;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;

import java.awt.*;

public class Victory extends ScreenParent {


    public Button goToLevelSelection;
    private GLabel header;
    public Button nextLevel;
    private GRect menuBG;
    public final Color halfTransparent = new Color(0,0,0,101);

    public Victory(GraphicsProgram program) {
        super(program);
        initialize();
    }
    public void initialize(){
        menuBG = new GRect(Main.MAX_X*0.25,50+(Main.MAX_Y-50)*0.1,Main.MAX_X*0.5,(Main.MAX_Y-50)*0.8);
        menuBG.setFilled(true);
        menuBG.setColor(halfTransparent);

        header = new GLabel("Victory");
        header.setFont(cyberFont.deriveFont(38f));
        header.setLocation(sizeX/2.0-header.getWidth()/2, 50+(sizeY-50)/2.0 - header.getHeight()*1.5);
        header.setColor(Color.yellow);

        nextLevel = new Button(program, sizeX/2.0, 50+(sizeY-50)/2.0, sizeX/4.0, sizeY/15.0, Color.LIGHT_GRAY, "  Next level", Color.RED, cyberFont, true, "lock.png");

        goToLevelSelection = new Button(program, sizeX/2.0, nextLevel.getY()+nextLevel.getHeight()*2, sizeX/4.0, sizeY/15.0, Color.LIGHT_GRAY, "  Select level", Color.RED, cyberFont, true, "");
    }

    public Button getGoToLevelSelection() {
        return goToLevelSelection;
    }

    public Button getNextLevel() {
        return nextLevel;
    }

    @Override
    public void addToScreen() {
        Heart.lifeCount=3;
        Main.racket.isGameStarted = false;
        program.add(menuBG);
        nextLevel.show();
        goToLevelSelection.show();
        program.add(header);

        if (Main.currentLevel == 1) {
            Main.maxLevelAvailable = 2;
        } else {
            Main.maxLevelAvailable = 3;
        }
    }

    @Override
    public void removeFromScreen() {
        program.remove(menuBG);
        nextLevel.hide();
        goToLevelSelection.hide();
        program.remove(header);
    }
}
