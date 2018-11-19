
public class Barcode {
	private String zipcode;
	private String barcode;
	
	public Barcode(int theZipCode)
	{
		setZip(theZipCode);
	}
	
	public Barcode(String theBarcode)
	{
		setBarcode(theBarcode);
	}
	
	public void setBarcode(String newBarcode)
	{
		barcode = newBarcode;
		convertToZipCode();
	}
	
	public void setZip(int newZipCode)
	{
		zipcode = Integer.toString(newZipCode);
		convertToBarCode();
	}
	
	private void convertToZipCode()
	{
		if (barcode.length() != 32)
		{
			zipcode = "Error";
			throw new IllegalArgumentException("Your barcode isn't formatted correctly...");
		}
		
		if (barcode.substring(barcode.length() - 5, barcode.length()).equals(":::|||"))
		{
			zipcode = "Error";
			throw new IllegalArgumentException("Your barcode isn't formatted correctly...");
		}
		
		int i = 1;
		while (i < barcode.length())
		{
			barcode += codeToNumber(barcode.substring(i, i + 5));
			i += 5;
		}
	}
	
	private String codeToNumber(String inCode)
	{
		switch (inCode)
		{
			case ":::||":
				return "1";
			case "::|:|":
				return "2";
			case "::||:":
				return "3";
			case ":|::|":
				return "4";
			case ":|:|:":
				return "5";
			case ":||::":
				return "6";
			case "|:::|":
				return "7";
			case "|::|:":
				return "8";
			case "|:|::":
				return "9";
			case "||:::":
				return "0";
			default:
				throw new NumberFormatException("Error converting barcode digit to number");
		}
	}
	
	private void convertToBarCode()
	{
		String finalBarcode = "|";
		
		for (int i = 0; i < zipcode.length(); i++)
		{
			String current = zipcode.substring(i, i + 1);
			
			switch (current)
			{
				case "1":
					finalBarcode += ":::||";
					break;
				case "2":
					finalBarcode += "::|:|";
					break;
				case "3":
					finalBarcode += "::||:";
					break;
				case "4":
					finalBarcode += ":|::|";
					break;
				case "5":
					finalBarcode += ":|:|:";
					break;
				case "6":
					finalBarcode += ":||::";
					break;
				case "7":
					finalBarcode += "|:::|";
					break;
				case "8":
					finalBarcode += "|::|:";
					break;
				case "9":
					finalBarcode += "|:|::";
					break;
				case "0":
					finalBarcode += "||:::";
					break;
				default:
					throw new NumberFormatException("Error in zipcode conversion!");
			}
		}
		finalBarcode += ":::|||";
		
		barcode = finalBarcode;
	}
	
	public String toString()
	{
		return zipcode + " : " + barcode;
	}
}
