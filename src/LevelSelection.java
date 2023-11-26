import acm.graphics.GLabel;
import acm.program.GraphicsProgram;

import java.awt.*;

public class LevelSelection extends ScreenParent {
    private GLabel header;
    private LevelButton levelButton;

    public LevelSelection(GraphicsProgram program) {
        super(program);
        initialize();
    }

    @Override
    public void initialize() {
        header = new GLabel("Select level");
        header.setFont(cyberFont.deriveFont(60f));
        header.setLocation(sizeX/2.0-header.getWidth()/2, header.getHeight());
    }

    @Override
    public void addToScreen() {
        program.add(header);
        for (int i=1; i<=4; i++){
            for (int j=1; j<=4; j++) {
                if (((i-1)*4+j)<=Main.currentLevel) {
                    levelButton = new LevelButton(program, sizeX / 4.5 * j - sizeX / 18.0, sizeY / 4.5 * i - sizeY / 18.0, sizeX / 9.0, sizeY / 9.0, Color.LIGHT_GRAY, ((i - 1) * 4 + j) + "", Color.BLUE, cyberFont, true, "");
                } else {
                    levelButton = new LevelButton(program, sizeX / 4.5 * j - sizeX / 18.0, sizeY / 4.5 * i - sizeY / 18.0, sizeX / 9.0, sizeY / 9.0, Color.LIGHT_GRAY, ((i - 1) * 4 + j) + "", Color.BLUE, cyberFont, false, "assets/lock.png");
                }
                levelButton.show();
            }
        }
    }

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
