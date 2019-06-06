package Operators;

import java.util.Scanner;

public class CalculatorFront {
    public static void main(String[] args)
    {
        CalculatorBackend backend = new CalculatorBackend();
        Scanner in = new Scanner(System.in);

        System.out.println("Welcome!!!");

        boolean good = false;
        do
        {
        	System.out.println("\nPlease enter an equation:");
        	System.out.print("-----> ");

        	good = backend.parse(in.nextLine());

        	if (good == false)
        		System.out.println("\nThat doesn't seem to be an equation...try again please!");
        } while (good == false);
        in.close();

        System.out.println("Solving...");
        backend.solveAll();

        System.out.print("Solution: ");
        System.out.println(backend);

        System.out.println("\nThank you for your time!");
    }
}
