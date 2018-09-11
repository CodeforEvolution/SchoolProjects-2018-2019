import java.util.Arrays;
import java.util.Random;


public class LotteryPrinter {
	public static void main(String[] args)
	{
		Random r = new Random();
		int[] lottery = new int[6];
		
		for (int i = 0; i < lottery.length; i++)
		{
			lottery[i] = r.nextInt(49) + 1;
		}
		
		System.out.println("Hey, buddy, take this lucky combo: ");
		System.out.println(Arrays.toString(lottery));
	}
}
