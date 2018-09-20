package utils;

public class mathUtils {
	public static double[] quad(double a, double b, double c)
	{
		double[] solves = new double[2];
		
		solves[0] = (-b + Math.sqrt(Math.pow(b, 2.0)-(4.0*a*c))) / (2.0*a);
		solves[1] = (-b - Math.sqrt(Math.pow(b, 2.0)-(4.0*a*c))) / (2.0*a);

		return solves;
	}
}
