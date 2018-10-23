import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;


public class MyAnimation {	
	public static void main(String[] args)
	{
		ArrayList<Thread> threads = new ArrayList<Thread>();
		Random r = new Random();
		
		Canvas myLife = new Canvas("Wow, moving shapes?!?", 500, 500, Color.BLUE);
		myLife.setVisible(true);
		
		for (int i = 0; i < 10; i++)
		{
			Color theColor = new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255), 255);
			threads.add(new Thread(new OtherDraw(new Egg(myLife, theColor, new Point(r.nextInt(myLife.getWidth()), r.nextInt(myLife.getHeight()))))));
			threads.get(i).start();
		}
		
		for (int i = 10; i < 20; i++)
		{
			Color theColor = new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255), 255);
			threads.add(new Thread(new OtherDraw(new Square(myLife, theColor, new Point(r.nextInt(myLife.getWidth()), r.nextInt(myLife.getHeight()))))));
			threads.get(i).start();
		}

		//MouseFollow follow = new MouseFollow();
		
		while(true)
		{
			Color fresh = new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255), 255);
			myLife.fillBackground(fresh);
			myLife.pause(200);
		}
	}
}
