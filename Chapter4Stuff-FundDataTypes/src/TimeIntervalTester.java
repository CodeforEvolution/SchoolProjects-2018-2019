import java.util.Scanner;


public class TimeIntervalTester {
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		
		System.out.println("Please enter a 1st time in military format: ");
		int firstTime = in.nextInt();
		
		System.out.println("Now, please enter a 2nd time in military format: ");
		int secondTime = in.nextInt();
		
		TimeInterval calc = new TimeInterval(firstTime, secondTime);
		
		System.out.println("\nDifference:");
		System.out.println(calc.getHours() + " Hours " + calc.getMinutes() + " Minutes");
	} 
}
