import java.awt.Point;


public class Hexagon extends MoverPainter {
	Canvas drawPlace;
	boolean concave;
	
	final int HEX_SIZE = 10;

	public Hexagon(Canvas surface, Point center, boolean isConcave)
	{
		drawPlace = surface;
		currentPos = center;
		concave = isConcave;
	}
	
	protected void draw(Point where)
	{
		drawPlace.drawFilledPolygon(createXs(), createYs(), HEX_SIZE);
	}
	
	protected void erase(Point where)
	{
		
	}
	
	private int[] createXs()
	{
		int xPoints[] = new int[6];
		
		if (concave == true)
		{
			
		}
		else
		{
			
		}
		
		return xPoints;
	}
	
	private int[] createYs()
	{
		int yPoints[] = new int[6];
		
		if (concave == true)
		{
			
		}
		else
		{
			
		}
		
		return yPoints;
	}
	
}
