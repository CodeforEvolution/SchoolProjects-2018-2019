package TimeTime;

import java.awt.Color;
import java.awt.Point;
import java.time.LocalTime;

public class ItsTimeToStop {
	public static void main(String[] args)
	{
		Canvas theArtist = new Canvas("Time", 1000, 700, Color.BLACK);
		theArtist.setVisible(true);
		
		Clock wed = new Clock(theArtist, new Point(100, 100), Color.WHITE);
		Clock ted = new Clock(theArtist, new Point(700, 450), Color.BLUE);
		Clock yes = new Clock(theArtist, new Point(450, 145), Color.RED);
		Clock t = new Clock(theArtist, new Point(750, 100), Color.ORANGE);
		Clock e = new Clock(theArtist, new Point(200, 450), Color.YELLOW);
		Clock d = new Clock(theArtist, new Point(460, 445), Color.MAGENTA);
		
		LocalTime curr = null;
		
		while (true)
		{
			theArtist.erase();
			curr = java.time.LocalTime.now();
			wed.setTime(curr.getHour(), curr.getMinute(), curr.getSecond());
			ted.setTime(curr.getHour(), curr.getMinute(), curr.getSecond());
			yes.setTime(curr.getHour(), curr.getMinute(), curr.getSecond());
			t.setTime(curr.getHour(), curr.getMinute(), curr.getSecond());
			e.setTime(curr.getHour(), curr.getMinute(), curr.getSecond());
			d.setTime(curr.getHour(), curr.getMinute(), curr.getSecond());
			theArtist.pause(100);
		}
	}
}
