import java.util.Scanner;


public class StringManipulator {
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		String input = "";
		
		System.out.println("Please enter anything: ");
		input = in.next();
		in.close();
		
		System.out.println("\nNow we'll break it into characters...");
		char split[] = input.toCharArray();
		
		System.out.println("\nAnd we'll get the first character: ");
		System.out.println(split[0]);
		
		System.out.println("\nAnd we'll get the last character: ");
		System.out.println(split[split.length - 1]);
		
		System.out.println("\nNow we'll remove the first character: ");
		for (int i = 0; i < split.length - 1; i++)
		{
			split[i] = split[i + 1];
		}
		split[split.length - 1 ] = ' ';
		System.out.println(String.valueOf(split));
		
		System.out.println("\nNow we'll remove the last characer: ");
		split[split.length - 2] = ' ';
		System.out.println(String.valueOf(split));
	}
}
