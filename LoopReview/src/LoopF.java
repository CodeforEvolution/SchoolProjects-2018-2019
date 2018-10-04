import java.util.ArrayList;
import java.util.Scanner;


public class LoopF {
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		ArrayList<Double> theDecimalsGasp = new ArrayList<Double>();
		int index = 0;
		
		System.out.println("Please enter many decimals decimal, when you are done typing, type 'e' and press enter: ");
		in.useDelimiter("e");
		theDecimalsGasp.add(in.nextDouble());;
		in.close();
		
		double average = 0.0;
		do
		{
			average += theDecimalsGasp.get(index);
			index++;
		} while (index < theDecimalsGasp.size());
		
		average /= theDecimalsGasp.size();
		System.out.println("The average of your decimals: " + average);
		
		double max = theDecimalsGasp.get(0);
		for (index = 0; index < theDecimalsGasp.size(); index++)
		{
			double current = theDecimalsGasp.get(index);
			if (current > max)
				max = current;
		}
		
		System.out.println("The biggest");
	}
}
