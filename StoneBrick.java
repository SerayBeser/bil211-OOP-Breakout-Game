import java.awt.Image;
import java.awt.Toolkit;

public class StoneBrick extends Brick {


	Image stoneBrickImage1 = Toolkit.getDefaultToolkit().getImage("brick_stone_1.png");
	Image stoneBrickImage2 = Toolkit.getDefaultToolkit().getImage("brick_stone_2.png");
	public StoneBrick() {

	}
	public StoneBrick(int x, int y) {
		super(x, y);
	}


}