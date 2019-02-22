package Games;

import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import Games.Team.Region;

public class MadMarchSim {
	public static Random rEngine = new Random();
	public static int REGION_COUNT = Region.values().length;

	public static void main(String[] args) throws Exception {
		ArrayList<Team> teams = new ArrayList<Team>();
		ArrayList<Team> winners = new ArrayList<Team>();

		ArrayList<String> teamNames = new ArrayList<String>();

		File input = new File(ClassLoader.getSystemClassLoader().getResource("Games/nba-teams.txt").toURI());
		Scanner inEngine = new Scanner(input);

		while (inEngine.hasNextLine()) {
			teamNames.add(inEngine.nextLine());
		}
		inEngine.close();

		// Fill team array with 16 teams for each of the 4 regions
		for (Region region : Region.values()) {
			for (int seed = 1; seed <= teams.size() / 4; seed++) {
				teams.add(new Team(teamNames.get(region.getValue() * seed), region, seed));
			}
		}

		for (int i = 0; i < teams.size() / REGION_COUNT / 2; i++) {
		}

		System.out.println(teamNames);
	}

	public static Team findTeam(ArrayList<Team> teams, Region theRegion, int seed) {
		for (int i = 0; i < teams.size(); i++)
		{
			Team currTeam = teams.get(i);

			if (currTeam.getRegion() == theRegion && currTeam.getSeed() == seed)
				return currTeam;
		}
		return null;
	}
}
