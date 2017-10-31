import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Timer;

public class NormalPaddle extends Paddle{
	Image normalPaddleImage = Toolkit.getDefaultToolkit().getImage("paddle_normal.png");
	private  int paddleX = 250;
	private  int paddleY = 410 ; 
	public int getNormalPaddleWidth() {
		return normalPaddleWidth;
	}
	public void setNormalPaddleWidth(int normalPaddleWidth) {
		this.normalPaddleWidth = normalPaddleWidth;
	}
	private int normalPaddleWidth = 142;
	private  int paddleSpeed = 5 ;
	public int getPaddleX() {
		return paddleX;
	}
	public int getPaddleSpeed() {
		return paddleSpeed;
	}
	public void setPaddleSpeed(int paddleSpeed) {
		this.paddleSpeed = paddleSpeed;
	}
	public void setPaddleX(int paddleX) {
		this.paddleX = paddleX;
	}
	public int getPaddleY() {
		return paddleY;
	}
	public void setPaddleY(int paddleY) {
		this.paddleY = paddleY;
	}
	public NormalPaddle() {
      
	}
	
	
	


}
