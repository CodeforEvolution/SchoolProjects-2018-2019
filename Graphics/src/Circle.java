import java.awt.Color;
import java.awt.Point;
import java.awt.geom.Point2D;


public class Circle {
	private int radius;
	private Point2D.Double location;
	private Color color;
	private Canvas drawSurface;
	
	public Circle(Canvas drawWhere, int theRadius, Point2D.Double theLocation, Color theColor)
	{
		radius = theRadius;
		location = theLocation;
		drawSurface = drawWhere;
		color = theColor;
		
		draw();
	}
	
	public void setLocation(Point2D.Double theLocation)
	{
		erase();
		location = theLocation;
		draw();
	}
	
	public void setColor(Color theColor)
	{
		erase();
		color = theColor;
		draw();
	}
	
	public boolean isInside(Point2D.Double in)
	{
		if (Point2D.distance(in.x, in.y, location.x, location.y) < radius)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	private void draw()
	{
		Color old = drawSurface.getInkColor();

		drawSurface.setInkColor(color);
		drawSurface.drawFilledOval((int)location.x, (int)location.y, radius, radius);
		
		drawSurface.setInkColor(old);
	}
	
	private void erase()
	{
		Color old = drawSurface.getInkColor();
		
		drawSurface.setInkColor(drawSurface.getBackgroundColor());
		drawSurface.drawFilledOval((int)location.x, (int)location.y, radius, radius);
		
		drawSurface.setInkColor(old);
	}
}
