
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class User {
	
	private String name;
	private BufferedImage bi;
	Point point = new Point(); 
	public User() {
		name = "";
	}
	public User(String name)
	{
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public BufferedImage display() throws IOException {
		BufferedImage combined = new BufferedImage(12*(name.length()),17,BufferedImage.TYPE_INT_ARGB);
		Graphics g = combined.getGraphics();
		
		String path = "/home/vinerra/Desktop/Workspace/Proje";
		int x = 0;
		for(int i = 0 ; i < name.length() ; i++)
		{
			if(name.charAt(i) == ' ')
				continue;
			BufferedImage image = null;
			image = ImageIO.read(new File(path, ""+name.charAt(i) +".png"));
			g.drawImage(image, x, 0, null);
			x+=12;
		}
		ImageIO.write(combined, "PNG", new File(path, "user.png"));
		
		
		return combined;
		
	}
	
	

}