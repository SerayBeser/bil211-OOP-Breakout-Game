import java.awt.Image;
import java.awt.Toolkit;


public class BorderBrick extends Brick{
	Image borderBrickImage = Toolkit.getDefaultToolkit().getImage("brick_border.png");

	public BorderBrick(int x, int y) {
		super(x, y);
	}
	
	public BorderBrick() {
	
	}
}