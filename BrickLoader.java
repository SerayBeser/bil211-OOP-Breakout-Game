
import java.util.*;
import java.io.*;

public class BrickLoader {

	private ArrayList<Brick> bricks;
	
	
	public ArrayList<Brick> getBrickArray() {
		return bricks;
		
	}
	
	public BrickLoader() {
		bricks = new ArrayList<Brick>();

	}
	
	
	public void readAndFill(String path)
	{
		Scanner fileStream = null;
		try 
		{
			
			fileStream = new Scanner(new File(path));
			
			while(fileStream.hasNextLine())
			{
				String[] line = fileStream.nextLine().split(",");
				int x = Integer.parseInt(line[0]);
				int y = Integer.parseInt(line[1]);
				switch(Integer.parseInt(line[2]))
				{
					case(0) : 
						bricks.add(new NormalBrick(x,y));
						break;	
					case(1) : 
						bricks.add(new StoneBrick(x,y));
						break;
					case(2) : 
						bricks.add(new GemBrick(x,y));
						break;
					case(3) : 
						bricks.add(new GlassBrick(x,y));
						break;
					case(4) : 
						bricks.add(new BorderBrick(x,y));
						break;
					
						
				}
				
			}
			fileStream.close();
		} 
		catch(FileNotFoundException e)
		{
			System.out.println("File Not Found in Brickloader Class");
		}
		catch (Exception e) {
			System.out.println("Exception in BrickLoader Class");
		}
	
		
	}
	
	
	
	
	
	
	
	

}