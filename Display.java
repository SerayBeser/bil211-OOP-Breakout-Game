import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Display {
	
	public BufferedImage displayGameOver() throws IOException {
		BufferedImage combined = new BufferedImage(96,17,BufferedImage.TYPE_INT_ARGB);
		Graphics g = combined.getGraphics();
		
		String path = "/home/vinerra/Desktop/Workspace/Proje";
		int x = 0;
		for(int i = 0 ; i < "game over".length() ; i++)
		{
			if("game over".charAt(i) == ' ')
				continue;
			BufferedImage image = null;
			image = ImageIO.read(new File(path, ""+"game over".charAt(i) +".png"));
			g.drawImage(image, x, 0, null);
			x+=12;
		}
		
		ImageIO.write(combined, "PNG", new File(path, "user.png"));
		
		
		return combined;
		
	}
	
	public BufferedImage displayYouWin() throws IOException {
		BufferedImage combined = new BufferedImage(72,17,BufferedImage.TYPE_INT_ARGB);
		Graphics g = combined.getGraphics();
		
		String path = "/home/vinerra/Desktop/Workspace/Proje";
		int x = 0;
		for(int i = 0 ; i < "you win".length() ; i++)
		{
			if("you win".charAt(i) == ' ')
				continue;
			BufferedImage image = null;
			image = ImageIO.read(new File(path, ""+"you win".charAt(i) +".png"));
			g.drawImage(image, x, 0, null);
			x+=12;
		}
		
		ImageIO.write(combined, "PNG", new File(path, "you win.png"));
		
		
		return combined;
		
	}

}