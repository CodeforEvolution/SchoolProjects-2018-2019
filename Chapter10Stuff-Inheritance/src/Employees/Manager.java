package Employees;

public class Manager extends Employee {
	private String myDepart;
	
	public Manager(String theName, double theSalary, String theDepartment)
	{
		super(theName, theSalary);
		myDepart = theDepartment;
	}
	
	public String toString()
	{
		String out = super.toString();
		out += "\n\tDepartment: " + myDepart;
		return out;
	}
}
