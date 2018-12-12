package VehicleGraphics;

import java.awt.Color;
import java.awt.Point;
import java.util.Random;

public class TrafficTester {
	private static Random r;
	public final static int WORLD_HEIGHT = 500;
	public final static int WORLD_LENGTH = 500;

	public static void main(String[] args)
	{	
		r = new Random();
		Canvas city = new Canvas("City", WORLD_LENGTH, WORLD_HEIGHT, Color.BLUE);
		city.setVisible(true);
		
		for (int i = 0; i < 10; i++)
		{
			randomVehicle(city);
			//new Plane(new Point(250, 250), city, randomColor());
		}
	}
	
	public static Vehicle randomVehicle(Canvas whereToCreate)
	{
		Point p = new Point(r.nextInt(500) + 1, r.nextInt(500) + 1);
		
		switch (r.nextInt(3))
		{
			case 0:
				return new Car(p, whereToCreate, randomColor());
			case 1:
				return new Truck(p, whereToCreate, randomColor());
			case 2:
				return new Plane(p, whereToCreate, randomColor());
			default:
				return new Car(p, whereToCreate, randomColor());
		}
	}
	
	public static Color randomColor()
	{
		switch (r.nextInt(10))
		{
		case 0:
			return Color.BLACK;
		case 1:
			return Color.YELLOW;
		case 2:
			return Color.CYAN;
		case 3:
			return Color.DARK_GRAY;
		case 4:
			return Color.GRAY;
		case 5:
			return Color.GREEN;
		case 6:
			return Color.LIGHT_GRAY;
		case 7:
			return Color.MAGENTA;
		case 8:
			return Color.ORANGE;
		case 9:
			return Color.RED;
		default:
			return Color.BLACK;
		}
	}
}
