import java.util.Scanner;

public class CardTester {
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		String sh = "";
		
		System.out.println("Please enter a shorthand card identifier: ");
		sh = in.next();
		in.close();
		
		Card magic = new Card(sh);
		
		System.out.println("Your card is: " + magic.getDescription());
		
	}
}
