import java.util.Scanner;


public class MonthTester {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		System.out.println("Please enter a month (1-12): ");
		int inMonth = in.nextInt();
		in.close();
		
		Month yoMonth = new Month(inMonth);
		System.out.println("\nNow, the month of " + yoMonth.getMonth() + " has " + yoMonth.getDays() + " days." );
	}
}
