import java.util.Arrays;
import java.util.Scanner;


public class ProbOne {
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int input[] = new int[6];
		double sum = 0.0;
		double average = 0.0;
		int max = 0;
		
		System.out.println("Hello! Please enter 6 integers please! : ");
		for (int i = 0; i < 6; i++)
		{
			input[i] = in.nextInt();
		}
		
		System.out.println("\nThanks!");
		
		System.out.println("Your array: ");
		System.out.println(Arrays.toString(input));

		System.out.println("Now in reverse: ");
		for (int i = 5; i >= 0; i--)
		{
			System.out.print(input[i] + " ");
		}
		System.out.println();
		
		max = input[0];
		for (int i = 0; i < 6; i++)
		{
			if (input[i] > max)
			{
				max = input[i];
			}
			sum += input[i];
		}
		System.out.println("\nSum of #s in array: " + sum);
		System.out.println("Greatest # in array: " + max);
		
		average = sum / input.length;
		System.out.println("Average of array: " + average);
	}
}
