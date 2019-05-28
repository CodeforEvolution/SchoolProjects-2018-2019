package FilmTickets;

public class Customer {
	public static int currentID = 0;

	public enum Speed {SLOW, MEDIUM, FAST};

	public int myID;
	public double myArrivalTime;
	public Speed mySpeed;

	public Customer(double currentTime)
	{
		myID = currentID++;

		double nextTime = (Math.random() * 50.0) + 1.0;
		myArrivalTime = currentTime + nextTime;

		switch ((int)(Math.random() * 3))
		{
			case 0:
				mySpeed = Speed.SLOW;
				break;
			case 1:
				mySpeed = Speed.MEDIUM;
				break;
			case 2:
				mySpeed = Speed.FAST;
				break;
			default:
				mySpeed = Speed.FAST;
				break;
		}
	}

	public int getID()
	{
		return myID;
	}

	public double getArrivalTime()
	{
		return myArrivalTime;
	}

	public int getSpeed()
	{
		return mySpeed;
	}

	public String toString()
	{
		String out = "";

		out += "I'm #" + myID + "!\n";
		out += "I'm "
	}
}
