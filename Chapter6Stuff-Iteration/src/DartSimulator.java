import java.awt.geom.Point2D;
import java.util.Random;
import java.util.Scanner;

/*
 * Compared to Buffon Needle strategy, there could
 * be an issue with how to randomize dropping the needle,
 * along with the size of the needle.
 */

public class DartSimulator {
	public static void main(String[] args)
	{	
		Point2D.Double current = null;
		Scanner in = new Scanner(System.in);
		
		double circleHit = 0.0;
		double total = 0.0;
		
		System.out.println("Hello! How may simulations would you like to run?");
		int times = in.nextInt();
		in.close();
		
		System.out.println("Let's Go! : ");
		
		for (int i = 0; i < times; i++)
		{
			current = randomHit();
			
			if (inCircle(current) == true)
			{
				System.out.println("The point " + current + " is inside the circle!");
				circleHit++;
			}
			else
			{
				System.out.println("The point " + current + " is out of the park...");
			}
			total++;
		}
		
		System.out.println();
		System.out.println("Out of " + total + " total hit(s), you landed " + circleHit + " in the circle!");
		
		double pi = (circleHit / total) * 4.0;
		System.out.println("Pi should be about: " + pi);
	}
	
	private static Point2D.Double randomHit()
	{
		Random r = new Random();
		
		double theX = r.nextDouble() - (r.nextInt(2));
		double theY = r.nextDouble() - (r.nextInt(2));
		
		return new Point2D.Double(theX, theY);
	}
	
	private static boolean inCircle(Point2D.Double hit)
	{
		if (hit.distance(0, 0) > 1.0)
		{
			return false;
		}
		return true;
	}
}
