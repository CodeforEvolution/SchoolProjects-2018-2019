import java.util.Scanner;


public class FactorPrinter {
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int number = 0;
		
		System.out.println("Whazzz up? Enter a number to factor: ");
		number = in.nextInt();
		in.close();
		
		System.out.println("\nNow, let's see...");
		FactorGenerator gen = new FactorGenerator(number);
		while(gen.hasMoreFactors() == true)
		{
			System.out.println(gen.nextFactor());
		}
	}
}
