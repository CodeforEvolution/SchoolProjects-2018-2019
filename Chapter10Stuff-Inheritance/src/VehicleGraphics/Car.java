package VehicleGraphics;

import java.awt.Color;
import java.awt.Point;

public class Car extends Vehicle {

	public Car(Point initialPos, Canvas surface, Color carColor)
	{
		super(initialPos, surface, carColor);
	}

	@Override
	public void draw(Point where)
	{
		Color old = whereToDraw.getInkColor();
		
		//Fill
		whereToDraw.setInkColor(myColor);
		whereToDraw.drawFilledRectangle(where.x, where.y, 50, 20);
		whereToDraw.drawFilledRectangle(where.x - 25, where.y + 20, 100, 30);
		whereToDraw.drawFilledOval(where.x - 20, where.y + 50, 20, 20);
		whereToDraw.drawFilledOval(where.x + 45, where.y + 50, 20, 20);
		
		//Outline
		whereToDraw.setInkColor(Color.BLACK);
		whereToDraw.drawRectangle(where.x, where.y, 50, 20);
		whereToDraw.drawRectangle(where.x - 25, where.y + 20, 100, 30);
		whereToDraw.drawOval(where.x - 20, where.y + 50, 20, 20);
		whereToDraw.drawOval(where.x + 45, where.y + 50, 20, 20);
		
		whereToDraw.setInkColor(old);
	}

	@Override
	public void erase(Point where)
	{
		Color old = whereToDraw.getInkColor();
		
		whereToDraw.setInkColor(whereToDraw.getBackgroundColor());
		whereToDraw.drawFilledRectangle(where.x, where.y, 50, 20);
		whereToDraw.drawFilledRectangle(where.x - 25, where.y + 20, 100, 30);
		whereToDraw.drawFilledOval(where.x - 20, where.y + 50, 20, 20);
		whereToDraw.drawFilledOval(where.x + 45, where.y + 50, 20, 20);
		
		whereToDraw.setInkColor(old);
	}

}
