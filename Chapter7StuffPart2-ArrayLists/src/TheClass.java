import java.util.ArrayList;


public class TheClass {
	public static void main(String[] args)
	{
		ArrayList<StudentIQ> classroom = new ArrayList<StudentIQ>();
		classroom.add(new StudentIQ("Jeff", 9001));
		classroom.add(new StudentIQ("Yolo"));
		classroom.add(new StudentIQ("Clyde", 130));
		classroom.add(new StudentIQ("Ham"));
		
		int count = 0;
		double average = 0.0;
		for (int i = 0; i < classroom.size(); i++)
		{
			StudentIQ temp = classroom.get(i);
			
			System.out.println("It's " + temp.getName() + " with a " + temp.getIQ() + " iq score!");
			
			average += temp.getIQ();
			if (temp.getIQ() > 120)
			{
				count++;
			}
		}
		average /= classroom.size();
		
		System.out.println("\nThe average of all the IQ scores: " + average);
		System.out.println("The amount of IQ scores greater than 120: " + count);
		
		System.out.println("\nSay goodbye to all your progress!");
		for (int i = classroom.size() - 1; i >= 0; i--)
		{
			if (classroom.get(i).getIQ() % 2 == 0)
			{
				classroom.remove(i);
			}
		}
		
		System.out.println("\nWho is left? : ");
		for (int i = 0; i < classroom.size(); i++)
		{
			StudentIQ temp = classroom.get(i);
			System.out.println(temp.getName() + " with a " + temp.getIQ() + " iq score!");
		}
		
	}
}
