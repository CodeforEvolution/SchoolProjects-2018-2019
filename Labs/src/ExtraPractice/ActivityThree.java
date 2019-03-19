package ExtraPractice;

public class ActivityThree {
	public static void main(String[] args)
	{
		System.out.println("Heads or Tails?: " + flip() + "!");

		int[] testA = {1, 2, 3};
		int[] testB = {1, 4, 2};

		System.out.println("Permutations?: " + arePermutations(testA, testB));
	}

	public static String flip()
	{
		switch((int)(3 * Math.random()))
		{
			case 0:
			case 1:
				return "heads";
			default:
				return "tails";
		}
	}

	public static boolean arePermutations(int[] arrayA, int[] arrayB)
	{
		boolean found = false;
		for (int aCount = 0; aCount < arrayA.length; aCount++)
		{
			found = false;
			for (int bCount = 0; bCount < arrayB.length; bCount++)
			{
				if (arrayB[bCount] == arrayA[aCount])
				{
					found = true;
				}
			}

			if (found == false)
				return false;
		}

		return true;
	}
}
