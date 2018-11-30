
public class Executive extends Manager {
	private String myCompany;
	
	public Executive(String theName, double theSalary, String theDepartment, String theCompany)
	{
		super(theName, theSalary, theDepartment);
		myCompany = theCompany;
	}
	
	public String toString()
	{
		String out = super.toString();
		out += "\n\tCompany: " + myCompany;
		return out;
	}
}
