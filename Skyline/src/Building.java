import java.awt.Color;
import java.util.Random;


public class Building {
	private static Random r = new Random();

	private int height;
	private int width;
	private Color color;
	private int pixFromLeft;
	
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
	
	public void draw(Canvas theSurface, int canvasHeight)
	{
		Color old = theSurface.getInkColor();
		
		theSurface.setInkColor(color);
		theSurface.drawFilledRectangle(pixFromLeft, canvasHeight - height, width, height);
		
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
