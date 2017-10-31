import java.awt.Image;
import java.awt.Toolkit;

public class LargePaddle extends Paddle{
	
	Image largePaddleImage = Toolkit.getDefaultToolkit().getImage("paddle_large.png");
	private int largePaddleWidth = 192;
	public int getLargePaddleWidth() {
		return largePaddleWidth;
	}
	public void setLargePaddleWidth(int largePaddleWidth) {
		this.largePaddleWidth = largePaddleWidth;
	}



}
