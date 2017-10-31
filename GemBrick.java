import java.awt.Image;
import java.awt.Toolkit;

public class GemBrick extends Brick {
	Image gemBrickImage = Toolkit.getDefaultToolkit().getImage("brick_gem.png");

	public GemBrick(int x, int y) {
		super(x, y);
	}

	public GemBrick() {

	}
}
