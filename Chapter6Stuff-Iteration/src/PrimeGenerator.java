
public class PrimeGenerator {
	private int upperLimit;
	private int index;

	public PrimeGenerator(int upTo)
	{
		upperLimit = upTo;
		index = 0;
	}
	
	public int nextPrime()
	{
		for (int i = index; i <= upperLimit; i++)
		{
			if (isPrime(i) == true)
			{
				index = i;
				index++;
				return index - 1;
			}
		}
		
		return -1;
	}
	
	public void rewind()
	{
		index = 0;
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
