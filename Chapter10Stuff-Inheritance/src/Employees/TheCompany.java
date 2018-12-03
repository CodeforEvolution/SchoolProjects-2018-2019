package Employees;

public class TheCompany {
	public static void main(String[] args)
	{
		Employee bob = new Employee("Bob", 1.00);
		Manager steve = new Manager("Steven", 29.43, "IT");
		Executive norman = new Executive("Normal", 329.93, "IT", "TrueTech");
		
		System.out.println(bob + "\n");
		System.out.println(steve + "\n");
		System.out.println(norman + "\n");
	}
}
