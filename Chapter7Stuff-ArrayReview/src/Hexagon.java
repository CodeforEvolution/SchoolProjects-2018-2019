import java.awt.Color;
import java.awt.Point;


public class Hexagon extends MoverPainter {
	Canvas drawPlace;
	boolean convex;
	int scale;
	
	final int HEX_SIZE = 6;

	public Hexagon(Canvas surface, Point center, int theSize, boolean isConvex)
	{
		drawPlace = surface;
		currentPos = center;
		convex = isConvex;
		scale = theSize;
		
		draw(currentPos);
	}
	
	protected void draw(Point where)
	{
		drawPlace.drawFilledPolygon(createXs(where), createYs(where), HEX_SIZE);
	}
	
	protected void erase(Point where)
	{
		Color old = drawPlace.getInkColor();
		
		drawPlace.setInkColor(drawPlace.getBackgroundColor());
		drawPlace.drawFilledPolygon(createXs(where), createYs(where), HEX_SIZE);
		
		drawPlace.setInkColor(old);
	}
	
	private int[] createXs(Point where)
	{
		int xPoints[] = new int[6];
		
		if (convex == true)
		{
			xPoints[0] = where.x - (2 * scale);
			xPoints[1] = where.x - (1 * scale);
			xPoints[2] = where.x + (1 * scale);
			xPoints[3] = where.x + (2 * scale);
			xPoints[4] = where.x + (1 * scale);
			xPoints[5] = where.x - (1 * scale);
		}
		else
		{
			xPoints[0] = where.x - (2 * scale);
			xPoints[1] = where.x - (1 * scale);
			xPoints[2] = where.x + (1 * scale);
			xPoints[3] = where.x + (2 * scale);
			xPoints[4] = where.x + (1 * scale);
			xPoints[5] = where.x - (1 * scale);
		}
		
		for (int i = 0; i < 6; i++)
		{
			xPoints[i] *= scale;
		}
		
		return xPoints;
	}
	
	private int[] createYs(Point where)
	{
		int yPoints[] = new int[6];
		
		int centerOff = 5 * scale;
		
		if (convex == true)
		{
			yPoints[0] = where.y;
			yPoints[1] = where.y - centerOff;
			yPoints[2] = where.y - centerOff;
			yPoints[3] = where.y;
			yPoints[4] = where.y + centerOff;
			yPoints[5] = where.y + centerOff;
		}
		else
		{
			yPoints[0] = where.y;
			yPoints[1] = where.y - centerOff;
			yPoints[2] = where.y - centerOff;
			yPoints[3] = where.y;
			yPoints[4] = where.y + centerOff;
			yPoints[5] = where.y + centerOff;
		}
		
		return yPoints;
	}
	
}
