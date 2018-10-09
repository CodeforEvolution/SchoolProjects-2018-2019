import java.util.Scanner;


public class PrimeTester {
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int curPrime = 0;
		int primeLimit = 0;
		
		System.out.println("Enter a number good person! : ");
		primeLimit = in.nextInt();
		in.close();

		PrimeGenerator pGen = new PrimeGenerator(primeLimit);

		System.out.println("Here comes the primes! : ");

		curPrime = pGen.nextPrime();
		while (curPrime != -1)
		{
			System.out.println(curPrime);
			curPrime = pGen.nextPrime();
		}	
	}
}
