
public class QuadraticEquationTester {
	public static void main(String[] args)
	{
		double a = 1;
		double b = -5;
		double c = 6;
		
		QuadraticEquation quadEq = new QuadraticEquation(a, b, c);
		
		System.out.println("A: " + a);
		System.out.println("B: " + b);
		System.out.println("C: " + c);

		System.out.println("Solvable: " + quadEq.isSolvable());	
		
		System.out.println("Solution 1: " + quadEq.getSolution1());
		System.out.println("Solution 2: " + quadEq.getSolution2());
	}
}
