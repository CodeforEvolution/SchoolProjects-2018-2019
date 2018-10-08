import java.util.ArrayList;
import java.util.Scanner;


public class LoopF {
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		ArrayList<Double> theDecimalsGasp = new ArrayList<Double>();
		int index = 0;
		
		System.out.println("Please enter many decimals, when you are done typing, type 'e' and press enter: ");
		in.useDelimiter("e");
		char temp[] = in.next().toCharArray();
		in.close();
		
		System.out.println(temp);
		
		index = 0;
		String current = "";
		while (index < temp.length)
		{
			if (temp[index] == ' ')
			{
				theDecimalsGasp.add(Double.parseDouble(current));
				current = "";
			}
			else
			{
				current += temp[index];
			}
			
			if (index == temp.length - 1)
				theDecimalsGasp.add(Double.parseDouble(current));
			
			index++;
		}
		
		System.out.println(theDecimalsGasp);
		
		index = 0;
		double average = 0.0;
		do
		{
			average += theDecimalsGasp.get(index);
			index++;
		} while (index < theDecimalsGasp.size());
		
		average /= theDecimalsGasp.size();
		System.out.println("\nThe average of your decimals: " + average);
		
		double max = theDecimalsGasp.get(0);
		for (index = 0; index < theDecimalsGasp.size(); index++)
		{
			double theDec = theDecimalsGasp.get(index);
			if (theDec > max)
				max = theDec;
		}
		
		System.out.println("The biggest decimal is: " + max);
	}
}
