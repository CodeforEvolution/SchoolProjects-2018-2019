package VehicleGraphics;

import java.awt.Color;
import java.awt.Point;

public class Truck extends Vehicle {

	public Truck(Point initialPos, Canvas surface, Color truckColor)
	{
		super(initialPos, surface, truckColor);
	}

	@Override
	public void draw(Point where)
	{
		Color old = whereToDraw.getInkColor();
		
		//Fill
		whereToDraw.setInkColor(myColor);
		whereToDraw.drawFilledRectangle(where.x, where.y, 30, 35);
		whereToDraw.drawFilledRectangle(where.x + 30, where.y - 5, 100, 40);
		whereToDraw.drawFilledOval(where.x, where.y + 35, 10, 10);
		whereToDraw.drawFilledOval(where.x + 35, where.y + 35, 10, 10);
		whereToDraw.drawFilledOval(where.x + 50, where.y + 35, 10, 10);
		whereToDraw.drawFilledOval(where.x + 100, where.y + 35, 10, 10);
		whereToDraw.drawFilledOval(where.x + 120, where.y + 35, 10, 10);
		
		//Outline
		whereToDraw.setInkColor(Color.BLACK);
		whereToDraw.drawRectangle(where.x, where.y, 30, 35);
		whereToDraw.drawRectangle(where.x + 30, where.y - 5, 100, 40);
		whereToDraw.drawOval(where.x, where.y  + 35, 10, 10);
		whereToDraw.drawOval(where.x + 35, where.y + 35, 10, 10);
		whereToDraw.drawOval(where.x + 50, where.y + 35, 10, 10);
		whereToDraw.drawOval(where.x + 100, where.y + 35, 10, 10);
		whereToDraw.drawOval(where.x + 120, where.y + 35, 10, 10);
		
		whereToDraw.setInkColor(old);
	}

	@Override
	public void erase(Point where)
	{
		Color old = whereToDraw.getInkColor();
		
		whereToDraw.setInkColor(whereToDraw.getBackgroundColor());
		whereToDraw.drawFilledRectangle(where.x, where.y, 30, 35);
		whereToDraw.drawFilledRectangle(where.x + 30, where.y - 5, 100, 40);
		whereToDraw.drawFilledOval(where.x, where.y + 35, 10, 10);
		whereToDraw.drawFilledOval(where.x + 35, where.y + 35, 10, 10);
		whereToDraw.drawFilledOval(where.x + 50, where.y + 35, 10, 10);
		whereToDraw.drawFilledOval(where.x + 100, where.y + 35, 10, 10);
		whereToDraw.drawFilledOval(where.x + 120, where.y + 35, 10, 10);
		
		whereToDraw.setInkColor(old);
	}

}
