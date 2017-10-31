
import java.awt.Image;
import java.awt.Toolkit;

public class NormalBrick extends Brick {

	Image normalBrickImage = Toolkit.getDefaultToolkit().getImage("brick_normal.png");

	public NormalBrick() {

	}

	public NormalBrick(int x, int y) {
		super(x, y);

	}

}
