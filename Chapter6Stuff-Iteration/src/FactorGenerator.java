import java.util.ArrayList;
import java.util.Collections;


public class FactorGenerator {
	private int number;
	private int index;
	private ArrayList<Integer> factors;
	
	public FactorGenerator(int numberToFactor)
	{
		factors = new ArrayList<Integer>();
		number = numberToFactor;
		index = 0;
		
		setupFactors(number);
	}
	
	public void rewind()
	{
		index = 0;
	}
	
	public int nextFactor()
	{
		if (hasMoreFactors() == true)
		{
			int out = factors.get(index);
			index++;
			return out;
		}
		else
		{
			return -1;
		}
	}
	
	public boolean hasMoreFactors()
	{
		if (index > factors.size() - 1)
		{
			return false;
		}
		return true;
	}
	
	private void setupFactors(int inNumber)
	{
		for (int i = 1; i < inNumber; i++)
		{
			if (inNumber % i == 0)
			{
				if (isPrime(i) == true)
				{
					factors.add(i);
				}
			}
		}
		
		int product = factors.get(0);
		for (int i = 1; i < factors.size(); i++)
		{
			product *= factors.get(i);
		}
		
		if (inNumber != product)
		{
			int second = inNumber / product;
			if (isPrime(second) == true)
			{
				factors.add(second);
			}
			else
			{
				setupFactors(second);
			}
		}
		Collections.sort(factors);
	}
	
	public static boolean isPrime(int number)
	{
		 if (number <= 1)
			 return false;
		
		for (int i = 2; i < number; i++)
		{
	        if (number % i == 0 && i != number)
	        {
	        	return false;
	        }
	    }
		
	    return true;
	}
}
