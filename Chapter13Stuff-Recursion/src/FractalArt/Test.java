package FractalArt;

import java.awt.Color;

public class Test {
	public static void main(String[] args)
	{
		Canvas myCanvas = new Canvas("Do You See the C");
		myCanvas.setSize(1000, 500);
		myCanvas.setVisible(true);
		
		myCanvas.fillBackground(Color.BLACK);
		
		myCanvas.setInkColor(Color.ORANGE);
		cFrac(50, 50, 50, 100, 1, myCanvas);
		cFrac(100, 60, 100, 120, 2, myCanvas);
		myCanvas.pause(500);
		cFrac(170, 80, 170, 160, 3, myCanvas);
		myCanvas.pause(500);
		cFrac(240, 80, 240, 160, 4, myCanvas);
		myCanvas.pause(500);
		cFrac(360, 90, 360, 180, 7, myCanvas);
		myCanvas.pause(500);
		cFrac(510, 90, 510, 220, 1, myCanvas);
		myCanvas.pause(500);
		cFrac(800, 120, 800, 350, 12, myCanvas);
	}
	
	public static void cFrac(int x1, int y1, int x2, int y2, int level, Canvas kanvs)
	{
		int xmid, ymid;
		if (level == 0)
		{
			kanvs.pause(5);
			kanvs.drawLine(x1, y1, x2, y2);
		}
		else
		{
			xmid = (x1 + x2 + y1 + y2) / 2;
			ymid = (x2 - x1 + y1 + y2) / 2;
			cFrac(x1, y1, xmid, ymid, level - 1, kanvs);
			cFrac(xmid, ymid, x2, y2, level - 1, kanvs);
		}
	}
}
