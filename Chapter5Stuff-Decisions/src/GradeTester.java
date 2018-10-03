import java.util.Scanner;


public class GradeTester {
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		System.out.println("Please enter a letter grade to convert to a percent: ");
		String inGrade = in.next();
		in.close();
		
		Grade theGrade = new Grade(inGrade);
		
		System.out.print("Alright, the number grade for " + theGrade.getLetterGrade() + " is " + theGrade.getNumericGrade());
	}

}
