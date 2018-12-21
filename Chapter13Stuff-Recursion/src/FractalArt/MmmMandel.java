package FractalArt;

import java.awt.Color;
import java.awt.Point;

public class MmmMandel {
	public static void main(String[] args)
	{
		Canvas easel = new Canvas("Here it is!", 500, 500, Color.BLACK);
		easel.setVisible(true);
		easel.setInkColor(Color.ORANGE);
		
		//new MandelDrawer(new Point(0, 0), new Point(300, 300), 20, easel).run();
		mandelTime(new Point(0, 0), new Point(300, 300), 20, easel);
		mandelTime(new Point(50, 50), new Point(450, 450), 20, easel);
		
		return;
	}
	
	public static void mandelTime (Point whereStart, Point whereEnd, int levels, Canvas surface)
	{
		if (levels < 0)
			throw new IllegalArgumentException("?!?");
		
		if (levels < 1)
		{
			surface.drawLine(whereStart, whereEnd);
			return;
		}
		else
		{
			mandelTime(new Point(whereStart.x, whereStart.y - 10), new Point(whereEnd.x, whereEnd.x - 10), levels - 1, surface);
			mandelTime(new Point(whereStart.x, whereStart.y + 10), new Point(whereEnd.x + 10, whereEnd.x), levels - 1, surface);
		}
	}
}
