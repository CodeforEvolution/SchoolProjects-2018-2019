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
		
		//Outline
		whereToDraw.setInkColor(Color.BLACK);
		whereToDraw.drawRectangle(where.x, where.y, 30, 35);
		whereToDraw.drawFilledRectangle(where.x + 30, where.y - 5, 100, 40);
		
		whereToDraw.setInkColor(old);
	}

	@Override
	public void erase(Point where)
	{
		Color old = whereToDraw.getInkColor();
		
		whereToDraw.setInkColor(old);
	}

}
