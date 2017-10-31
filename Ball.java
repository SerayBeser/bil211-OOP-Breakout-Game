import java.awt.Image;
import java.awt.Toolkit;



public class Ball extends GameObject {
	private int ballX = 305;

	public int getBallX() {
		return ballX;
	}

	public void setBallX(int ballX) {
		this.ballX = ballX;
	}

	public int getBallY() {
		return ballY;
	}

	public void setBallY(int ballY) {
		this.ballY = ballY;
	}

	public int getDiameter() {
		return diameter;
	}

	public void setDiameter(int diameter) {
		this.diameter = diameter;
	}

	public int getBallDeltaX() {
		return ballDeltaX;
	}

	public void setBallDeltaX(int ballDeltaX) {
		this.ballDeltaX = ballDeltaX;
	}

	public int getBallDeltaY() {
		return ballDeltaY;
	}

	public void setBallDeltaY(int ballDeltaY) {
		this.ballDeltaY = ballDeltaY;
	}

	private int ballY = 385;
	private int diameter = 22;
	private int ballDeltaX = 0; // baslangic degerleri topun ilk hareketi
									// icin
	private int ballDeltaY = 0; // baslangic degerleri topun ilk
									// hareketi icin

	int nextBallLeft = ballX + ballDeltaX;
	int nextBallRight = ballX + diameter + ballDeltaX;
	int nextBallTop = ballY + ballDeltaY;
	int nextBallBottom = ballY + diameter + ballDeltaY;

	public int getNextBallLeft() {
		return nextBallLeft;
	}

	public void setNextBallLeft(int nextBallLeft) {
		this.nextBallLeft = nextBallLeft;
	}

	public int getNextBallRight() {
		return nextBallRight;
	}

	public void setNextBallRight(int nextBallRight) {
		this.nextBallRight = nextBallRight;
	}

	public int getNextBallTop() {
		return nextBallTop;
	}

	public void setNextBallTop(int nextBallTop) {
		this.nextBallTop = nextBallTop;
	}

	public int getNextBallBottom() {
		return nextBallBottom;
	}

	public void setNextBallBottom(int nextBallBottom) {
		this.nextBallBottom = nextBallBottom;
	}

	Image img5 = Toolkit.getDefaultToolkit().getImage("ball.png");

	public Ball() {

	}

}
