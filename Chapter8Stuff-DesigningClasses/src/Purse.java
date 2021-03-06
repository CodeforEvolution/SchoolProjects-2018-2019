import java.util.ArrayList;


public class Purse implements Comparable {
	private ArrayList<Double> storage;
	private int coinsInPurse;
	
	public Purse()
	{
		storage = new ArrayList<Double>();
		coinsInPurse = 0;
	}
	
	public void addCoin(Coin coinToAdd)
	{
		coinsInPurse++;
		storage.add(coinToAdd.getValue());
	}
	
	public int numberOfCoins()
	{
		return coinsInPurse;
	}
	
	public double valueOfCoins()
	{
		double total = 0.0;
		
		for (double x: storage)
		{
			total += x;
		}
		
		return total;
	}
	
	public double averageCoinVal()
	{
		return valueOfCoins() / numberOfCoins();
	}
	
	public double[] getArrayVals()
	{
		double[] outArray = new double[storage.size()];
		
		for (int i = 0; i < storage.size(); i++)
		{
			outArray[i] = storage.get(i);
		}
		
		return outArray;
	}

	@Override
	public int compareTo(Object toCompare) {
		Purse other = (Purse)toCompare;
		
		if (this.valueOfCoins() < other.valueOfCoins())
		{
			return -1;
		}
		else if (this.valueOfCoins() > other.valueOfCoins())
		{
			return 1;
		}
		else
		{
			return 0;
		}
	}
}
