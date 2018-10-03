
public class Month {
	private int monthDays;
	private String monthName;
	
	public Month(int monthInt)
	{
		switch (monthInt)
		{
			case 1:
				monthName = "January";
				break;
			case 2:
				monthName = "Febuary";
				break;
			case 3:
				monthName = "March";
				break;
			case 4:
				monthName = "April";
				break;
			case 5:
				monthName = "May";
				break;
			case 6:
				monthName = "June";
				break;
			case 7:
				monthName = "July";
				break;
			case 8:
				monthName = "August";
				break;
			case 9:
				monthName = "September";
				break;
			case 10:
				monthName = "October";
				break;
			case 11:
				monthName = "November";
				break;
			case 12:
				monthName = "December";
				break;
			default:
				monthName = "Error";
				break;
		}
		
		switch (monthInt)
		{
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				monthDays = 31;
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				monthDays = 30;
				break;
			case 2:
				monthDays = 28;
				break;
			default:
				monthDays = -1;
				break;
		}
	}
	
	public String getMonth()
	{
		return monthName;
	}
	
	public int getDays()
	{
		return monthDays;
	}
}
