package FilmTickets;

public class Customer {
	public static int currentID = 0;

	public enum Speed {SLOW, MEDIUM, FAST};

	public int myID;
	public int myArrivalTime;
	public Speed mySpeed;
	public boolean myServiceFinished;
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

		myServiceFinished = false;
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

	public double getFinishTime()
	{
		return myServiceFinishTime;
	}

	public Speed getSpeed()
	{
		return mySpeed;
	}

	public boolean isServing()
	{
		return myServiceFinishTime != -1;
	}

	public boolean isFinished()
	{
		return myServiceFinished;
	}

	public void startService(int currentTime)
	{
		if (myServiceFinished == false && myServiceFinishTime == -1)
		{
			myServiceFinishTime = currentTime + getTimeForSpeed(mySpeed);
			return;
		}

		throw new IllegalStateException();
	}

	public boolean serviceComplete(int currentTime)
	{
		if (myServiceFinishTime != -1)
		{
			if (currentTime >= myServiceFinishTime)
			{
				myServiceFinished = true;
				myServiceFinishTime = -1;
				return true;
			}
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
				return 5;
			case MEDIUM:
				return 10;
			case SLOW:
				return 15;
			default:
				return -1;
		}
	}
}
