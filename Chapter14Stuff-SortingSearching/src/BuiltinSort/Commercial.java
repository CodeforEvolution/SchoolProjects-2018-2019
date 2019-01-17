package BuiltinSort;

import java.util.Random;

public class Commercial implements Comparable {
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
	}
	
	public int compareTo(Object otherCompany)
	{
		if (otherCompany instanceof Commercial == false)
		{
			throw new IllegalArgumentException("Can't compare a non-commercial!");
		}
	}
	
	public String toString()
	{
		String out = "";
		
		out += "The Product: " + product + "\n";
		out += "\tAnnual Sales: " + sales + "\n";
		out += "\tNumber of Ads: " + numberAds + "\n";
		
		return out;
	}
}
