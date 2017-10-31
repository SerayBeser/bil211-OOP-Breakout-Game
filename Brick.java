
public class Brick extends GameObject implements IsCollidable {

	private int x;
	private int y;
	private int boxLeft;
	private int boxRight;
	private int boxTop;
	private int boxBottom;
	private boolean destroyed;

	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public boolean isDesteroyed() {
		return destroyed;
	}

	@Override
	public boolean setDesteroyed() {
		return destroyed;
	}
	
	public Brick(int x , int y){
		this.x = x ;
		this.y = y;
		destroyed = false;
		
	
	}
	public Brick(){
		
	}

}
