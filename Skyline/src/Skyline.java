import java.awt.Color;
import java.util.Random;


public class Skyline {
	public static void main(String[] args)
	{
		Canvas theSkyline = new Canvas("Somewhere in Gotham...", 1000, 1000, Color.BLACK);
		Random r = new Random();
		Building towerStamp = new Building();
		final int SUN_SIZE = 100;
		
		theSkyline.setVisible(true);
		
		theSkyline.setInkColor(Color.YELLOW);
		theSkyline.drawFilledOval(theSkyline.getWidth() - SUN_SIZE, SUN_SIZE, SUN_SIZE, SUN_SIZE);
		
		for (int i = 0; i < 100; i++)
		{
			towerStamp.setColorRandom();
			towerStamp.setHeightRandom(theSkyline.getHeight() / (r.nextInt(3) + 1));
			towerStamp.setWidthRandom((theSkyline.getWidth() / 4) + towerStamp.WINDOW_SIZE);
			towerStamp.setHorizontalLocation((r.nextInt(theSkyline.getWidth())) * r.nextInt(2));
			towerStamp.draw(theSkyline, theSkyline.getHeight(), true);
			theSkyline.pause(50);
		}
	}
}
