
public class LoopA {
	public static void main(String[] args)
	{
		for (int i = 3; i <= 25; i++)
		{
			System.out.print(i + " ");
		}
		System.out.println();
		
		int sum = 0;
		int index = 3;
		
		while (index <= 25)
		{
			sum += index;
			index++;
		}
		
		System.out.println("\nThe sum of those numbers: " + sum);
	}
}
