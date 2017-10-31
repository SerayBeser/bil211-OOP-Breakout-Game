
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Point {
	
	private String score;
	
	public Point() {
		score = "0";
	}

	public String getScore() {
		return score;
	}

	public void addScore(int score) {
		this.score = "" + (Integer.parseInt(getScore()) + score);
	}
	
	public BufferedImage display() throws IOException {
		BufferedImage combined = new BufferedImage(12*(score.length()),17,BufferedImage.TYPE_INT_ARGB);
		Graphics g = combined.getGraphics();
		
		String path = "/home/vinerra/Desktop/Workspace/Proje";
		int x = 0;
		for(int i = 0 ; i < score.length() ; i++)
		{
			if(score.charAt(i) == ' ')
				continue;
			BufferedImage image = null;
			image = ImageIO.read(new File(path, ""+score.charAt(i) +".png"));
			g.drawImage(image, x, 0, null);
			x+=12;
		}
		ImageIO.write(combined, "PNG", new File(path, "score.png"));
		
		
		return combined;
		
	}
	
}