import java.util.Arrays;
import java.util.Random;


public class DecimalsForAll {
	public static void main(String[] args)
	{
		Random r = new Random();
		
		double[] small = new double[4];
		double[] large = new double[6];
		double[] huge = new double[small.length + large.length]; 
		
		System.out.println("Here's the smaller array: ");
		for (int i = 0; i < small.length; i++)
		{
			small[i] = r.nextInt(9) + r.nextDouble();
			System.out.println(small[i]);
		}
		System.out.println();
		
		System.out.println("Here's the large array: ");
		for (int i = 0; i < large.length; i++)
		{
			large[i] = r.nextInt(9) + r.nextDouble();
			System.out.println(large[i]);
		}
		System.out.println();
		
		double temp = small[1];
		small[1] = small[2];
		small[2] = temp;
		
		int currH = 0;
		int currS = 0;
		int currL = 0;
		while (currH < huge.length)
		{
			if (currS < small.length)
			{
				huge[currH] = small[currS];
				currS++;
			}
			else
			{
				huge[currH] = large[currL];
				currL++;
			}
			currH++;
		}
		
		System.out.println("Your new family sized array: ");
		for (int i = 0; i < huge.length; i++)
		{
			System.out.println(huge[i]);
		}
		System.out.println();
		
		Object[] result = switchThem(small, large);
		small = (double[]) result[0];
		large = (double[]) result[1];
		
		System.out.println("Your swaped Arrays: ");
		System.out.println("Small var: " + Arrays.toString(small));
		System.out.println("Large var: " + Arrays.toString(large));
	}
	
	public static Object[] switchThem(double[] first, double[] second)
	{	
		double[] newFir = new double[second.length];
		double[] newSec = new double[first.length];
		newFir = Arrays.copyOf(second, second.length);
		newSec = Arrays.copyOf(first,  first.length);
		
		Object[] obj = {newFir, newSec};
		
		return obj;
	}
}
