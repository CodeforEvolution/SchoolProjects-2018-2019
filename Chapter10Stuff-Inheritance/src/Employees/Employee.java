package Employees;

public class Employee {
	private String myName;
	private double mySalary;
	
	public Employee(String theName, double theSalary)
	{
		myName = theName;
		mySalary = theSalary;
	}
	
	public String toString()
	{
		String out = "";

		out += myName + ":\n";
		out += "\tSalary: " + mySalary;
		
		return out;
	}
}
