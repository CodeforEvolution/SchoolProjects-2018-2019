import java.awt.Point;
import java.util.Random;

public class OtherDraw implements Runnable {
	private MoverPainter shape;
	
	public OtherDraw(MoverPainter theShape)
	{
		shape = theShape;
	}

	public void run() {
		Random r = new Random();
		
		while(true)
		{
			shape.moveTo(new Point(r.nextInt(500), r.nextInt(500)));
		}
	}
}
