import acm.graphics.GImage;
import acm.graphics.GLabel;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;

import java.awt.*;
/**
 * Represents a superclass that manages the game screen and its components for different levels.
 * Extends ScreenParent class.
 */
public class LevelMaster extends ScreenParent {
    // Fields for game components
    public double radius;
    public GImage bg;
    public GRect bar;
    public static Ball ball;
    public static Racket racket;
    public static Brick brick;
    public static Heart life1;
    public static Heart life2;
    public static Heart life3;

    public static GRect menuBG;
    public static GLabel header;
    public static GLabel rule;
    public static GLabel pressAnyKey;
    public final Color halfTransparent = new Color(0, 0, 0, 101);
    public static Score score;
    // Fields for brick layout
    public int BRICK_NUMBER_X;
    public int BRICK_NUMBER_Y;
    public double BRICK_WIDTH;
    public double BRICK_HEIGHT;

    public static int bricksLeft = 0;
    /**
     * Constructs a LevelMaster object.
     *
     * @param program The graphics program that called this method.
     */
    public LevelMaster(GraphicsProgram program) {
        super(program);
        this.radius = Main.BALL_RADIUS;
    }
    /**
     * Initializes the game components for the level.
     *
     * @param bgImage The file path of the background image.
     */
    public void initialize(String bgImage) {
        // Initialize background and bar
        bg = new GImage(bgImage);
        bg.setSize(program.getWidth(), program.getHeight());
        bar = new GRect(0, 0, sizeX, 49);
        bar.setFilled(true);
// Initialize game components
        racket = new Racket(program, "assets/board.png", sizeX / 2.0, sizeY * 0.9);
        Main.racket = racket;
        ball = new Ball(program, racket.getX() + racket.getWidth() / 2.0, racket.getY() - radius - 3, radius, Color.CYAN);
        Main.ball = ball;
        life1 = new Heart(program, 25.0, 25.0, 50.0, 50.0, "assets/heart1.gif");
        life2 = new Heart(program, 75.0, 25.0, 50.0, 50.0, "assets/heart3.gif");
        life3 = new Heart(program, 125.0, 25.0, 50.0, 50.0, "assets/heart2.gif");
        score = new Score(program);
// Initialize menu components
        menuBG = new GRect(Main.MAX_X * 0.25, 50 + (Main.MAX_Y - 50) * 0.3, Main.MAX_X * 0.5, (Main.MAX_Y - 50) * 0.4);
        menuBG.setFilled(true);
        menuBG.setColor(halfTransparent);

        header = new GLabel("Rules");
        header.setFont(cyberFont.deriveFont(44f));
        // ... Initialize other labels

        // Set label positions
        header.setLocation(menuBG.getX() + menuBG.getWidth() / 2.0 - header.getWidth() / 2, menuBG.getY()+ menuBG.getHeight()*0.5 - header.getHeight());
        header.setColor(Color.yellow);

        rule = new GLabel("Use your mouse to move board");
        rule.setFont("italic-24");
        rule.setLocation(menuBG.getX() + menuBG.getWidth() / 2.0 - rule.getWidth() / 2, header.getY() + header.getHeight()*1.5);
        rule.setColor(Color.red);

        pressAnyKey = new GLabel("Press MB to continue");
        pressAnyKey.setFont("italic-20");
        pressAnyKey.setLocation(menuBG.getX() + menuBG.getWidth() / 2.0 - pressAnyKey.getWidth() / 2, rule.getY() + rule.getHeight()*1.5);
        pressAnyKey.setColor(Color.white);
    }
    /**
     * Adds bricks for the level.
     */
    public void addBricks() {
    }
    /**
     * Adds the game components to the screen.
     */
    @Override
    public void addToScreen() {
        program.add(bg);
        program.add(bar);
        racket.show();
        addBricks();
        ball.show();
        life1.show();
        life2.show();
        life3.show();
        score.add();
        addRules();
    }
    /**
     * Adds the rules section to the screen.
     */
    public void addRules() {
        program.add(menuBG);
        program.add(header);
        program.add(rule);
        program.add(pressAnyKey);
    }
    /**
     * Hides the rules section from the screen.
     */
    public void hideRules() {
        program.remove(menuBG);
        program.remove(header);
        program.remove(rule);
        program.remove(pressAnyKey);
    }
    /**
     * Retrieves the menu background.
     *
     * @return The menu background rectangle.
     */
    public static GRect getMenuBG() {
        return menuBG;
    }

    public static GLabel getHeader() {
        return header;
    }

    public static GLabel getRule() {
        return rule;
    }

    public static GLabel getPressAnyKey() {
        return pressAnyKey;
    }
// Other getter methods for labels

    /**
     * Removes the game components from the screen.
     */
    @Override
    public void removeFromScreen() {
        program.remove(bg);
        program.remove(bar);
        racket.hide();
        ball.hide();
        life1.hide();
        life2.hide();
        life3.hide();

        hideRules();
    }
}
