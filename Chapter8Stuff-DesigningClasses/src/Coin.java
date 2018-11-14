
public class Coin {
	enum Coin_Type {PENNY, NICKEL, DIME, QUARTER, CUSTOM};
	
	private Coin_Type coinType;
	private double coinVal;
	
	public Coin(Coin_Type theCoin)
	{
		coinType = theCoin;
		coinVal = coinValForType(coinType);
	}
	
	public Coin(String theType, double value)
	{
		switch (theType.toLowerCase())
		{
			case "penny":
				coinType = Coin_Type.PENNY;
				break;
			case "nickel":
				coinType = Coin_Type.NICKEL;
				break;
			case "dime":
				coinType = Coin_Type.DIME;
				break;
			case "quarter":
				coinType = Coin_Type.QUARTER;
				break;
			default:
				coinType = Coin_Type.CUSTOM;
				coinVal = value;
				return;
		}
		coinVal = coinValForType(coinType);
	}
	
	private double coinValForType(Coin_Type theCoin)
	{
		switch (theCoin)
		{
			case DIME:
				return 0.10;
			case NICKEL:
				return 0.05;
			case PENNY:
				return 0.01;
			case QUARTER:
				return 0.25;
			default:
				return -1.0;
		}
	}
	
	public double getValue()
	{
		return coinVal;
	}
	
	public String toString()
	{
		String out = "";
		
		switch (coinType)
		{
			case DIME:
				out += "Dime";
				break;
			case NICKEL:
				out += "Nickel";
				break;
			case PENNY:
				out += "Penny";
				break;
			case QUARTER:
				out += "Quarter";
				break;
			case CUSTOM:
				out += "$" + coinVal + " coin";
			default:
				out += "Error";
				break;
		}
		
		return out;
	}
}
