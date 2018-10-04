
public class Card {
	private String cardNum;
	private String cardType;
	private boolean valid;
	
	public Card(String shortHand)
	{
		if (shortHand.length() != 2 && shortHand.length() != 3)
		{
			valid = false;
			return;
		}
		
		int number = 0;
		char type = ' ';
		
		if (shortHand.length() == 3)
			number = Integer.parseInt(shortHand.substring(0, 2));
		else
			number = Integer.parseInt(shortHand.substring(0, 1));
		
		switch (number)
		{
			case 2:
				cardNum = "Two";
				break;
			case 3:
				cardNum = "Three";
				break; 
			case 4:
				cardNum = "Four";
				break;
			case 5:
				cardNum = "Five";
				break;
			case 6:
				cardNum = "Six";
				break;
			case 7:
				cardNum = "Seven";
				break;
			case 8:
				cardNum = "Eight";
				break;
			case 9:
				cardNum = "Nine";
				break;
			case 10:
				cardNum = "Ten";
				break;
			case 11:
				cardNum = "Eleven";
				break;
			case 12:
				cardNum = "Twelve";
				break;
			default:
				cardNum = "Error";
				valid = false;
				return;
		}
		
		type = shortHand.charAt(shortHand.length() - 1);
		
		switch (type)
		{
			case 'A':
				cardType = "Ace";
				break;
			case 'J':
				cardType = "Jack";
				break;
			case 'Q':
				cardType = "Queen";
				break;
			case 'K':
				cardType = "King";
				break;
			case 'D':
				cardType = "Diamonds";
				break;
			case 'H':
				cardType = "Hearts";
				break;
			case 'S':
				cardType = "Spades";
				break;
			case 'C':
				cardType = "Clubs";
				break;
			default:
				valid = false;
				return;	
		}
		
		valid = true;
	}
	
	public String getDescription()
	{
		if (valid == false)
		{
			return "Unknown";
		}
		
		String out = "\n";
		out += cardNum;
		out += " of ";
		out += cardType;
		
		return out;
	}
}
