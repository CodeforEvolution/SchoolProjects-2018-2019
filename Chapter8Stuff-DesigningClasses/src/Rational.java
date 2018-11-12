
public class Rational {
	private int numerator;
	private int denominator;
	private static int operationNumber = 0;
	
	public Rational(int num, int den)
	{
		if ((num/den) > -1)
		{
			numerator = Math.abs(num);
			denominator = Math.abs(den);
		}
		else
		{
			numerator = -Math.abs(num);
			denominator = Math.abs(den);
		}
		
		reduce();
	}
	
	private void reduce()
	{
		numerator /= numerator;
		denominator /= numerator;
	}
	
	public int getNumerator()
	{
		return numerator;
	}
	
	public int getDenominator()
	{
		return denominator;
	}
	
	public Rational multiply(Rational otherFrac)
	{
		return new Rational(this.numerator * otherFrac.numerator, this.denominator * otherFrac.denominator);
	}
	
	public Rational divide(Rational otherFrac)
	{
		return new Rational(this.numerator * otherFrac.denominator, this.denominator * otherFrac.numerator);
	}
	
	public Rational add(Rational otherFrac)
	{
		
	}
	
	public Rational subtract(Rational otherFrac)
	{
		
	}
	
	public boolean equals(Object frac2)
	{
		Rational otherFrac = (Rational)frac2;
		
		if (this.numerator == otherFrac.numerator && this.denominator == otherFrac.denominator)
		{
			return true;
		}
		return false;
	}
	
	public String toString()
	{
		String out = "";
		
		out += "< ";
		out += numerator;
		out += " / ";
		out += denominator;
		out += " >";
		
		return out;
	}
	
	public Rational reciprocal()
	{
		
	}
	
	private int gcd(int first, int second)
	{
		
	}
}
