import acm.graphics.GLabel;
import acm.program.GraphicsProgram;

import java.awt.*;

public class GameOver extends ScreenParent {


    public Button goToMainMenu;
    private GLabel header;
    public GameOver(GraphicsProgram program) {
        super(program);
        initialize();
    }

    public void initialize(){
        header = new GLabel("Game Over");
        header.setFont(cyberFont.deriveFont(60f));
        header.setLocation(sizeX/2.0-header.getWidth()/2, sizeY/2.0 - header.getHeight()*1.5);
        goToMainMenu = new Button(program, sizeX/2.0, sizeY/2.0, sizeX/2.0, sizeY/10.0, Color.LIGHT_GRAY, "Main Menu", Color.RED, cyberFont, true, "");
    }

    public Button getGoToMainMenuButton() {
        return goToMainMenu;
    }

    @Override
    public void addToScreen() {
        goToMainMenu.show();
        program.add(header);
    }

    @Override
    public void removeFromScreen() {
        goToMainMenu.hide();
        program.remove(header);
    }
}
