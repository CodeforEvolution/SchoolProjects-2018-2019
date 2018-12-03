package Employees;

public class EngineeringStudent extends Student {
	private String engineerType;
	
	public EngineeringStudent(String theName, int theNumCourses, String typeOfEngineer)
	{
		super(theName, theNumCourses);
		engineerType = typeOfEngineer;
	}
	
	public void newEngineerField(String theField)
	{
		engineerType = theField;
	}
	
	public String toString()
	{
		String out = super.toString();
		out += "\nEngineer Type: " + engineerType;
		return out;
	}
}
