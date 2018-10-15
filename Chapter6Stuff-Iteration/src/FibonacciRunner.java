import java.util.Scanner;

public class FibonacciRunner {
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		System.out.println("Heya! How many Fibonacci numbers would you like? : ");
		int upTo = in.nextInt();
		in.close();
		
		System.out.println("\nHere we go! : ");
		
		if (upTo <= 0)
		{
			System.out.println("How funny...");
			return;
		}
		else if (upTo == 1)
		{
			System.out.println("1");
			return;
		}
		else
		{
			System.out.println("1\n1");
		}	
			
		int fPrev = 1;
		int fNext = 1;
		for (int i = 2; i < upTo; i++)
		{
			int temp = fPrev + fNext;
			System.out.println(temp);
			fPrev = fNext;
			fNext = temp;
		}
	}
}
