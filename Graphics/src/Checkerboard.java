import java.awt.Color;


public class Checkerboard {
	private static Color current = Color.BLACK;
	
	public static void main(String[] args)
	{
		final int RECT_SIDE = 30;
		
		Canvas myWorld = new Canvas("Chess Anyone?", 400, 400, Color.GREEN);
		myWorld.setVisible(true);
		myWorld.setInkColor(Color.BLUE);
		
		myWorld.drawString("Time for some chess!" , 150, 150);
		myWorld.pause(2000);
		myWorld.erase();
		
		myWorld.drawString("3", 175, 200);
		myWorld.pause(1000);
		myWorld.erase();
		myWorld.drawString("2", 175, 200);
		myWorld.pause(1000);
		myWorld.erase();
		myWorld.drawString("1", 175, 200);
		myWorld.pause(1000);
		myWorld.erase();
		myWorld.drawString("Go!", 175, 200);
		myWorld.pause(1000);
		myWorld.erase();
		
		for (int y = 1; y <= 8; y++)
		{
			for (int x = 1; x <= 8; x++)
			{
				myWorld.setInkColor(current);
				myWorld.drawFilledRectangle(RECT_SIDE * x, RECT_SIDE * y, RECT_SIDE, RECT_SIDE);
				swapColor();
			}
			swapColor();
		}
	}
	
	private static void swapColor()
	{
		if (current == Color.BLACK)
		{
			current = Color.WHITE;
		}
		else
		{
			current = Color.BLACK;
		}
		return;
	}
}
