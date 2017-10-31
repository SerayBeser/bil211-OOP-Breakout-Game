import java.awt.Image;
import java.awt.Toolkit;

public class JumpyPaddle extends Paddle {
	private int jumpyPaddleWidth = 128;
	Image jumpyPaddleImage = Toolkit.getDefaultToolkit().getImage("paddle_jumpy.png");
	public int getJumpyPaddleWidth() {
		return jumpyPaddleWidth;
	}
	public void setJumpyPaddleWidth(int jumpyPaddleWidth) {
		this.jumpyPaddleWidth = jumpyPaddleWidth;
	}



}
