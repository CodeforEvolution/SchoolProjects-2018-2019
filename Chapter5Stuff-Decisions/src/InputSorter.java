import java.util.Scanner;


public class InputSorter {
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		System.out.println("Please enter 3 different numbers to sort: ");
		
		double a = in.nextDouble();
		double b = in.nextDouble();
		double c = in.nextDouble();
		
		in.close();
		
		System.out.println("\nLets see them sorted!");
		
		if (a < b && a < c)
		{
			System.out.println(a);
			if (b < c)
			{
				System.out.println(b);
				System.out.println(c);
			}
			else
			{
				System.out.println(c);
				System.out.println(b);
			}
		}
		else if (b < c && b < a)
		{
			System.out.println(b);
			if (a < c)
			{
				System.out.println(a);
				System.out.println(c);
			}
			else
			{
				System.out.println(c);
				System.out.println(a);
			}
		}
		else
		{
			System.out.println(c);
			if (a < b)
			{
				System.out.println(a);
				System.out.println(b);
			}
			else
			{
				System.out.println(b);
				System.out.println(a);
			}
		}				
	}

}
