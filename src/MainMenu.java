import acm.graphics.GLabel;
import acm.program.GraphicsProgram;

import java.awt.*;

public class MainMenu extends ScreenParent {


    private Button play;
    private GLabel header;
    private GLabel authors;
    public MainMenu(GraphicsProgram program) {
        super(program);
        initialize();
    }

    public void initialize(){
        header = new GLabel("Game Name");
        header.setFont(cyberFont.deriveFont(60f));
        header.setLocation(sizeX/2.0-header.getWidth()/2, sizeY/2.0 - header.getHeight()*1.5);

        authors = new GLabel("Made by: Chernenko Andriy, Hryshchenko Iryna, Mormil Max");
        authors.setFont("italic-24");
        authors.setLocation(sizeX/2.0-authors.getWidth()*0.5, sizeY - authors.getHeight());

        play = new Button(program, sizeX/2.0, sizeY/2.0, sizeX/2.0, sizeY/10.0, Color.LIGHT_GRAY, "Start Game", Color.RED, cyberFont, true, "");
    }

    public Button getPlayButton() {
        return play;
    }

    @Override
    public void addToScreen() {
        play.show();
        program.add(authors);
        program.add(header);
    }

    @Override
    public void removeFromScreen() {
        play.hide();
        program.remove(authors);
        program.remove(header);
    }
}
