import java.awt.Color;
import java.awt.Point;

public class Egg extends MoverPainter {
	private Canvas drawPlace;
	private Color ourColor;
	
	private static final int EGG_HEIGHT = 50;
	private static final int EGG_WIDTH = 30;
	
	public Egg(Canvas surface, Color appearance, Point start)
	{
		drawPlace = surface;
		ourColor = appearance;
		currentPos = start;
		
		draw(start);
	}
	
	protected void draw(Point where)
	{
		Color old = drawPlace.getInkColor();
		
		drawPlace.setInkColor(ourColor);
		drawPlace.drawFilledOval(where.x, where.y, EGG_WIDTH, EGG_HEIGHT);
		
		drawPlace.setInkColor(old);
	}
	
	protected void erase(Point where)
	{
		Color old = drawPlace.getInkColor();
		
		drawPlace.setInkColor(drawPlace.getBackgroundColor());
		drawPlace.drawFilledOval(where.x, where.y, EGG_WIDTH, EGG_HEIGHT);
		
		drawPlace.setInkColor(old);
	}
}
