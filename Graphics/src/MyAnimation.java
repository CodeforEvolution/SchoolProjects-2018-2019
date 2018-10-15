import java.awt.Color;
import java.awt.Point;


public class MyAnimation {	
	public static void main(String[] args)
	{
		Canvas myLife = new Canvas("Wow, moving shapes?!?", 500, 500, Color.BLUE);
		myLife.setVisible(true);
		
		Egg myEgg = new Egg(myLife, Color.ORANGE, new Point(50, 50));
		myLife.pause(2000);
		myEgg.moveTo(new Point(100, 100));
	}
}
