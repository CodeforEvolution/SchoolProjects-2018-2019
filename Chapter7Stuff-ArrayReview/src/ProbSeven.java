import java.util.Scanner;


public class ProbSeven {
	public static void main(String[] args)
	{
		String[] letters = {"F", "D-", "D", "D+", "C-", "C", "C+", "B-", "B", "B+", "A-", "A"};
		int[] minPercent = {0, 60, 63, 67, 70, 73, 77, 80, 83, 87, 90, 93};
		String outGrade = "Yeah...you didn't enter a valid grade...";
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("Please enter a percent (Ex: 53), you will receive a grade in return : ");
		int inPercent = Integer.parseInt(in.next());
		
		if (inPercent > -1 && inPercent <= 93)
		{
			for (int i = 0; i < minPercent.length; i++)
			{
				if (inPercent < minPercent[i])
				{
					outGrade = letters[i - 1];
					break;
				}
			}
		}
		else if (inPercent > 93)
		{
			
		}
		
		System.out.println("\nYour letter grade: " + outGrade);
		
		
	}
}
