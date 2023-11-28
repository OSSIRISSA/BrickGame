import acm.graphics.GImage;
import acm.program.GraphicsProgram;
import acm.util.SoundClip;

public class MiddleBrick extends Brick {
    private final GImage crack;
    public MiddleBrick(GraphicsProgram program, double x, double y, double width, double height) {
        super(program, x, y, width, height, "assets/middleBrick.png");
        this.hardness = Hardness.MIDDLE;
        crack = new GImage("assets/light-crack.png", x, y);
        crack.setSize(width, height);
    }

    public void breakIt() {
        Crack = new SoundClip("assets/Crack.au");
        Crack.setVolume(1);
        Crack.play();
        if (this.hardness != Hardness.WEAK) {

                this.hardness = Hardness.WEAK;
                crack.setImage("assets/hard-crack.png");
                crack.setSize(this.getWidth(), this.getHeight());
                program.add(crack);
                program.add(this);

        } else {
            hide();
            LevelMaster.score.updateScore(this);
            program.remove(crack);
            this.IsBroken = true;
        }
    }

    @Override
    public void hide() {
        super.hide();
    }

    @Override
    public void show() {
        super.show();
    }
}