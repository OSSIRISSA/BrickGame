import acm.graphics.GLabel;
import acm.program.GraphicsProgram;

import java.awt.*;
/**
 * Represents the level selection screen containing level buttons.
 * Extends ScreenParent class.
 */
public class LevelSelection extends ScreenParent {
    private GLabel header;
    private LevelButton levelButton;

    /**
     * Constructs a LevelSelection object.
     *
     * @param program The graphics program that called this method.
     */
    public LevelSelection(GraphicsProgram program) {
        super(program);
        initialize();
    }
    /**
     * Initializes the level selection screen.
     */
    @Override
    public void initialize() {
        header = new GLabel("Select level");
        header.setFont(cyberFont.deriveFont(60f));
        header.setLocation(sizeX/2.0-header.getWidth()/2, header.getHeight());
    }
    /**
     * Adds the level selection screen components to the screen.
     */
    @Override
    public void addToScreen() {
        program.add(header);
        for (int i=1; i<=4; i++){
            for (int j=1; j<=4; j++) {
                if (((i-1)*4+j)<=Main.maxLevelAvailable) {
                    levelButton = new LevelButton(program, sizeX / 4.5 * j - sizeX / 18.0, sizeY / 4.5 * i - sizeY / 18.0, sizeX / 9.0, sizeY / 9.0, Color.LIGHT_GRAY, ((i - 1) * 4 + j) + "", Color.BLUE, cyberFont, true, "");
                } else {
                    levelButton = new LevelButton(program, sizeX / 4.5 * j - sizeX / 18.0, sizeY / 4.5 * i - sizeY / 18.0, sizeX / 9.0, sizeY / 9.0, Color.LIGHT_GRAY, ((i - 1) * 4 + j) + "", Color.BLUE, cyberFont, false, "assets/lock.png");
                }
                levelButton.show();
            }
        }
    }
    /**
     * Removes the level selection screen components from the screen.
     */
    @Override
    public void removeFromScreen() {
        //program.removeAll();

        program.remove(this.header);
        for (int i=1; i<=4; i++){
            for (int j=1; j<=4; j++) {
                levelButton = (LevelButton) program.getElementAt(sizeX/4.5*j-sizeX/18.0, sizeY/4.5*i-sizeY/18.0);
                levelButton.hide();
            }
        }
    }
}