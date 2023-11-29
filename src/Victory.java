import acm.graphics.GLabel;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;

import java.awt.*;
/**
 * The Victory class represents the victory screen displayed upon completing a level.
 * It contains options to proceed to the next level or return to the level selection menu.
 */
public class Victory extends ScreenParent {

    /** The button to go to the level selection menu. */
    public Button goToLevelSelection;
    /** The header label for the victory screen. */
    private GLabel header;
    /** The button to proceed to the next level. */
    public Button nextLevel;
    /** The background rectangle for the victory menu. */
    private GRect menuBG;
    /** The half-transparent color used for the menu background. */
    public final Color halfTransparent = new Color(0,0,0,101);
    /**
     * Constructs a Victory object.
     *
     * @param program The GraphicsProgram instance associated with this screen.
     */
    public Victory(GraphicsProgram program) {
        super(program);
        initialize();
    }
    /** Initializes the elements of the victory screen. */
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
    /**
     * Gets the button for navigating to the level selection menu.
     *
     * @return The button for navigating to the level selection menu.
     */
    public Button getGoToLevelSelection() {
        return goToLevelSelection;
    }
    /**
     * Gets the button for proceeding to the next level.
     *
     * @return The button for proceeding to the next level.
     */

    public Button getNextLevel() {
        return nextLevel;
    }
    /**
     * Adds the victory screen components to the main GraphicsProgram window.
     */
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
    /**
     * Removes the victory screen components from the main GraphicsProgram window.
     */
    @Override
    public void removeFromScreen() {
        program.remove(menuBG);
        nextLevel.hide();
        goToLevelSelection.hide();
        program.remove(header);
    }
}
