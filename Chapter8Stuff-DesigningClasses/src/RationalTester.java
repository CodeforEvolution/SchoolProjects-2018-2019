
public class RationalTester {
	public static void main(String[] args)
	{
		Rational f1 = new Rational(12, 16);
		Rational f2 = new Rational(2, 6);
		
		System.out.println("First fraction : " + f1);
		System.out.println("Second fraction : " + f2);
		
		Rational f4 = f1.add(f2);
		Rational f5 = f1.subtract(f2);
		Rational f6 = f1.multiply(f2);
		Rational f7 = f1.divide(f2);
		
		System.out.println("f1 + f2: " + f4);
		System.out.println("f1 - f2: " + f5);
		System.out.println("f1 * f2: " + f6);
		System.out.println("f1 / f2: " + f7);
		
		System.out.println("Total multiply ops: " + Rational.operationNumber);
		System.out.println("f1 equals f2? : " + f1.equals(f2));
		
		//Comparable Expansion
		System.out.println();
		
		int result = f1.compareTo(f2);
		if (result == 0)
			System.out.println(f1 + " is equal to " + f2);
		else if (result == -1)
			System.out.println(f1 + " is less than " + f2);
		else
			System.out.println(f1 + " is greater than " + f2);
	}
}
