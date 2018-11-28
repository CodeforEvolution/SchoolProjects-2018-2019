package Measurable;

/**
	This program tests the DataSet class.
*/
public class DataSetTester
{
	public static void main(String[] args)
	{
      DataSet bankData = new DataSet();

      bankData.add(new BankAccount(0));
      bankData.add(new BankAccount(10000));
      bankData.add(new BankAccount(2000));

      System.out.println("Average balance: " 
            + bankData.getAverage());
     // System.out.println("Expected: 4000");
      Measurable max = bankData.getMaximum();
      System.out.println("Highest balance: " 
         + max.getMeasure());
     // System.out.println("Expected: 10000");
     
      DataSet coinData = new DataSet();

      coinData.add(new Coin(0.25, "quarter"));
      coinData.add(new Coin(0.1, "dime"));
      coinData.add(new Coin(0.05, "nickel"));

      System.out.println("Average coin value: " 
            + coinData.getAverage());
     // System.out.println("Expected: 0.133");            
      max = coinData.getMaximum();
      System.out.println("Highest coin value: " 
            + max.getMeasure());
     // System.out.println("Expected: 0.25");          
      
     //Jake's work - Reactor
      DataSet reactorData = new DataSet();
      
      reactorData.add(new FusionReactor("ITER", 100.5));
      reactorData.add(new FusionReactor("SPARC", 20.8));
      reactorData.add(new FusionReactor("PROTO", 129.9));
      
      System.out.println("Average amount of crazy atoms in the reactor: " + reactorData.getAverage());

      max = reactorData.getMaximum();
      System.out.println("Largest amount of crazy atoms in a reactor: " + max.getMeasure());
      
      //Dice
      DataSet diceSet = new DataSet();
      
      Die dieing = new Die();
      dieing.roll();
      Die theDie = new Die();
      theDie.roll();
      Die bigDie = new Die();
      bigDie.roll();
      
      diceSet.add(dieing);
      diceSet.add(theDie);
      diceSet.add(bigDie);
      
      System.out.println("Max roll: " + diceSet.getMaximum().getMeasure());
      System.out.println("Minimum roll: " + diceSet.getMinimum().getMeasure());
      System.out.println("Average roll: " + diceSet.getAverage());
	}
}

