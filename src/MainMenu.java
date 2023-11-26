import acm.graphics.GLabel;
import acm.program.GraphicsProgram;

import java.awt.*;

public class MainMenu extends ScreenParent {


    private Button play;
    private GLabel header;
    public MainMenu(GraphicsProgram program) {
        super(program);
        initialize();
    }

    public void initialize(){
        header = new GLabel("Game Name");
        header.setFont(cyberFont.deriveFont(60f));
        header.setLocation(sizeX/2.0-header.getWidth()/2, sizeY/2.0 - header.getHeight()*1.5);

        play = new Button(program, sizeX/2.0, sizeY/2.0, sizeX/2.0, sizeY/10.0, Color.LIGHT_GRAY, "Start Game", Color.RED, cyberFont, true, "");
    }

    public Button getPlayButton() {
        return play;
    }

    @Override
    public void addToScreen() {
        play.show();
        program.add(header);
    }

    @Override
    public void removeFromScreen() {
        play.hide();
        program.remove(header);
    }
}
