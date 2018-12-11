package VehicleGraphics;
import java.awt.Color;
import java.awt.Point;

public abstract class Vehicle {
	public static final int DELAY = 10;
	protected Point currentPos;
	protected Canvas whereToDraw;
	protected Color myColor;
	
	protected Vehicle(Point initialPos, Canvas drawPlace, Color theColor)
	{
		currentPos = initialPos;
		myColor = theColor;
		whereToDraw = drawPlace;
		draw(initialPos);
	}
	
	public void moveTo(Point where)
	{
		int startX = currentPos.x;
		int endX = where.x;
		int startY = currentPos.y;
		int endY = where.y;
		boolean reverseX = false;
		boolean reverseY = false;

		if (startX > where.x)
		{
			reverseX = true;
		}
		else
		{
			reverseX = false;
		}
		
		if (startY > where.y)
		{
			reverseY = true;
		}
		else
		{
			reverseY = false;
		}
		
		if (startX != endX)
		{
			if (reverseX == false)
			{
				for (int currX = startX; currX < endX; currX++)
				{
					pause(DELAY);
					erase(new Point(currX - 1, currentPos.y));
					draw(new Point(currX, currentPos.y));
					currentPos.setLocation(currX, currentPos.y);
				}
			}
			else
			{
				for (int currX = startX; currX > endX; currX--)
				{
					pause(DELAY);
					erase(new Point(currX + 1, currentPos.y));
					draw(new Point(currX, currentPos.y));
					currentPos.setLocation(currX, currentPos.y);
				}
			}
		}
		
		if (startY != endY)
		{
			if (reverseY == false)
			{
				for (int currY = startY; currY < endY; currY++)
				{
					pause(DELAY);
					erase(new Point(currentPos.x, currY - 1));
					draw(new Point(currentPos.x, currY));
					currentPos.setLocation(currentPos.x, currY);
				}
			}
			else
			{
				for (int currY = startY; currY > endY; currY--)
				{
					pause(DELAY);
					erase(new Point(currentPos.x, currY + 1));
					draw(new Point(currentPos.x, currY));
					currentPos.setLocation(currentPos.x, currY);
				}
			}
		}
	}
	
	public Point getPosition()
	{
		return currentPos;
	}
	
	private void pause(int milliseconds)
	{
		try {
			Thread.sleep(milliseconds);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public abstract void draw(Point where);
	public abstract void erase(Point where);
}
