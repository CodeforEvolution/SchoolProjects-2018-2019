import java.awt.Color;
import java.awt.Point;


public class ProbFive {
	public static void main(String[] args)
	{
		Canvas microPaint = new Canvas("Funky Shapes", 1000, 1000, Color.CYAN);
		microPaint.setVisible(true);
		
		microPaint.setInkColor(Color.BLACK);
		Hexagon theShape = new Hexagon(microPaint, new Point(25, 25), 30, false);
		Hexagon theOther = new Hexagon(microPaint, new Point(50, 50), 10, true);
		
		theShape.moveTo(new Point(200, 500));
		theOther.moveTo(new Point(200, 500));
	}
}
