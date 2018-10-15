import java.awt.Color;
import java.awt.Point;
import java.awt.geom.Point2D;
import java.util.Scanner;


public class CirclePointInside {
	public static void main(String[] args)
	{
		double x = 0;
		double y = 0;
		
		Scanner in = new Scanner(System.in);

		Canvas scene = new Canvas("Just in time for art!", 500, 500, Color.BLACK);
		scene.setInkColor(Color.ORANGE);
		scene.drawString("Look at the CMD please!" , 150, 250);
		scene.setVisible(true);

		System.out.println("Please enter a coordinate please (x y) : ");
		x = in.nextDouble();
		y = in.nextDouble();
		in.close();
		
		scene.erase();
		
		Circle theOld = new Circle(scene, 100, new Point2D.Double(200, 200), Color.BLUE);
		
		Color smallCol = null;
		if (theOld.isInside(new Point2D.Double(x, y)) == true)
		{
			smallCol = Color.GREEN;
		}
		else
		{
			smallCol = Color.RED;
		}
		
		scene.drawPoint(new Point((int)x,(int)y));
		Circle theNew = new Circle(scene, 30, new Point2D.Double(x, y), smallCol);

		return;
	}
}
