
public class Grade {
	private String letterGrade;
	private double numericGrade;
	
	public Grade(String gradeIn)
	{
		letterGrade = gradeIn;
		
		char letter = letterGrade.charAt(0);
		
		switch (letter)
		{
			case 'A':
				numericGrade = 4.0;
				break;
			case 'B':
				numericGrade = 3.0;
				break;
			case 'C':
				numericGrade = 2.0;
				break;
			case 'D':
				numericGrade = 1.0;
				break;
			case 'F':
				numericGrade = 0.0;
				break;
			default:
				numericGrade = 0.0;
				return;
		}
		
		if (letterGrade.length() > 1 && letter != 'F')
		{
			char symbol = letterGrade.charAt(1);
			
			if (letter == 'A' && symbol == '+')
				return;
			
			switch (symbol)
			{
				case '+':
					numericGrade += 0.3;
					break;
				case '-':
					numericGrade -= 0.3;
					break;
				default:
					break;
			}
		}
	}
	
	public String getLetterGrade()
	{
		return letterGrade;
	}
	
	public double getNumericGrade()
	{
		return numericGrade;
	}
}
