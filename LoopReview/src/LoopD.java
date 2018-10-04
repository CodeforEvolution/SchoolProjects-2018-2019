import java.util.Scanner;


public class LoopD {
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		char first = ' ';
		char second = ' ';
		int number = 0;
		
		System.out.println("Please enter two characters, then an integer: ");
		first = in.next().charAt(0);
		second = in.next().charAt(0);
		number = in.nextInt();
		in.close();
		
		System.out.println();
		for (int i = 0; i < number; i++)
		{
			System.out.print(first + " ");
		}
		
		System.out.println();
		for (int i = 0; i < number; i++)
		{
			System.out.println(second);
		}
	}
}
