
public class Car {
	private double mpg;
	private double gallonsFuel;

	public Car(double carMPG)
	{
		mpg = carMPG;
		gallonsFuel = 0.0; 
	}
	
	public void drive(double driveMiles)
	{
		gallonsFuel -= driveMiles / mpg;
	}
	
	public void addGas(double gallonsToAdd)
	{
		gallonsFuel += gallonsToAdd;
	}
	
	public double getGasInTank()
	{
		return gallonsFuel;
	}
}
