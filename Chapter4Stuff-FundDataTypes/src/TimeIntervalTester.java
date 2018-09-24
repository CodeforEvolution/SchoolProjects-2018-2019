import java.util.Scanner;


public class TimeIntervalTester {
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		
		System.out.println("Please enter a 1st time in military format: ");
		String firstTime = in.next();
		
		System.out.println("Now, please enter a 2nd time in military format: ");
		String secondTime = in.next();
		
		TimeInterval calc = new TimeInterval(Integer.parseInt(firstTime), Integer.parseInt(secondTime));
		
		System.out.println("\nDifference:");
		System.out.println(calc.getHours() + " Hours " + calc.getMinutes() + " Minutes");
	} 
}
