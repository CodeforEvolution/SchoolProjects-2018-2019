import java.awt.Color;
import java.awt.Point;

public class Square extends MoverPainter {
	private Canvas drawPlace;
	private Color ourColor;
	
	private static final int SQUARE_SIZE = 50;
	
	public Square(Canvas surface, Color appearance, Point start)
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
		drawPlace.drawFilledRectangle(where.x, where.y, SQUARE_SIZE, SQUARE_SIZE);
		
		drawPlace.setInkColor(old);
	}
	
	protected void erase(Point where)
	{
		Color old = drawPlace.getInkColor();
		
		drawPlace.setInkColor(drawPlace.getBackgroundColor());
		drawPlace.drawFilledRectangle(where.x, where.y, SQUARE_SIZE, SQUARE_SIZE);
		
		drawPlace.setInkColor(old);
	}
}
