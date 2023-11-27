import acm.graphics.*;
import acm.program.GraphicsProgram;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

public class Main extends GraphicsProgram {
    public final static int MAX_X = 700;
    public final static int MAX_Y = 700;
    public static int currentLevel=1;
    public final static double BALL_RADIUS = 5;

    public static boolean waitingForStart = false;

    public GObject objectUnderMouse;
    public static Font cyberFont;

    static {
        try {
            cyberFont = Font.createFont(Font.TRUETYPE_FONT, new File("assets/SpaceMonkey.ttf")).deriveFont(12f);
        } catch (FontFormatException | IOException e) {
            throw new RuntimeException(e);
        }
    }
    private final MainMenu mainMenu = new MainMenu(this);

    public static GameOver gameOver;
    private final LevelSelection levelSelection = new LevelSelection(this);
    LevelButton levelButton;
    public static Racket racket;

    public static  Ball ball;


    public void run(){
        this.setSize(MAX_X+14, MAX_Y+60);
        addMouseListeners();
        mainMenu.addToScreen();
    }



    public void mouseMoved(MouseEvent e){
        GPoint last = new GPoint(e.getPoint());
        GObject previousObjectUnderMouse = objectUnderMouse;
        objectUnderMouse = getElementAt(last);

        if (racket!=null && racket.isGameStarted) {
            racket.movingToMouse(e.getX());
        } else {
            if ((previousObjectUnderMouse != null) && (!previousObjectUnderMouse.equals(objectUnderMouse))) {
                if (previousObjectUnderMouse.equals(mainMenu.getPlayButton())) {
                    mainMenu.getPlayButton().released();
                } else if (previousObjectUnderMouse.getClass().equals(LevelButton.class)) {
                    levelButton = ((LevelButton) previousObjectUnderMouse);
                    if (!levelButton.isPressed && levelButton.isEnabled) {
                        levelButton.released();
                    }
                }
            } else if ((objectUnderMouse != null) && (previousObjectUnderMouse == null || previousObjectUnderMouse.getClass().equals(LevelButton.class))) {
                if (objectUnderMouse.equals(mainMenu.getPlayButton())) {
                    mainMenu.getPlayButton().hovered();
                } else if (objectUnderMouse.getClass().equals(LevelButton.class)) {
                    levelButton = ((LevelButton) objectUnderMouse);
                    if (!levelButton.isPressed && levelButton.isEnabled) {
                        levelButton.hovered();
                    }
                }
            }
        }
    }

    public void mouseClicked(MouseEvent e) {
        if (waitingForStart) {
            waitingForStart=false;
            LevelMaster.racket.isGameStarted=true;
            LevelMaster.ball.gameStarted();
            waitingForStart=false;
        } else
        if (objectUnderMouse != null && objectUnderMouse.equals(mainMenu.getPlayButton())) {
            mainMenu.removeFromScreen();
            levelSelection.addToScreen();
        } else if(objectUnderMouse != null && objectUnderMouse.getClass().equals(LevelButton.class)){
            levelButton = ((LevelButton) objectUnderMouse);
            if(levelButton.isEnabled) {
                levelSelection.removeFromScreen();
                switch (Integer.parseInt(levelButton.getButtonText().getLabel())) {
                    case 1 -> {Level1 level1 = new Level1(this); level1.addToScreen();}
                    case 2 -> {Level2 level1 = new Level2(this); level1.addToScreen();}
                    case 3 -> {Level3 level1 = new Level3(this); level1.addToScreen();}
                    case 4 -> System.out.println(4);
                    case 5 -> System.out.println(5);
                    case 6 -> System.out.println(6);
                    case 7 -> System.out.println(7);
                    case 8 -> System.out.println(8);
                    case 9 -> System.out.println(9);
                    case 10 -> System.out.println(10);
                    case 11 -> System.out.println(11);
                    case 12 -> System.out.println(12);
                    case 13 -> System.out.println(13);
                    case 14 -> System.out.println(14);
                    case 15 -> System.out.println(15);
                    case 16 -> System.out.println(16);
                    default -> System.out.println("WTF???");
                }
                waitingForStart = true;
            }
        }
        else if(objectUnderMouse != null && objectUnderMouse.equals(gameOver.getGoToMainMenuButton())){
            gameOver.removeFromScreen();
            mainMenu.addToScreen();
        }
    }

    public void mousePressed(MouseEvent e) {
        if (objectUnderMouse != null && objectUnderMouse.equals(mainMenu.getPlayButton())) {
            mainMenu.getPlayButton().pressed();
            mainMenu.getPlayButton().isPressed=true;
        } else if (objectUnderMouse!=null && objectUnderMouse.equals(levelButton) && levelButton.isEnabled){
            levelButton.pressed();
            levelButton.isPressed=true;
        }
    }

    public void mouseReleased(MouseEvent e) {
        if (mainMenu.getPlayButton().isPressed) {
            mainMenu.getPlayButton().released();
            mainMenu.getPlayButton().isPressed=false;
        } else if(levelButton!=null && levelButton.isPressed) {
            levelButton.released();
            levelButton.isPressed=false;
        }
    }
}