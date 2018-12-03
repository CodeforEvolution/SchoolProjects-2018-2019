package Workers;

public class TheWorkers {
	public static void main(String[] args)
	{
		Worker work = new HourlyWorker("Bob", 40);
		Worker ahh = new SalariedWorker("Jim", 40);
		
		System.out.println(work.getName() + " will receive " + work.computePay(30) + " for working 30 hours.");
		System.out.println(ahh.getName() + " will receive " + ahh.computePay(44) + " for working 44 hours.");
	}
}
