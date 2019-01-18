package BuiltinSort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Commercial implements Comparable<Commercial> {
	public static void main(String[] args)
	{
		ArrayList<Commercial> arrays = new ArrayList<Commercial>();
		
		arrays.add(new Commercial("Eggs"));
		arrays.add(new Commercial("Car"));
		arrays.add(new Commercial("MKWii"));
		arrays.add(new Commercial("Monoprice"));
		arrays.add(new Commercial("Volcanos"));
		
		for (int i = 0; i < 10; i++)
		{
			arrays.get(new Random().nextInt(arrays.size())).showCommercial(new Random().nextInt(5) + 1);
		}
		
		System.out.println("The initial array: " + arrays);
		
		Collections.sort(arrays);
		
		System.out.println("\nArray sorted by annual sales: " + arrays);
		
		double median = 0.0;
		
		if (arrays.size() % 2 == 0)
		{
			median = (arrays.get((arrays.size() / 2) - 1).getSales() + arrays.get(arrays.size() / 2).getSales()) / 2.0;
		}
		else
		{
			median = arrays.get(arrays.size() / 2).getSales();
		}
		
		System.out.println("\nThe median of all annual sales: " + median);
	}
	
	private String product;
	private int sales;
	private int numberAds;
	
	public Commercial(String theProduct)
	{
		product = theProduct;
		sales = new Random().nextInt(100) + 1;
		numberAds = 0;
	}
	
	public void showCommercial(int countAds)
	{
		numberAds += countAds;
		sales += new Random().nextInt(20) + 1;
	}
	
	public int compareTo(Commercial otherCompany)
	{
		if (this.getSales() < otherCompany.getSales())
		{
			return -1;
		}
		else if (this.getSales() > otherCompany.getSales())
		{
			return 1;
		}
		else
		{
			return 0;
		}
	}
	
	public int getSales()
	{
		return sales;
	}
	
	public String toString()
	{
		String out = "";
		
		out += "\nThe Product: " + product + "\n";
		out += "\tAnnual Sales: " + sales + "\n";
		out += "\tNumber of Ads: " + numberAds + "\n";
		
		return out;
	}
}
