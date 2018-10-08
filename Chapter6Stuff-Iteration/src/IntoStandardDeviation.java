import java.util.ArrayList;
import java.util.Scanner;


public class IntoStandardDeviation {
	public static void main(String[] args)
	{
		ArrayList<Double> input = new ArrayList<Double>();
		Scanner in = new Scanner(System.in);
		double sum = 0.0;
		double sumSq = 0.0;
		double average = 0.0;
		double standardD = 0.0;
		int index = 0;
		char temp[] = null;
		
		System.out.println("Please enter some numbers, when you are done typing, type 'e' and press enter: ");
		in.useDelimiter("e");
		temp = in.next().toCharArray();
		in.close();
		
		index = 0;
		String current = "";
		while (index < temp.length)
		{
			if (temp[index] == ' ')
			{
				input.add(Double.parseDouble(current));
				current = "";
			}
			else
			{
				current += temp[index];
			}
			
			if (index == temp.length - 1)
				input.add(Double.parseDouble(current));
			
			index++;
		}
		
		for (int i = 0; i < input.size(); i++)
		{
			sum += input.get(i);
			sumSq += Math.pow(input.get(i), 2);
		}
		
		average = sum / input.size();
		
		standardD = Math.sqrt((sumSq - (1.0 / input.size()) * (Math.pow(sum, 2))) / (input.size() - 1));
		
		System.out.println();
		System.out.println("You entered " + input.size() + " number(s).");
		System.out.println("The Average is " + average + ".");
		System.out.println("The Standard Deviation is " + standardD + ".");
	}
}
