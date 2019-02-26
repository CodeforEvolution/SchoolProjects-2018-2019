package Games;

public class Team implements Comparable<Team> {
	public enum Region
	{
		NORTH(1), SOUTH(2), MIDWEST(3), EAST(4);

		private int internalRep;

		Region(int internal)
		{
			internalRep = internal;
		}

		public int getValue()
		{
			return internalRep;
		}

		public static Region enumForValue(int value)
		{
			switch (value)
			{
				case 1:
					return NORTH;
				case 2:
					return SOUTH;
				case 3:
					return MIDWEST;
				case 4:
					return EAST;
				default:
					return null;
			}
		}

		public String toString()
		{
			switch (internalRep)
			{
				case 1:
					return "North";
				case 2:
					return "South";
				case 3:
					return "Midwest";
				case 4:
					return "East";
				case 5:
					return "Unknown";
				default:
					return "Error";
			}
		}
	};

	private String fName;
	private Region fRegion;
	private Integer fSeed;

	public Team(String name, Region startRegion, int seed)
	{
		fName = name;
		fRegion = startRegion;
		fSeed = seed;
	}

	public String getName()
	{
		return fName;
	}

	public Region getRegion()
	{
		return fRegion;
	}

	public Integer getSeed()
	{
		return fSeed;
	}

	public int compareTo(Team other)
	{
		if (this.getSeed() < other.getSeed())
		{
			return -1;
		}
		else if (this.getSeed() > other.getSeed())
		{
			return 1;
		}
		else
		{
			return 0;
		}
	}

	public String toString()
	{
		String out = "";

		out += "\nTeam: " + fName;
		out += "\n\tRegion: " + fRegion;
		out += "\n\tSeed: " + fSeed;

		return out;
	}
}
