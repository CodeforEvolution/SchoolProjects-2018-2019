import java.util.Random;


public class StudentIQ {
	private String name;
	private int iq;
	
	public StudentIQ(String nameThisPerson)
	{
		name = nameThisPerson;
		iq = new Random().nextInt(86) + 75 ;
	}
	
	public StudentIQ(String nameThisPerson, int theirIQ)
	{
		name = nameThisPerson;
		iq = theirIQ;
	}
	
	public String getName()
	{
		return name;
	}
	
	public int getIQ()
	{
		return iq;
	}
}
