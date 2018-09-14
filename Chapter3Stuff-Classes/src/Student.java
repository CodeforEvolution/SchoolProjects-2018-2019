
public class Student {
	private String myName;
	private double scoreTotal;
	private int numOfQuiz;
	
	public Student(String name)
	{
		myName = name;
		scoreTotal = 0.0;
		numOfQuiz = 0;
	}
	
	public void addQuiz(double score)
	{
		scoreTotal += score;
		numOfQuiz++;
	}
	
	public String getName()
	{
		return myName;
	}
	
	public double getAverageScore()
	{
		return scoreTotal / numOfQuiz;
	}
	
	public double getTotalScore()
	{
		return scoreTotal;
	}
	
	public String toString()
	{
		String out = "\n";
		out += getName() + ":";
		out += "\n\tTotal Quiz Score: " + getTotalScore();
		out += "\n\tAverage Quiz Score: " + getAverageScore();
		
		return out;
	}
}
