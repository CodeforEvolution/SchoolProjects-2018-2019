package Employees;

/**
 *   Example with Parent class (Student) & Child class (StudentAthlete)
 */
public class Nicolet
{
	public static void main(String[]args)
	{
	    Student Tommy = new Student ("Tommy", 5);
	    StudentAthlete Zach = new StudentAthlete ("Zach",5,"Swimming");
	    EngineeringStudent Jake = new EngineeringStudent("Jake", 7, "Computer");
	    
	    System.out.println(Tommy);
	    System.out.println();
	    
	    Tommy.addCourse(2);
	    Tommy.changeName("Sparky");
	    System.out.println(Tommy);
	    System.out.println();
	    
	    System.out.println(Zach);
	    System.out.println();
	    
	    Zach.addCourse(1);
	    Zach.changeSport("Football");
	    System.out.println(Zach);
	    System.out.println();
	    
	    System.out.println(Jake);
	    System.out.println();
	    
	    Jake.addCourse(1);
	    Jake.newEngineerField("Mechanical");
	    System.out.println(Jake);
	    System.out.println();
	    
	   
	   
	    
	   }
}