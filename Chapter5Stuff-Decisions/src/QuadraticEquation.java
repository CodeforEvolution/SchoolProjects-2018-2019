
public class QuadraticEquation {
	private double solve1;
	private double solve2;
	
	public QuadraticEquation(double a, double b, double c)
	{
		solve1 = (-b + Math.sqrt(Math.pow(b, 2.0)-(4.0*a*c))) / (2.0*a);
		solve2 = (-b - Math.sqrt(Math.pow(b, 2.0)-(4.0*a*c))) / (2.0*a);
	}
	
	public boolean isSolvable()
	{
		if (Double.isNaN(solve1) == true || Double.isNaN(solve2) == true)
			return false;
		return true;
	}
	
	public double getSolution1()
	{
		return solve1;
	}
	
	public double getSolution2()
	{
		return solve2;
	}
}
