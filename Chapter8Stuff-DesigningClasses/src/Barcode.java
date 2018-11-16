
public class Barcode {
	private String zipcode;
	private String barcode;
	
	public Barcode(int theZipCode)
	{
		setZip(theZipCode);
	}
	
	public void setZip(int newZipCode)
	{
		zipcode = Integer.toString(newZipCode);
		convertToBarCode();
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
					finalBarcode += "|:|::";
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
				case "8":
					finalBarcode += "|::|:";
					break;
				case "9":
				case "0":
					finalBarcode += "||:::";
					break;
				default:
					throw new NumberFormatException("Error in zipcode conversion!");
			}
		}
		finalBarcode += "|";
		
		barcode = finalBarcode;
	}
	
	public String toString()
	{
		return barcode;
	}
}
