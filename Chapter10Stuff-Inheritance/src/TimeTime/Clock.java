package TimeTime;

import java.awt.Color;
import java.awt.Point;

public class Clock {
	private Canvas where;
	private Point currentPos;
	private Color myColor;
	private int currSec;
	private int currMin;
	private int currHour;
	
	private static final int SEC_RAD = 100;
	private static final int MIN_RAD = 90;
	private static final int HOUR_RAD = 70;
	private static final int ROTATER = 90;
	
	public Clock(Canvas surface, Point initialPos, Color theColor)
	{
		where = surface;
		currentPos = initialPos;
		myColor = theColor;
		setTime(0, 0, 0);
		draw();
	}
	
	public void setTime(int hours, int minutes, int seconds)
	{
		currHour = hours;
		currMin = minutes;
		currSec = seconds;
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
		
		int Hdeg = (currHour * 30) - ROTATER;
		int Mdeg = (currMin * 6) - ROTATER;
		int Sdeg = (currSec * 6) - ROTATER;
		
		where.setInkColor(Color.WHITE);

		Point sHand = new Point((currentPos.x + 100) + (int)(Math.cos(Sdeg * (Math.PI/180.0)) * SEC_RAD), (currentPos.y + 100) + (int)(Math.sin(Sdeg * (Math.PI/180.0)) * SEC_RAD));
		Point mHand = new Point((currentPos.x + 100) + (int)(Math.cos(Mdeg * (Math.PI/180.0)) * MIN_RAD), (currentPos.y + 100) + (int)(Math.sin(Mdeg * (Math.PI/180.0)) * MIN_RAD));
		Point hHand = new Point((currentPos.x + 100) + (int)(Math.cos(Hdeg * (Math.PI/180.0)) * HOUR_RAD), (currentPos.y + 100) + (int)(Math.sin(Hdeg * (Math.PI/180.0)) * HOUR_RAD));
		
		where.drawLine(new Point(currentPos.x + 100, currentPos.y + 100), sHand);
		where.drawLine(new Point(currentPos.x + 100, currentPos.y + 100), mHand);
		where.drawLine(new Point(currentPos.x + 100, currentPos.y + 100), hHand);
		
		where.popState();
	}
}
