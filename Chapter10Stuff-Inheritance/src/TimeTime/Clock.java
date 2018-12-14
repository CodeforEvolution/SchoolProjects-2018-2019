package TimeTime;

import java.awt.Color;
import java.awt.Point;

public class Clock {
	private Canvas where;
	private Point currentPos;
	private Color myColor;
	private int currMin;
	private int currHour;
	
	public Clock(Canvas surface, Point initialPos, Color theColor)
	{
		where = surface;
		currentPos = initialPos;
		myColor = theColor;
		setTime(0, 0);
		draw();
	}
	
	public void setTime(int hours, int minutes)
	{
		currHour = hours;
		currMin = minutes;
		where.erase();
		draw();
	}
	
	public void setPos(Point whereNow)
	{
		currentPos = whereNow;
		draw();
	}
	
	public void draw()
	{
		drawOutline();
		drawHands();
	}
	
	public void drawOutline()
	{
		where.pushState();
		
		where.setInkColor(myColor);
		where.drawOval(currentPos.x, currentPos.y, 200, 200);
		where.drawFilledRectangle(currentPos.x + 100, currentPos.y, 10, 20);
		where.drawFilledRectangle(currentPos.x, currentPos.y + 100, 20, 10);
		where.drawFilledRectangle(currentPos.x + 100, currentPos.y + 180, 10, 20);
		where.drawFilledRectangle(currentPos.x + 180, currentPos.y + 100, 20, 10);
		
		where.popState();
	}
	
	public void drawHands()
	{
		where.pushState();
		
		int H = currHour;
		int M = currMin;
		
		where.setInkColor(Color.WHITE);
		
		Point mHand = new Point(100 + (int)Math.cos(M), 100 + (int)Math.cos(M));
		Point hHand = new Point(100 + (int)Math.cos(H), 100 + (int)Math.cos(H));
		where.drawLine(new Point(currentPos.x + 100, currentPos.y + 100), mHand);
		where.drawLine(new Point(currentPos.x + 100, currentPos.y + 100), hHand);
		
		where.popState();
	}
}
