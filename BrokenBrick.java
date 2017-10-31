import java.awt.Image;
import java.awt.Toolkit;

public class BrokenBrick extends Brick {
	Image brokenBrickImage2 = Toolkit.getDefaultToolkit().getImage("brick_stone_2.png");

	public BrokenBrick(int x, int y) {
		super(x, y);
	}

	public BrokenBrick() {

	}
}
