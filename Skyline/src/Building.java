import java.awt.Color;
import java.util.Random;


public class Building {
	private static Random r = new Random();

	private int height;
	private int width;
	private Color color;
	private int pixFromLeft;
	
	public final int WINDOW_SIZE = 20;
	
	public Building()
	{
		height = 0;
		width = 0;
		color = Color.BLACK;
		pixFromLeft = 0;
	}
	
	public Building(int theHeight, int theWidth, Color theColor)
	{
		height = theHeight;
		width = theWidth;
		color = theColor;
	}
	
	public void setHeight(int newHeight)
	{
		height = newHeight;
	}
	
	public void setWidth(int newWidth)
	{
		width = newWidth;
	}
	
	public void setColor(Color newColor)
	{
		color = newColor;
	}
	
	public void setHorizontalLocation(int newPixLeft)
	{
		pixFromLeft = newPixLeft;
	}
	
	public void draw(Canvas theSurface, int canvasHeight, boolean windows)
	{
		Color old = theSurface.getInkColor();
		
		theSurface.setInkColor(color);
		theSurface.drawFilledRectangle(pixFromLeft, canvasHeight - height, width, height);
		theSurface.setInkColor(new Color(color.getRed(), color.getGreen(), color.getBlue(), 255));
		theSurface.drawRectangle(pixFromLeft, canvasHeight - height, width, height);
		
		if (windows == true)
		{
			int numWide = (int)Math.floor((width * 0.5) / WINDOW_SIZE);
			int numHeight = (int)Math.floor((height * 0.5) / WINDOW_SIZE);
			
			for (int x = 1; x < numWide; x++)
			{
				for (int y = 1; y < numHeight; y++)
				{
					int posX = pixFromLeft + 2 * (WINDOW_SIZE * x);
					int posY = (canvasHeight - height) + 2 * (WINDOW_SIZE * y);
					theSurface.setInkColor(new Color(255, 255, 255, 50));
					theSurface.drawFilledRectangle(posX, posY, WINDOW_SIZE, WINDOW_SIZE);
					theSurface.setInkColor(new Color(color.getRed(), color.getGreen(), color.getBlue(), 255));
					theSurface.drawRectangle(posX, posY, WINDOW_SIZE, WINDOW_SIZE);
				}
			}
		}
		
		theSurface.setInkColor(old);
		return;
	}
	
	public void setHeightRandom(int maxH)
	{
		height = r.nextInt(maxH + 1);
	}
	
	public void setWidthRandom(int maxW)
	{
		width = r.nextInt(maxW + 1);
	}
	
	public void setLocationRandom(int maxLeftDist)
	{
		pixFromLeft = r.nextInt(maxLeftDist + 1);
	}
	
	public void setColorRandom()
	{
		int theR = r.nextInt(256);
		int theG = r.nextInt(256);
		int theB = r.nextInt(256);
		int theA = r.nextInt(256);
		
		color = new Color(theR, theG, theB, theA);
		
		return;
	}
	
	public int area()
	{
		return width * height;
	}
}
