package FractalArt;

import java.awt.Color;
import java.awt.Point;

public class MmmMandel {
	public static void main(String[] args)
	{
		Canvas easel = new Canvas("Here it is!", 500, 500, Color.BLACK);
		easel.setVisible(true);
		
		easel.setInkColor(Color.ORANGE);
		mandelTime(new Point(0, 0), new Point(300, 300), 10, easel);
	}
	
	public static void mandelTime (Point whereStart, Point whereEnd, int levels, Canvas surface)
	{
		if (levels <= 0)
		{
			surface.drawLine(whereStart, whereEnd);
		}
		else
		{
			mandelTime(new Point(whereStart.x, whereStart.y - 10), new Point(whereEnd.x, whereEnd.x - 10), levels - 1, surface);
		}	
	}
}
