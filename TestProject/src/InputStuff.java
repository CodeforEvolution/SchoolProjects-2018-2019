/**
 * This is a program that will INPUT STUFF.
 * Non-string input must be converted from a string to the
 * desired variable type (with special library methods).
 */
import javax.swing.JOptionPane; 
 // input conversion library..YOU MUST ADD THIS LINE!
public class InputStuff
{
    public static void main (String[]args)
    {
        // variable declaration 
     int  x = 1;        
     char cSymbol = 'W';      
     double gradePoint = 0.012345; 
     String firstName = "Joe";  
     String lastName = "Johnson";
     String temp; // holds input for conversion 
    
     //input of string....no conversion necessary
     System.out.println("Enter the specified information");
     lastName = JOptionPane.showInputDialog ("Last Name? ");
     firstName = JOptionPane.showInputDialog ("First Name? ");
     
    // input of an integer
     temp = JOptionPane.showInputDialog ("Enter Integer ");
     x= Integer.parseInt(temp);   
     
     // Let's print out the input information
     System.out.println("\nHello " + firstName +"  "+ lastName);
     System.out.println(firstName + " is " + x + " years old");
    
     // input of a decimal (floating point) value
     temp = JOptionPane.showInputDialog ("Enter Gradepoint avg. ");
     gradePoint = Double.parseDouble(temp);
     
    // input of an character
     temp = JOptionPane.showInputDialog ("Enter Character ");
     cSymbol = temp.charAt(0);
     
      // Let's print out the rest of the input information
     System.out.print("Symbol is " + cSymbol+cSymbol+cSymbol);
     System.out.println(" New gradepoint avg. is " + gradePoint);
     }
}