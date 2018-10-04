import java.util.Scanner;


public class LoopE {
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int[] numbers = new int[4];
		int sum = 0;
		
		System.out.println("Hello!! Please enter four different numbers: ");
		for (int i = 0; i < 4; i++)
		{
			numbers[i] = in.nextInt();
		}
		in.close();
		
		int index = 0;
		while (index < 4)
		{
			sum += numbers[index];
			index++;
		}
		System.out.println("\nThe sum of your numbers is " + sum);
		
		System.out.print("Now, the highest number, I'm so excited!!! It's ");
		if (numbers[0] > numbers[1] && numbers[0] > numbers[2] && numbers[0] > numbers[3])
			System.out.println(numbers[0]);
		else if (numbers[1] > numbers[2] && numbers[1] > numbers[3])
			System.out.println(numbers[1]);
		else if (numbers[2] > numbers[3])
			System.out.println(numbers[2]);
		else
			System.out.println(numbers[3]);
	}
}
