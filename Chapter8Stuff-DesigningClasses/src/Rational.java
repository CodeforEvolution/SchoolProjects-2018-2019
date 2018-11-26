import java.math.BigDecimal;


public class Rational implements Comparable {
	private int numerator;
	private int denominator;
	public static int operationNumber = 0;
	
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
		int great = gcd(numerator, denominator);
		
		numerator /= great;
		denominator /= great;
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
		operationNumber++;
		return new Rational(this.numerator * otherFrac.numerator, this.denominator * otherFrac.denominator);
	}
	
	public Rational divide(Rational otherFrac)
	{
		operationNumber++;
		return new Rational(this.numerator * otherFrac.denominator, this.denominator * otherFrac.numerator);
	}
	
	public Rational add(Rational otherFrac)
	{
		int numNew = (this.numerator * otherFrac.denominator) + (otherFrac.numerator * this.denominator);
		int denNew = this.denominator * otherFrac.denominator;
		
		operationNumber++;
		return new Rational(numNew, denNew);
	}
	
	public Rational subtract(Rational otherFrac)
	{
		int numNew = (this.numerator * otherFrac.denominator) - (otherFrac.numerator * this.denominator);
		int denNew = this.denominator * otherFrac.denominator;
		
		operationNumber++;
		return new Rational(numNew, denNew);
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
		int numNew = this.denominator;
		int denNew = this.numerator;
		
		int divisor = gcd(numNew, denNew);
		
		return new Rational(numNew / divisor, denNew / divisor);
	}
	
	private int gcd(int first, int second)
	{
		int gcd = 0;
		int greater = 0;
		
		if (first < second)
		{
			greater = second;
		}
		else if (first > second)
		{
			greater = first;
		}
		else
		{
			//Optimize
			return first;
		}

		for (int i = 1; i <= greater; i++)
		{
			if (first % i == 0 && second % i == 0)
			{
				gcd = i;
			}
		}
		
		return gcd;
	}

	@Override
	public int compareTo(Object compareTo) {
		Rational other = (Rational)compareTo;
		
		BigDecimal ours = new BigDecimal(this.getNumerator() / this.getDenominator());
		BigDecimal theirs = new BigDecimal(other.getNumerator() / other.getDenominator());
		
		return ours.compareTo(theirs);
	}
}
