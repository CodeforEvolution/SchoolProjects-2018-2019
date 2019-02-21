package Games;

import java.io.File;
import java.util.ArrayList;
import java.util.Random;

public class MadMarchSim {
	public static final int TEAMS_PER_REGION = 4;
	public static final String[] teamNames = {
														};
	
	public static Random rEngine = new Random();
	public static File input = new File(ClassLoader.getResource("Games/nba-teams.txt"));

	{
		ArrayList<Team> teams = new ArrayList<Team>();
		
		// Fill team array with 16 teams for each of the 4 regions
		for (int region = 1; region <= 4; region++)
		{
			for (int seed = 1; seed <= TEAMS_PER_REGION; seed++)
			{
				teams.add(new Team(teamNames[region * seed], null, seed));
			}
		}
	}
}
