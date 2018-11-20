/**   Interfaces:  "encapulates a set of behaviors that can be used
 *                  by dissimilar classes"
 *    'Comparable' is an interface with one method: compareTo
 */

public class Vegetable implements Comparable
{
	private double weight;
	private String name;
         
	public Vegetable (String vName, double w)  
	{
		weight = w;
		name = vName;
	}
          
	public double getWeight () 
        {   return weight; }
          
	public String getName () 
        {   return name;   }
        
  //public Vegetable mash ( Vegetable veggie2)  // complete 'mash' method that will
      //{                                   // return a new vegetable after adding weights 
                                         // together and combining substrings from each name
      //}
              
	public String toString()  
	{   return "Healthy " + name + " : " + weight + " ounces" ;  }
  
    public int compareTo (Object obj)      //  method to compare one object to another
                                           //  compareTo is method in Comparable interface
    {
        double otherNum = ((Vegetable)obj).getWeight();     // must cast Object to Class type
        if ( weight < otherNum)
            return -1;
        else if ( weight > otherNum)
            return 1;
        else
            return 0;
    }   

    public static void main(String[]args)
	{                                         // test program w/ different weights for v1,v2
		Vegetable v1 = new Vegetable("potato", 3.1); 
		Vegetable v2 = new Vegetable("carrot", 4.7); 
		System.out.println(v1);
		System.out.println(v2); 
	if ( v1.compareTo(v2) < 0 )
	{
		Object[] diff = new Object[1];
		diff[0] = new Double(v2.getWeight()-v1.getWeight());
		System.out.print ( v1.getName() + " is < by ");
		System.out.format("%.2f%n", diff);
	}
	else if ( v1.compareTo(v2) > 0 )
		System.out.println ( v1.getName() + " is bigger than " + v2.getName() );
	else
		System.out.println ( v1.getName() + " is same weight as " + v2.getName() );
            
	// Vegetable v3 = v1.mash(v2);
	// System.out.println(v3);
	//  use compareTo method with v3 and previous "Vegetables"                      
  }
}

