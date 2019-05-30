package FilmTickets;

import java.util.LinkedList;
import java.util.Queue;

public class TheaterLine {
	private Queue<Customer> waitorsGonnaWait;
	private int currentTime;
	private int maxLine;

	public TheaterLine(int maxLineLength)
	{
		waitorsGonnaWait = new LinkedList<Customer>();
		currentTime = 0;
		maxLine = maxLineLength;
	}

	public void addCustomer()
	{
		Customer welcome = new Customer(currentTime);
		currentTime += welcome.getArrivalTime();

		waitorsGonnaWait.add(welcome);
	}

	public Customer currentCustomer()
	{
		return waitorsGonnaWait.peek();
	}

	public void nextCustomer()
	{
		waitorsGonnaWait.remove();
	}

	public boolean moreCustomers()
	{
		return !waitorsGonnaWait.isEmpty();
	}

	public int countedCustomers()
	{
		return waitorsGonnaWait.size();
	}

	public double getCurrentTime()
	{
		return currentTime;
	}

	public void heartbeat()
	{
		if (moreCustomers() == false ||
			countedCustomers() < maxLine && (int)(Math.random() * 2) > 0)
			addCustomer();

		if (moreCustomers() && currentCustomer().serviceComplete(currentTime) == false)
			currentCustomer().startService(currentTime);

		currentTime++;
	}

	public String toString()
	{
		String out = "";

		out += "Current Time in Seconds: " + currentTime + "\n";
		out += "People in Line:\n" + waitorsGonnaWait + "\n";

		return out;
	}


}
