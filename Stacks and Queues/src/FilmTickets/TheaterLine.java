package FilmTickets;

import java.util.LinkedList;
import java.util.Queue;

public class TheaterLine {
	private Queue<Customer> waitorsGonnaWait;
	private double currentTime;

	public TheaterLine()
	{
		waitorsGonnaWait = new LinkedList<Customer>();
		currentTime = 0.0;
	}

	public void addCustomer()
	{
		Customer welcome = new Customer(currentTime);
		currentTime += welcome.getArrivalTime();

		waitorsGonnaWait.add(welcome);
	}

	public Customer nextCustomer()
	{
		return waitorsGonnaWait.remove();
	}

	public boolean moreCustomers()
	{
		return !waitorsGonnaWait.isEmpty();
	}

	public int countedCustomers()
	{
		return waitorsGonnaWait.size();
	}

	public String toString()
	{
		String out = "";

		out += "Current Time: " + currentTime + "\n";
		out += "People in Line:\n" + waitorsGonnaWait + "\n";

		return out;
	}


}
