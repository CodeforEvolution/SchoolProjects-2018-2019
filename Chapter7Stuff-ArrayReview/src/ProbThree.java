import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;


public class ProbThree {
	public static void main(String[] args)
	{
		Random r = new Random();
		HashMap<Integer, Integer> occurences = new HashMap<Integer, Integer>();
		ArrayList<Integer> rangeOccur = new ArrayList<Integer>();
		
		int[] chance = new int[25];
		
		for (int i = 0; i < chance.length; i++)
		{
			chance[i] = r.nextInt(51);
		}
		
		//b
		for (int i = 0; i < chance.length; i++)
		{
			if (occurences.containsKey(chance[i]) == true)
			{
				int old = occurences.get(chance[i]);
				occurences.replace(chance[i], old, old + 1);
			}
			else
			{
				occurences.put(chance[i], 1);
			}
			
			System.out.println("Here are the occurences of all values: ");
			System.out.println(occurences);
			
			if (chance[i] >= 41)
				rangeOccur.set(4, rangeOccur.get(4) + 1);
			else if (chance[i] >= 31)
				rangeOccur.set(3, rangeOccur.get(3) + 1);
			else if (chance[i] >= 21)
				rangeOccur.set(2, rangeOccur.get(2) + 1);
			else if (chance[i] >= 11)
				rangeOccur.set(1, rangeOccur.get(1) + 1);
			else
				rangeOccur.set(0, rangeOccur.get(0) + 1);
			
			for (int k = 0; k < 5; k++)
			{
				switch (k)
				{
					case 0:
						System.out.println("1 - 10\t");
						break;
					case 1:
						System.out.println("11 - 20\t");
						break;
					case 2:
						System.out.println("21 - 30\t");
						break;
					case 3:
						System.out.println("31 - 40\t");
						break;
					case 4:
						System.out.println("41 - 50\t");
						break;
					default:
						break;
				}
				for (int v = 0; v < rangeOccur.get(k); v++)
				{
					System.out.print('*');
				}
				System.out.println();
			}
		}

		
		
	}
}
