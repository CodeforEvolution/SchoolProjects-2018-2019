import java.util.Arrays;
import java.util.Scanner;


public class PurseTester {
	public static void main(String[] args)
	{
		Purse manPurse = new Purse();
		
		Coin quarter = new Coin("Quarter", 0.25);
		Coin dime = new Coin("Dime", 0.10);
		
		Scanner in = new Scanner(System.in);
		System.out.println("Add coins to the purse, when done, type 'end'.");
		
		String input = "";
		double val = 0.0;
		do
		{	
			System.out.println("\nWhat should the name of this coin be? : ");
			input = in.next();
			if (input.equals("end") == false)
			{
				System.out.println("\nWhat should the value of this coin be? (Only useful if coin isn't a normal coin) : ");
				val = in.nextFloat();
				manPurse.addCoin(new Coin(input, val));
			}
		} while (input.equals("end") == false);
		
		in.close();
		
		for (int i = 0; i < 10; i++)
		{
			manPurse.addCoin(dime);
		}
		
		for (int i = 0; i < 5; i++)
		{
			manPurse.addCoin(quarter);
		}
		
		System.out.println();
		System.out.println("Number of coins in purse: " + manPurse.numberOfCoins());
		System.out.println("Total value of coins in purse: " + manPurse.valueOfCoins());
		System.out.println("Average value of coins in purse: " + manPurse.averageCoinVal());
		
		System.out.println("\nPurse contents: ");
		System.out.println(Arrays.toString(manPurse.getArrayVals()));
		
		
	}
}
