package FractalArt;

import java.awt.Point;

public class MandelDrawer implements Runnable {
	private Canvas surface;
	private Point whereStart;
	private Point whereEnd;
	private int levels;
	
	public MandelDrawer(Point theStart, Point theEnd, int theLevels, Canvas theSurface)
	{
		whereStart = theStart;
		whereEnd = theEnd;
		levels = theLevels;
		surface = theSurface;
	}
	
	@Override
	public void run()
	{
		if (levels < 0)
		{
			surface.drawLine(whereStart, whereEnd);
			return;
		}
		else
		{
			new MandelDrawer(new Point(whereStart.x, whereStart.y - 10), new Point(whereEnd.x, whereEnd.x - 10), levels - 1, surface).run();
			new MandelDrawer(new Point(whereStart.x, whereStart.y + 10), new Point(whereEnd.x + 10, whereEnd.x), levels - 1, surface).run();
		}	
	}

}
