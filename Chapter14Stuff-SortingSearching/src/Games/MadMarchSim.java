package Games;

import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import Games.Team.Region;

public class MadMarchSim {
	public static Random rEngine = new Random();
	public static int REGION_COUNT = Region.values().length - 1;

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
		for (Region region : Region.values())
		{
			for (int seed = 1; (seed - 1) < teamNames.size() / REGION_COUNT / 2; seed++)
			{
				teams.add(new Team(teamNames.get(region.getValue() * seed), region, seed));
			}
		}

		Region currRegion = Region.UNKNOWN;
		for (int r = 1; r < REGION_COUNT + 1; r++)
		{
			currRegion = Region.enumForValue(r);
			for (int i = 1; i < ((teams.size() / REGION_COUNT) / 2) + 1; i++)
			{
				Team destToWin = findTeam(teams, currRegion, i);
				Team destToLose = findTeam(teams, currRegion, (teams.size() / REGION_COUNT) + 1 - i);


				Team winner = randomWinner(destToWin, destToLose);

				System.out.println("\nNow for the " + destToWin.getSeed() + " seed and " + destToLose.getSeed() + " seed:");
				System.out.println("It's " + destToWin.getName() + " versus " + destToLose.getName() + " in the " + currRegion + " Region!");
				System.out.println("The winner is..." + winner.getName() + " !");

				winners.add(winner);
			}
		}

		System.out.println(winners);
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

	public static Team randomWinner(Team a, Team b) {
		if (a.compareTo(b) < 0)
		{
			if (rEngine.nextInt(20) > 5)
			{
				return a;
			}
			else
			{
				return b;
			}
		}
		else if (b.compareTo(a) > 0)
		{
			if (rEngine.nextInt(20) > 5)
			{
				return b;
			}
			else
			{
				return a;
			}
		}

		return null;
	}
}
