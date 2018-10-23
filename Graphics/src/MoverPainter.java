import java.awt.Point;

public class MoverPainter {
	protected Point currentPos;

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
					pause(10);
					erase(new Point(currX - 1, currentPos.y));
					draw(new Point(currX, currentPos.y));
					currentPos.setLocation(currX, currentPos.y);
				}
			}
			else
			{
				for (int currX = startX; currX > endX; currX--)
				{
					pause(10);
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
					pause(10);
					erase(new Point(currentPos.x, currY - 1));
					draw(new Point(currentPos.x, currY));
					currentPos.setLocation(currentPos.x, currY);
				}
			}
			else
			{
				for (int currY = startY; currY > endY; currY--)
				{
					pause(10);
					erase(new Point(currentPos.x, currY + 1));
					draw(new Point(currentPos.x, currY));
					currentPos.setLocation(currentPos.x, currY);
				}
			}
		}
	}
	
	private void pause(int milliseconds)
	{
		try {
			Thread.sleep(milliseconds);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	protected void draw(Point where) {}
	protected void erase(Point where) {}
}
