package Games;

import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import Games.Team.Region;

public class MadMarchSim {
	public static Random rEngine = new Random();
	public static int REGION_COUNT = Team.Region.values().length;

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

		int teamsPerRegion = teamNames.size() / REGION_COUNT;

		// Fill team array with 16 teams for each of the 4 regions
		int loop = 0;
		for (Region region : Region.values())
		{
			for (int seed = 1; (seed - 1) < teamsPerRegion; seed++)
			{
				int nameIndex = (teamsPerRegion * loop) + seed - 1;
				teams.add(new Team(teamNames.get(nameIndex), region, seed));
			}
			loop++;
		}

		System.out.println();
		System.out.println(teams);
		System.out.println();

		System.out.println("\nRound 1:");
		roundOne(teams, winners);

		System.out.println("\nRound 1 Winners:");
		System.out.println(winners);

		System.out.println("\nRound 2:");
		roundTwo(teams, winners);

		System.out.println("\nRound 2 Winners:");
		System.out.println(winners);

		midRound(teams, winners);

		System.out.println("\nSemifinals:");
		roundRegionSemi(teams, winners);

		System.out.println("\nRegional SemiFinal Winners:");
		System.out.println(winners);

		midRound(teams, winners);

		System.out.println("\nRegion Finals:");
		roundRegionFinal(teams, winners);

		System.out.println("\nRegion Final Winners:");
		System.out.println(winners);

		midRound(teams, winners);

		System.out.println("\nFinal Four:");
		roundFinalFour(teams, winners);

		System.out.println("\nThe Remaining Two:");
		System.out.println(winners);

		midRound(teams, winners);

		System.out.println("It's time for the championship");
		roundFinale(teams, winners);

		System.out.println("\nThe Champion Is: ");
		System.out.println(winners.get(0).getName() + "!");
		System.out.println("Congragulations!!!");


	}

	public static void midRound(ArrayList<Team> teams, ArrayList<Team> winners)
	{
		teams.clear();
		teams = winners;
		winners.clear();
	}

	public static void roundOne(ArrayList<Team> teams, ArrayList<Team> winnerPlace)
	{
		int teamsPerRegion = teams.size() / REGION_COUNT;

		Region currRegion = null;
		for (int r = 1; r < REGION_COUNT + 1; r++)
		{
			currRegion = Region.enumForValue(r);
			for (int i = 1; i < (teamsPerRegion / 2) + 1; i++)
			{
				Team destToWin = findTeam(teams, currRegion, i);
				Team destToLose = findTeam(teams, currRegion, teamsPerRegion + 1 - i);


				Team winner = randomWinner(destToWin, destToLose);

				System.out.println("\nNow for the " + destToWin.getSeed() + " seed and " + destToLose.getSeed() + " seed:");
				System.out.println("It's " + destToWin.getName() + " versus " + destToLose.getName() + " in the " + currRegion + " Region!");
				System.out.println("The winner is..." + winner.getName() + "!");

				winnerPlace.add(winner);
			}
		}
	}

	public static void roundTwo(ArrayList<Team> teams, ArrayList<Team> winnerPlace)
	{
		int teamsPerRegion = teams.size() / REGION_COUNT;

		Region currRegion = null;
		for (int r = 1; r < REGION_COUNT + 1; r++)
		{
			currRegion = Region.enumForValue(r);
			for (int i = 1; i < (teamsPerRegion / 2) + 1; i++)
			{
				Team destToWin = findTeam(teams, currRegion, i);
				Team destToLose = findTeam(teams, currRegion, teamsPerRegion + 1 - i);


				Team winner = randomWinner(destToWin, destToLose);

				System.out.println("\nNow for the " + destToWin.getSeed() + " seed and " + destToLose.getSeed() + " seed:");
				System.out.println("It's " + destToWin.getName() + " versus " + destToLose.getName() + " in the " + currRegion + " Region!");
				System.out.println("The winner is..." + winner.getName() + "!");

				winnerPlace.add(winner);
			}
		}
	}

	public static void roundRegionSemi(ArrayList<Team> teams, ArrayList<Team> winnerPlace)
	{

	}

	public static void roundFinalFour(ArrayList<Team> teams, ArrayList<Team> winnerPlace)
	{

	}

	public static void roundFinale(ArrayList<Team> teams, ArrayList<Team> winnerPlace)
	{

	}

	public static void roundRegionFinal(ArrayList<Team> teams, ArrayList<Team> winnerPlace)
	{

	}

	public static Team findTeam(ArrayList<Team> teams, Region theRegion, int seed)
	{
		for (int i = 0; i < teams.size(); i++)
		{
			Team currTeam = teams.get(i);

			if (currTeam.getRegion() == theRegion && currTeam.getSeed() == seed)
				return currTeam;
		}
		return null;
	}

	public static Team randomWinner(Team a, Team b)
	{
		// Give greater seed team a 15 : 5 chance of winning
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
