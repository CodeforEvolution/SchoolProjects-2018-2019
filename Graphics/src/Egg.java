import java.awt.Color;
import java.awt.Point;

public class Egg {
	private Canvas drawPlace;
	private Point currentPos;
	private Color ourColor;
	
	private static final int EGG_HEIGHT = 50;
	private static final int EGG_WIDTH = 30;
	
	public Egg(Canvas surface, Color appearance, Point start)
	{
		drawPlace = surface;
		ourColor = appearance;
		currentPos = new Point(0, 0);
		
		moveTo(start);
	}
	
	public void moveTo(Point where /*, int howLong*/)
	{			

		erase(currentPos);
		draw(where);
		
		currentPos = where;
	}
	
	private void draw(Point where)
	{
		drawPlace.drawFilledOval(where.x, where.y, EGG_WIDTH, EGG_HEIGHT);
	}
	
	private void erase(Point where)
	{
		Color old = drawPlace.getInkColor();
		
		drawPlace.setInkColor(drawPlace.getBackgroundColor());
		drawPlace.drawFilledOval(where.x, where.y, EGG_WIDTH, EGG_HEIGHT);
		
		drawPlace.setInkColor(old);
	}
}
