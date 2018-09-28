import java.awt.geom.*;

//   c
// A /\ B
// b -- a
//    C

public class Triangle {
	private Point2D.Double pointA;
	private Point2D.Double pointB;
	private Point2D.Double pointC;
	
	public enum TriSide
	{
		SIDE_A, SIDE_B, SIDE_C;
	}
	
	public enum TriAngle
	{
		ANGLE_A, ANGLE_B, ANGLE_C;
	}
	
	public Triangle()
	{
		pointA = new Point2D.Double(0,0);
		pointB = new Point2D.Double(0,0);
		pointC = new Point2D.Double(0,0);
	}
	
	public Triangle(Point2D.Double.Double inPointA, Point2D.Double inPointB, Point2D.Double inPointC)
	{
		pointA = inPointA;
		pointB = inPointB;
		pointC = inPointC;
	}
	
	public Triangle(double xA, double yA, double xB, double yB, double xC, double yC)
	{
		pointA = new Point2D.Double.Double(xA, yA);
		pointB = new Point2D.Double.Double(xB, yB);
		pointC = new Point2D.Double.Double(xC, yC);
	}
	
	public void setPoints(Point2D.Double inPointA, Point2D.Double inPointB, Point2D.Double inPointC)
	{
		pointA = inPointA;
		pointB = inPointB;
		pointC = inPointC;
	}
	
	public void setPodoubles(double xA, double yA, double xB, double yB, double xC, double yC)
	{
		pointA = new Point2D.Double(xA, yA);
		pointB = new Point2D.Double(xB, yB);
		pointC = new Point2D.Double(xC, yC);		
	}
	
	public double getSide(TriSide side)
	{
		double outSide = 0.0;
		
		switch (side)
		{
			case SIDE_A:
				outSide = Math.sqrt(Math.pow(pointC.x - pointB.x, 2) + Math.pow(pointC.y - pointB.y, 2));
				break;
			case SIDE_B:
				outSide = Math.sqrt(Math.pow(pointA.x - pointB.x, 2) + Math.pow(pointB.y - pointA.y, 2));
				break;
			case SIDE_C:
				outSide = Math.sqrt(Math.pow(pointC.x - pointA.x, 2) + Math.pow(pointC.y - pointA.y, 2));
				break;
			default:
				return -1;
		}
		
		return outSide;
	}
	
	public double getAngle(TriAngle angle)
	{
		double outAngle = 0.0;
		
		double a = getSide(TriSide.SIDE_A);
		double b = getSide(TriSide.SIDE_B);
		double c = getSide(TriSide.SIDE_C);
		
		switch (angle)
		{
			case ANGLE_A:
				outAngle = (180 / Math.PI) * Math.acos((Math.pow(a, 2) - Math.pow(b, 2) - Math.pow(c, 2)) / (-2 * b * c));
				break;
			case ANGLE_B:
				outAngle = (180 / Math.PI) * Math.acos((Math.pow(b, 2) - Math.pow(a, 2) - Math.pow(c, 2)) / (-2 * a * c));
				break;
			case ANGLE_C:
				outAngle = (180 / Math.PI) * Math.acos((Math.pow(c, 2) - Math.pow(a, 2) - Math.pow(b, 2)) / (-2 * a * b));
				break;
			default:
				return -1;
		}
		
		return outAngle;
	}
	
	public double getPerimeter()
	{
		double perim = 0.0;
		
		perim += getSide(TriSide.SIDE_A);
		perim += getSide(TriSide.SIDE_B);
		perim += getSide(TriSide.SIDE_C);
		
		return perim;
	}
	
	public double getArea()
	{
		double outArea = 0.0;
		double s = 0.0;
		
		s = getPerimeter() / 2;
		
		outArea = (s - getSide(TriSide.SIDE_A)) * (s - getSide(TriSide.SIDE_B)) * (s - getSide(TriSide.SIDE_C));
		outArea *= s;
		outArea = Math.sqrt(outArea);
		
		return outArea;
	}
	
	public String toString()
	{
		String out = "";
		
		out += "\nThis triangle has:\n";
		out += "\tPerimeter: " + getPerimeter() + "\n";
		out += "\tArea: " + getArea() + "\n";
		out += "\tSides: " + getSide(TriSide.SIDE_A) + "," + getSide(TriSide.SIDE_B) + "," + getSide(TriSide.SIDE_C) + "\n";
		out += "\tAngles: " + getAngle(TriAngle.ANGLE_A) + "," + getAngle(TriAngle.ANGLE_B) + "," + getAngle(TriAngle.ANGLE_C) + "\n";

		return out;
	}
}
