package FilmTickets;

public class Customer {
	public static int currentID = 0;

	public enum Speed {SLOW, MEDIUM, FAST};

	public int myID;
	public int myArrivalTime;
	public Speed mySpeed;
	public boolean myServicing;
	public int myServiceFinishTime;

	public Customer(int currentTime)
	{
		myID = currentID++;

		myArrivalTime = currentTime;

		switch ((int)(Math.random() * 3))
		{
			case 0:
				mySpeed = Speed.SLOW;
				break;
			case 1:
				mySpeed = Speed.MEDIUM;
				break;
			case 2:
			default:
				mySpeed = Speed.FAST;
				break;
		}

		myServicing = false;
		myServiceFinishTime = -1;
	}

	public int getID()
	{
		return myID;
	}

	public double getArrivalTime()
	{
		return myArrivalTime;
	}

	public Speed getSpeed()
	{
		return mySpeed;
	}

	public void startService(int currentTime)
	{
		if (myServicing == false)
		{
			myServicing = true;
			myServiceFinishTime = currentTime + getTimeForSpeed(mySpeed);
		}

		throw new IllegalStateException();
	}

	public boolean serviceComplete(int currentTime)
	{
		if (myServicing == true)
		{
			if (currentTime >= myServiceFinishTime)
				return true;
			return false;
		}

		throw new IllegalStateException();
	}

	public String toString()
	{
		String out = "";

		out += "\nI'm #" + myID + "!\n";
		out += "I arrived at " + myArrivalTime + ".\n";
		out += "I'm going " + getSpeedString(mySpeed) + "!\n";

		return out;
	}

	public static String getSpeedString(Speed theSpeed)
	{
		switch (theSpeed)
		{
			case FAST:
				return "fast";
			case MEDIUM:
				return "steady";
			case SLOW:
				return "slow";
			default:
				return "unknown";
		}
	}

	public static int getTimeForSpeed(Speed theSpeed)
	{
		switch (theSpeed)
		{
			case FAST:
				return 10;
			case MEDIUM:
				return 30;
			case SLOW:
				return 50;
			default:
				return -1;
		}
	}
}
