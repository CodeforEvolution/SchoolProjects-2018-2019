import java.awt.Color;
import java.util.Random;


public class Skyline {
	public static void main(String[] args)
	{
		Canvas theSkyline = new Canvas("Somewhere in Gotham...", 1000, 1000, Color.BLACK);
		Random r = new Random();
		Building towerStamp = new Building();
		
		theSkyline.setVisible(true);
		
		for (int i = 0; i < 100; i++)
		{
			towerStamp.setColorRandom();
			towerStamp.setHeightRandom(theSkyline.getHeight() / (r.nextInt(3) + 1));
			towerStamp.setWidthRandom(theSkyline.getWidth() / 4);
			towerStamp.setHorizontalLocation(r.nextInt(theSkyline.getWidth()));
			towerStamp.draw(theSkyline, theSkyline.getHeight());
			theSkyline.pause(100);
		}
	}
	
	/*
			int horizontal = theSkyline.getWidth();
			if (r.nextBoolean() == true)
				horizontal += r.nextInt(theSkyline.getWidth()) / 2;
			else
				horizontal -= r.nextInt(theSkyline.getWidth()) / 2;
	 */
}
