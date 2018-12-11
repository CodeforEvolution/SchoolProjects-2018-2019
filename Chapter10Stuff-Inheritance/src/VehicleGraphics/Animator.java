package VehicleGraphics;
import java.awt.Point;
import java.util.Random;

public class Animator implements Runnable {
	private Vehicle vehicle;
	
	public Animator(Vehicle theVehicle)
	{
		vehicle = theVehicle;
	}

	public void run() {
		Random r = new Random();
		
		while(true)
		{
			vehicle.moveTo(new Point(r.nextInt(TrafficTester.WORLD_LENGTH), r.nextInt(TrafficTester.WORLD_HEIGHT)));
		}
	}
}
