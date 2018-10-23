import java.util.Arrays;
import java.util.Random;


public class ProbTwo {
	public static void main(String[] args)
	{
		Random r = new Random();
		int[] wackyNumbers = new int[10];
		double sum = 0.0;
		double average = 0.0;

		for (int i = 0; i < wackyNumbers.length; i++)
		{
			wackyNumbers[i] = r.nextInt(41) - 20;
			sum += wackyNumbers[i];
		}
		average = sum / wackyNumbers.length;
		
		System.out.println("Your random array: ");
		System.out.println(Arrays.toString(wackyNumbers));
		
		System.out.println("\nThe average of your array is: " + average);
		
		System.out.println("\nNumbers below the array average: ");
		for (int i = 0; i < wackyNumbers.length; i++)
		{
			if (wackyNumbers[i] < average)
				System.out.print(wackyNumbers[i]);
		}
		System.out.println();                         
	}
}
