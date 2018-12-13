package TimeTime;

import java.awt.Color;
import java.awt.Point;

public class Clock {
	private Canvas where;
	private Point currentPos;
	private Color myColor;
	private int currMin;
	private int currHour;
	
	public Clock(Canvas surface, Point where, Color theColor)
	{
		setTime(0, 0);
		draw();
	}
	
	public void setTime(int hours, int minutes)
	{
		currHour = hours;
		currMin = minutes;
		draw();
	}
	
	public void draw()
	{
		drawOutline();
		drawHands();
	}
	
	public void drawOutline()
	{
	}
	
	public void drawHands()
	{
		
	}
}
