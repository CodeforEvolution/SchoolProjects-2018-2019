package TimeTime;

import java.awt.Color;
import java.awt.Point;

public class ItsTimeToStop {
	public static void main(String[] args)
	{
		Canvas theArtist = new Canvas("Time", 400, 400, Color.BLACK);
		theArtist.setVisible(true);
		
		Clock wed = new Clock(theArtist, new Point(100, 100), Color.WHITE);
		
		
		int h = 0;
		int m = 0;
		
		while (true)
		{
			h++;
			m++;
			System.out.println("Hour: " + h);
			System.out.println("Minute: " + m);
			wed.setTime(h, m);
			theArtist.pause(500);
		}
	}
}
