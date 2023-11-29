import acm.graphics.*;
import acm.program.GraphicsProgram;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
/**Represents Main program class.
 * Extends GraphicsProgram
 */
public class Main extends GraphicsProgram {
    public final static int MAX_X = 700;
    public final static int MAX_Y = 700;
    public static int currentLevel;
    public static int maxLevelAvailable=1;
    public static int maxScore=0;
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
    public static Victory victoryWindow;

    private final LevelSelection levelSelection = new LevelSelection(this);
    private LevelButton levelButton;
    public static Racket racket;

    public static Ball ball;

/**
 * Runs the program itself
 * */
    public void run() {
        this.setSize(MAX_X + 14, MAX_Y + 60);
        //adds interface, that listens mouse actions
        addMouseListeners();
        mainMenu.addToScreen();
    }

    /**
     * Reacts on the movement of the mouse and performs actions, depending on the program state
     * */
    public void mouseMoved(MouseEvent e) {
        GPoint last = new GPoint(e.getPoint());
        GObject previousObjectUnderMouse = objectUnderMouse;
        objectUnderMouse = getElementAt(last);

        if (racket != null && racket.isGameStarted) {
            racket.movingToMouse(e.getX());
        } else {
            if ((previousObjectUnderMouse != null) && (!previousObjectUnderMouse.equals(objectUnderMouse))) {
                if (previousObjectUnderMouse.equals(mainMenu.getPlayButton())) {
                    mainMenu.getPlayButton().released();
                }
                if (gameOver != null && previousObjectUnderMouse.equals(gameOver.getGoToLevelSelection())) {
                    gameOver.getGoToLevelSelection().released();
                } else if (gameOver != null && previousObjectUnderMouse.equals(gameOver.getRestartLevel())){
                    gameOver.getRestartLevel().released();
                }
                if (victoryWindow != null && previousObjectUnderMouse.equals(victoryWindow.getGoToLevelSelection())) {
                    victoryWindow.getGoToLevelSelection().released();
                } else if (victoryWindow != null && previousObjectUnderMouse.equals(victoryWindow.getNextLevel())) {
                    victoryWindow.getNextLevel().released();
                }
                if (previousObjectUnderMouse.getClass().equals(LevelButton.class)) {
                    levelButton = ((LevelButton) previousObjectUnderMouse);
                    if (!levelButton.isPressed && levelButton.isEnabled) {
                        levelButton.released();
                    }
                }
            } else if (objectUnderMouse != null && objectUnderMouse instanceof Button) {
                if (objectUnderMouse.equals(mainMenu.getPlayButton())) {
                    mainMenu.getPlayButton().hovered();
                }
                if (gameOver != null && objectUnderMouse.equals(gameOver.getGoToLevelSelection())) {
                    gameOver.getGoToLevelSelection().hovered();
                } else if (gameOver != null && objectUnderMouse.equals(gameOver.getRestartLevel())) {
                    gameOver.getRestartLevel().hovered();
                }
                if (victoryWindow != null && objectUnderMouse.equals(victoryWindow.getGoToLevelSelection())) {
                    victoryWindow.getGoToLevelSelection().hovered();
                } else if (victoryWindow != null && objectUnderMouse.equals(victoryWindow.getNextLevel())) {
                    victoryWindow.getNextLevel().hovered();
                }
                if (objectUnderMouse.getClass().equals(LevelButton.class)) {
                    levelButton = ((LevelButton) objectUnderMouse);
                    if (!levelButton.isPressed && levelButton.isEnabled) {
                        levelButton.hovered();
                    }
                }
            }
        }
    }
    /**
     * Reacts on the clicking of the mouse and performs actions, depending on the program state
     * */
    public void mouseClicked(MouseEvent e) {
        if (waitingForStart) {
            waitingForStart = false;
            LevelMaster.racket.isGameStarted = true;
            LevelMaster.ball.gameStarted();
            remove(LevelMaster.getMenuBG());
            remove(LevelMaster.getRule());
            remove(LevelMaster.getHeader());
            remove(LevelMaster.getPressAnyKey());
            waitingForStart = false;
        } else if (objectUnderMouse != null && objectUnderMouse.equals(mainMenu.getPlayButton())) {
            mainMenu.removeFromScreen();
            levelSelection.addToScreen();
        } else if (objectUnderMouse != null && gameOver != null && objectUnderMouse.equals(gameOver.getGoToLevelSelection())) {
            removeAll();
            levelSelection.addToScreen();
        } else if (objectUnderMouse != null && gameOver != null && objectUnderMouse.equals(gameOver.getRestartLevel())) {
            removeAll();
            switch (currentLevel) {
                case 1 -> {
                    Level1 level1 = new Level1(this);
                    level1.addToScreen();
                    currentLevel = 1;
                }
                case 2 -> {
                    Level2 level2 = new Level2(this);
                    level2.addToScreen();
                    currentLevel = 2;
                }
                case 3 -> {
                    Level3 level3 = new Level3(this);
                    level3.addToScreen();
                    currentLevel = 3;
                }
                default -> System.out.println("WTF???");
            }
            waitingForStart = true;
        } else if (objectUnderMouse != null && victoryWindow != null && objectUnderMouse.equals(victoryWindow.getGoToLevelSelection())) {
            removeAll();
            levelSelection.addToScreen();
        } else if (objectUnderMouse != null && victoryWindow != null && objectUnderMouse.equals(victoryWindow.getNextLevel())) {
            switch (currentLevel) {
                case 1 -> {
                    removeAll();
                    Level2 level2 = new Level2(this);
                    level2.addToScreen();
                    currentLevel = 2;
                }
                case 2 -> {
                    removeAll();
                    Level3 level3 = new Level3(this);
                    level3.addToScreen();
                    currentLevel = 3;
                }
            }
            waitingForStart = true;
        } else if (objectUnderMouse != null && objectUnderMouse.getClass().equals(LevelButton.class)) {
            levelButton = ((LevelButton) objectUnderMouse);
            if (levelButton.isEnabled) {
                levelSelection.removeFromScreen();
                switch (Integer.parseInt(levelButton.getButtonText().getLabel())) {
                    case 1 -> {
                        Level1 level1 = new Level1(this);
                        level1.addToScreen();
                        currentLevel = 1;
                    }
                    case 2 -> {
                        Level2 level2 = new Level2(this);
                        level2.addToScreen();
                        currentLevel = 2;
                    }
                    case 3 -> {
                        Level3 level3 = new Level3(this);
                        level3.addToScreen();
                        currentLevel = 3;
                    }
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
    }
    /**
     * Reacts on the pressing of the mouse and performs actions, depending on the program state
     * */
    public void mousePressed(MouseEvent e) {
        if (objectUnderMouse != null && objectUnderMouse.equals(mainMenu.getPlayButton())) {
            mainMenu.getPlayButton().pressed();
            mainMenu.getPlayButton().isPressed = true;
        } else if (objectUnderMouse != null && gameOver != null && objectUnderMouse.equals(gameOver.getGoToLevelSelection())) {
            gameOver.getGoToLevelSelection().pressed();
            gameOver.getGoToLevelSelection().isPressed = true;
        } else if (objectUnderMouse != null && gameOver != null && objectUnderMouse.equals(gameOver.getRestartLevel())) {
            gameOver.getRestartLevel().pressed();
            gameOver.getRestartLevel().isPressed = true;
        } else if (objectUnderMouse != null && victoryWindow != null && objectUnderMouse.equals(victoryWindow.getGoToLevelSelection())) {
            victoryWindow.getGoToLevelSelection().pressed();
            victoryWindow.getGoToLevelSelection().isPressed = true;
        } else if (objectUnderMouse != null && victoryWindow != null && objectUnderMouse.equals(victoryWindow.getNextLevel())) {
            victoryWindow.getNextLevel().pressed();
            victoryWindow.getNextLevel().isPressed = true;
        } else if (objectUnderMouse != null && objectUnderMouse.equals(levelButton) && levelButton.isEnabled) {
            levelButton.pressed();
            levelButton.isPressed = true;
        }
    }
    /**
     * Reacts on the releasing of the mouse and performs actions, depending on the program state
     * */
    public void mouseReleased(MouseEvent e) {
        if (mainMenu.getPlayButton().isPressed) {
            mainMenu.getPlayButton().released();
            mainMenu.getPlayButton().isPressed = false;
        } else if (gameOver != null && gameOver.getGoToLevelSelection().isPressed) {
            gameOver.getGoToLevelSelection().released();
            gameOver.getGoToLevelSelection().isPressed = false;
        } else if (gameOver != null && gameOver.getRestartLevel().isPressed) {
            gameOver.getRestartLevel().released();
            gameOver.getRestartLevel().isPressed = false;
        } else if (victoryWindow != null && victoryWindow.getGoToLevelSelection().isPressed) {
            victoryWindow.getGoToLevelSelection().released();
            victoryWindow.getGoToLevelSelection().isPressed = false;
        } else if (victoryWindow != null && victoryWindow.getNextLevel().isPressed) {
            victoryWindow.getNextLevel().released();
            victoryWindow.getNextLevel().isPressed = false;
        } else if (levelButton != null && levelButton.isPressed) {
            levelButton.released();
            levelButton.isPressed = false;
        }
    }
}