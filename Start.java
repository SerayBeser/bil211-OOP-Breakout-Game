import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Start extends GameObject implements ActionListener, KeyListener {
	private boolean rightKeyPressed = false;
	private boolean leftKeyPressed = false;
	public boolean topkacti = false;
	private boolean startpressed = false;
	private int winCounter = 0;
	Random rand = new Random();
	User user = new User("utku");
	private boolean oT = true;

	public Start() {
		setBackground(Color.BLUE);
		setFocusable(true);
		addKeyListener(this);

		// 60 fps
		Timer timer = new Timer(1000 / 120, this);
		timer.start();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		init();
	}

	Ball ball = new Ball();
	NormalPaddle paddleNormal = new NormalPaddle();
	LargePaddle largepaddle = new LargePaddle();
	JumpyPaddle jumpypaddle = new JumpyPaddle();
	boolean random;
	boolean largePaddle = false;
	boolean jumpyPaddle = false;
	boolean normalPaddle = true;
	Image img;
	int paddleWidth = 128;
	BrickLoader bl = new BrickLoader();
	ArrayList<Integer> a1 = new ArrayList<Integer>();
	ArrayList<Integer> a2 = new ArrayList<Integer>();

	public void init() {
		ball.setNextBallLeft(ball.getBallX() + ball.getBallDeltaX());
		ball.setNextBallRight(ball.getBallX() + ball.getDiameter() + ball.getBallDeltaX());
		ball.setNextBallTop(ball.getBallY() + ball.getBallDeltaY());
		ball.setNextBallBottom(ball.getBallY() + ball.getDiameter() + ball.getBallDeltaY());
		brickoku();

		if (startpressed == true && oT == true) {
			ball.setBallDeltaX(-1);
			ball.setBallDeltaY(-1);
			oT = false;
		}

		// Ball Movements
		boolean val;
		if (ball.getNextBallTop() < 24) {
			if (val = rand.nextInt(2) == 0) {
				ball.setBallDeltaY(ball.getBallDeltaY() * (-1));

			} else {
				ball.setBallDeltaY(ball.getBallDeltaY() * (-1));
				ball.setBallDeltaX(ball.getBallDeltaX() * (-1));
			}

		}
		if (ball.getNextBallLeft() <= 24) {
			if (val = rand.nextInt(2) == 0) {
				ball.setBallDeltaX(ball.getBallDeltaX() * (-1));
			} else {
				ball.setBallDeltaY(ball.getBallDeltaY() * (-1));
				ball.setBallDeltaX(ball.getBallDeltaX() * (-1));
			}
		}

		if (ball.getNextBallRight() > 600) {
			if (val = rand.nextInt(2) == 0) {
				ball.setBallDeltaX(ball.getBallDeltaX() * (-1));
			} else {
				ball.setBallDeltaY(ball.getBallDeltaY() * (-1));
				ball.setBallDeltaX(ball.getBallDeltaX() * (-1));
			}

		}
		ball.setBallX(ball.getBallX() + ball.getBallDeltaX());
		ball.setBallY(ball.getBallY() + ball.getBallDeltaY());

		// PaddleMovements
		if (rightKeyPressed && paddleNormal.getPaddleX() + paddleWidth < 630 && startpressed == true) {
			paddleNormal.setPaddleX(paddleNormal.getPaddleX() + paddleNormal.getPaddleSpeed());
		}
		if (topkacti == true) {
			Paddle.PADDLESPEED = 0;
			paddleNormal.setPaddleSpeed(0);

		}
		if (leftKeyPressed && paddleNormal.getPaddleX() > 0 && startpressed == true) {
			paddleNormal.setPaddleX(paddleNormal.getPaddleX() - paddleNormal.getPaddleSpeed());
		}

		// Ball collision with Paddle
		if (ball.getNextBallBottom() > paddleNormal.getPaddleY() && ball.getNextBallRight() > paddleNormal.getPaddleX()
				&& ball.getNextBallLeft() < paddleNormal.getPaddleX() + paddleWidth) {
			if (jumpyPaddle == true) {
				normalPaddle = true;
				jumpyPaddle = false;

			} else {

				if (random = rand.nextInt(10) == 0
						&& (paddleWidth == 128 || paddleWidth == largepaddle.getLargePaddleWidth())) {
					jumpyPaddle = true;
					largePaddle = false;
					normalPaddle = false;

				}

				else if (random = rand.nextInt(10) == 0 && jumpyPaddle == false) {
					largePaddle = true;
					normalPaddle = false;
					jumpyPaddle = false;

				}
			}
			int ballDY = ball.getBallDeltaY();
			ball.setBallDeltaY(ballDY *= -1);

		}
		if (ball.getNextBallBottom() > 430) {
			topkacti = true;
		}

		if (normalPaddle == true) {
			paddleWidth = paddleNormal.getNormalPaddleWidth();
			img = paddleNormal.normalPaddleImage;

		}
		if (largePaddle == true) {
			paddleWidth = largepaddle.getLargePaddleWidth();
			img = largepaddle.largePaddleImage;

		}
		if (jumpyPaddle == true) {
			paddleWidth = jumpypaddle.getJumpyPaddleWidth();
			img = jumpypaddle.jumpyPaddleImage;
			jumpPadSpeed();

		}

		repaint();

	}

	boolean init2 = true;

	public void brickoku() {
		if (init2 == true)
			bl.readAndFill("bricks.txt");
		init2 = false;

	}

	boolean init = true;

	public void jumpPadSpeed() {

		if (init == true) {
			if (ball.getBallDeltaX() > 0) {
				ball.setBallDeltaX(ball.getBallDeltaX() + 1);
			}
			if (ball.getBallDeltaX() < 0) {
				ball.setBallDeltaX(ball.getBallDeltaX() - 1);
			}
			if (ball.getBallDeltaY() > 0) {
				ball.setBallDeltaY(ball.getBallDeltaY() + 1);
			}
			if (ball.getBallDeltaY() < 0) {
				ball.setBallDeltaY(ball.getBallDeltaY() - 1);
			}
			init = false;
		}

	}

	static int stoneCount = 0;

	public void paintComponent(Graphics g) {
		// BorderBrickOlustur,
		super.paintComponent(g);
		GemBrick gembrick = new GemBrick();
		BorderBrick borderbrick = new BorderBrick();
		NormalBrick normalbrick = new NormalBrick();
		StoneBrick stonebrick = new StoneBrick();
		GlassBrick glassbrick = new GlassBrick();

		if (topkacti == true) {
			Display d = new Display();

			try {
				g.drawImage(d.displayGameOver(), 250, 200, this);
				ball.setBallDeltaX(0);
				ball.setBallDeltaY(0);
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

		try {
			g.drawImage(user.point.display(), 550, 450, this);
			g.drawImage(user.display(), 50, 450, this);
		} catch (IOException e) {
			e.printStackTrace();
		}

		int x = 0, y = 0;

		// tüm brickler okunuyor
		boolean val2;

		for (int i = 0; i < bl.getBrickArray().size()-1; i++) {
			if (bl.getBrickArray().get(i) instanceof NormalBrick) {
				x = bl.getBrickArray().get(i).getX();
				y = bl.getBrickArray().get(i).getY();

				int NormalBrickTop = y;
				int NormalBrickBottom = y + 24;
				int NormalBrickLeft = x;
				int NormalBrickRight = x + 72;

				if (ball.getNextBallTop() < NormalBrickBottom && ball.getNextBallBottom() > NormalBrickTop
						&& ball.getNextBallLeft() < NormalBrickRight && ball.getNextBallRight() > NormalBrickLeft) {
					user.point.addScore(5);
					bl.getBrickArray().remove(i);
					if (val2 = rand.nextInt(2) == 0) {
						ball.setBallDeltaX(ball.getBallDeltaX() * (-1));
					} else {
						ball.setBallDeltaY(ball.getBallDeltaY() * (-1));
						ball.setBallDeltaX(ball.getBallDeltaX() * (-1));
					}

				} else
					g.drawImage(normalbrick.normalBrickImage, x, y, this);

			}

			if (bl.getBrickArray().get(i) instanceof StoneBrick) {
				x = bl.getBrickArray().get(i).getX();
				y = bl.getBrickArray().get(i).getY();

				int StoneBrickTop = y;
				int StoneBrickBottom = y + 24;
				int StoneBrickLeft = x;
				int StoneBrickRight = x + 72;

				if (ball.getNextBallTop() < StoneBrickBottom && ball.getNextBallBottom() > StoneBrickTop
						&& ball.getNextBallLeft() < StoneBrickRight && ball.getNextBallRight() > StoneBrickLeft) {
					user.point.addScore(5);
					a1.add(x);
					a2.add(y);
					bl.getBrickArray().remove(i);
					// bl.getBrickArray().add(new BrokenBrick(x, y));
					if (val2 = rand.nextInt(2) == 0) {
						ball.setBallDeltaX(ball.getBallDeltaX() * (-1));
					} else {
						ball.setBallDeltaY(ball.getBallDeltaY() * (-1));
						ball.setBallDeltaX(ball.getBallDeltaX() * (-1));
					}

				} else
					g.drawImage(stonebrick.stoneBrickImage1, x, y, this);

			}
			for (int k = 0; k < a1.size(); k++) {
				int BrokenBrickTop = a2.get(k);
				int BrokenBrickBottom = a2.get(k) + 24;
				int BrokenBrickLeft = a1.get(k);
				int BrokenBrickRight = a1.get(k) + 72;
				g.drawImage(stonebrick.stoneBrickImage2, a1.get(k), a2.get(k), this);
				

				

				

			}

			/*
			 * boolean val4; if (bl.getBrickArray().get(i) instanceof
			 * BrokenBrick) { x = bl.getBrickArray().get(i).getX(); y =
			 * bl.getBrickArray().get(i).getY(); int BrokenBrickTop = y; int
			 * BrokenBrickBottom = y + 24; int BrokenBrickLeft = x; int
			 * BrokenBrickRight = x + 72; if (ball.getNextBallTop() <
			 * BrokenBrickBottom && ball.getNextBallBottom() > BrokenBrickTop &&
			 * ball.getNextBallLeft() < BrokenBrickRight &&
			 * ball.getNextBallRight() > BrokenBrickLeft) { stoneCount = 0;
			 * bl.getBrickArray().remove(i); bl.getBrickArray().add(new
			 * BrokenBrick(x, y)); if (val4 = rand.nextInt(2) == 0) {
			 * ball.setBallDeltaX(ball.getBallDeltaX() * (-1)); } else {
			 * ball.setBallDeltaY(ball.getBallDeltaY() * (-1));
			 * ball.setBallDeltaX(ball.getBallDeltaX() * (-1)); } } else
			 * g.drawImage(stonebrick.stoneBrickImage2, x, y, this);
			 * 
			 * }
			 */

			if (bl.getBrickArray().get(i) instanceof GemBrick) {
				x = bl.getBrickArray().get(i).getX();
				y = bl.getBrickArray().get(i).getY();

				int GemBrickTop = y;
				int GemBrickBottom = y + 24;
				int GemBrickLeft = x;
				int GemBrickRight = x + 72;

				if (ball.getNextBallTop() < GemBrickBottom && ball.getNextBallBottom() > GemBrickTop
						&& ball.getNextBallLeft() < GemBrickRight && ball.getNextBallRight() > GemBrickLeft) {
					user.point.addScore(10);

					bl.getBrickArray().remove(i);
					if (val2 = rand.nextInt(2) == 0) {
						ball.setBallDeltaX(ball.getBallDeltaX() * (-1));
					} else {
						ball.setBallDeltaY(ball.getBallDeltaY() * (-1));
						ball.setBallDeltaX(ball.getBallDeltaX() * (-1));
					}

				} else
					g.drawImage(gembrick.gemBrickImage, x, y, this);

			}

			if (bl.getBrickArray().get(i) instanceof GlassBrick) {
				x = bl.getBrickArray().get(i).getX();
				y = bl.getBrickArray().get(i).getY();

				int GlassBrickTop = y;
				int GlassBrickBottom = y + 24;
				int GlassBrickLeft = x;
				int GlassBrickRight = x + 72;

				if (ball.getNextBallTop() < GlassBrickBottom && ball.getNextBallBottom() > GlassBrickTop
						&& ball.getNextBallLeft() < GlassBrickRight && ball.getNextBallRight() > GlassBrickLeft) {
					user.point.addScore(5);
					bl.getBrickArray().remove(i);

				} else
					g.drawImage(glassbrick.glassBrickImage, x, y, this);

			}

			if (bl.getBrickArray().get(i) instanceof BorderBrick) {
				x = bl.getBrickArray().get(i).getX();
				y = bl.getBrickArray().get(i).getY();
				g.drawImage(borderbrick.borderBrickImage, x, y, this);

			}

		}

		// Ballu ciz
		g.drawImage(ball.img5, ball.getBallX(), ball.getBallY(), this);
		// Paddle i ciz
		g.drawImage(img, paddleNormal.getPaddleX(), paddleNormal.getPaddleY(), this);

	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_LEFT) {
			leftKeyPressed = true;

		}

		if (key == KeyEvent.VK_RIGHT) {
			rightKeyPressed = true;
		}
		if (key == KeyEvent.VK_UP) {
			startpressed = true;
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_LEFT) {
			leftKeyPressed = false;

		}

		if (key == KeyEvent.VK_RIGHT) {
			rightKeyPressed = false;

		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
	}

}
