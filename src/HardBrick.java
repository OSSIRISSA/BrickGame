import acm.graphics.GImage;
import acm.program.GraphicsProgram;
import acm.util.SoundClip;

public class HardBrick extends Brick{
    private GImage crack;
    public HardBrick(GraphicsProgram program, double x, double y, double width, double height) {
        super(program, x, y, width, height, "assets/hardBrick.png");
        this.hardness=Hardness.HARD;
    }
    public void breakIt() {
        Crack = new SoundClip("assets/Crack.au");
        Crack.setVolume(1);
        Crack.play();
        if (this.hardness != Hardness.WEAK) {
            if (this.hardness != Hardness.MIDDLE) {
                this.hardness = Hardness.MIDDLE;
                crack = new GImage("assets/light-crack.png", this.getX(), this.getY());
                crack.setSize(this.getWidth(), this.getHeight());
                program.add(crack);
                program.add(this);
            } else {
                this.hardness = Hardness.WEAK;
                crack.setImage("assets/hard-crack.png");
                crack.setSize(this.getWidth(), this.getHeight());
            }
        } else {
            hide();
            LevelMaster.score.updateScore(this);
            program.remove(crack);
            this.IsBroken = true;
        }
    }

    @Override
    public void show() {
        super.show();
    }

    @Override
    public void hide() {
        super.hide();
    }
}
