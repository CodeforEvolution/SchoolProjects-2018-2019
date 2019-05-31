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
		currentTime += welcome.getArrivalTime() - currentTime;

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
		if ((moreCustomers() == false) ||
			(countedCustomers() < maxLine && shouldAdd()))
			addCustomer();

		if (moreCustomers() && currentCustomer().isServing() == false)
		{
			if (currentCustomer().isFinished() == false)
				currentCustomer().startService(currentTime);
			else
			{
				throw new IllegalStateException("Well, that was a stubborn customer...");
			}
		}
		else
		{
			if (currentCustomer().serviceComplete(currentTime))
			{
				System.out.println("\nThank you #" + currentCustomer().getID() + " for buying a ticket!\n");
				System.out.println("Transaction finished at " + currentTime + " seconds.");
				nextCustomer();
			}
			else
			{
				System.out.println("\nWaiting on customer #" + currentCustomer().getID() + ".");
				System.out.println("They'll finish at " + currentCustomer().getFinishTime() + " seconds!");
			}
		}

		currentTime++;
	}

	private boolean shouldAdd()
	{
		return (int)(Math.random() * 10) > 4;
	}

	public String toString()
	{
		String out = "";

		out += "Current Time in Seconds: " + currentTime + "\n";
		out += "People in Line:\n" + waitorsGonnaWait + "\n";

		return out;
	}


}
