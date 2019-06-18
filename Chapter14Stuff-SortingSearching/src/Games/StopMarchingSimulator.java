package Games;

import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class StopMarchingSimulator {
    public static Random rEngine = new Random();
    public static int REGION_COUNT = Team.Region.values().length;

    public static void main(String[] args) throws Exception
    {
        ArrayList<Team> teams = new ArrayList<Team>();
        ArrayList<Team> winners = new ArrayList<Team>();
        ArrayList<String> teamNames = new ArrayList<String>();

        File input = new File(ClassLoader.getSystemClassLoader().getResource("Games/nba-teams.txt").toURI());
        Scanner inEngine = new Scanner(input);

        // We'll skip to the Regional Semi-Finals, only need 16 teams, 4 teams per region
        for (int count = 0; count < 16; count++) {
            teamNames.add(inEngine.nextLine());
        }
        inEngine.close();

        int teamsPerRegion = teamNames.size() / REGION_COUNT;

        // Fill team array with 4 teams for each of the 4 regions
        int loop = 0;
        for (Team.Region region : Team.Region.values())
        {
            System.out.println(region);
            for (int seed = 1; (seed - 1) < teamsPerRegion; seed++)
            {
                int nameIndex = (teamsPerRegion * loop) + seed - 1;
                teams.add(new Team(teamNames.get(nameIndex), region, seed));
            }
            loop++;
        }

        System.out.println("Here's our swell teams!");
        System.out.println(teams);

        // To the games!

        /////////////////////////////////////////////
        // Regional Semis - The "initial 16 teams" //
        /////////////////////////////////////////////
        System.out.println("\nIt's time for the Regional Semi-Finals! Somehow???");

        // Loop for each region
        Team.Region currRegion;
        for (int region = 1; region <= REGION_COUNT; region++)
        {
            // Loop for a match in each region
            currRegion = Team.Region.enumForValue(region);
            for (int match = 1; match <= teamsPerRegion / 2; match++)
            {
                Team destToWin = findTeam(teams, currRegion, match);
                Team destToLose = findTeam(teams, currRegion, teamsPerRegion - match + 1);

                Team winner = randomEarlyWinner(destToWin, destToLose);

                System.out.println("\nNow for the " + destToWin.getSeed() + " seed and " + destToLose.getSeed() + " seed:");
                System.out.println("It's " + destToWin.getName() + " versus " + destToLose.getName() + " in the " + currRegion + " Region!");
                System.out.println("The winner is..." + winner.getName() + "!");

                winners.add(winner);
            }
        }

        // Take winners and make them the remaining teams
        teams.clear();
        for (Team team : winners)
            teams.add(team);
        winners.clear();

        System.out.println("\nThat was the Region Semi-Finals! Let's see who remains!");
        System.out.println(teams);

        ///////////////////////////////
        // Regional Finals - 8 teams //
        ///////////////////////////////
        System.out.println("\nIt's time for the Regional Finals!");

        // Loop for each region
        for (int region = 1; region <= REGION_COUNT; region++)
        {
            currRegion = Team.Region.enumForValue(region);

            Team teamA = null;
            Team teamB = null;

            // Find teams of a region
            for (Team team : teams)
            {
                if (team.getRegion() == currRegion)
                {
                    if (teamA == null)
                        teamA = team;
                    else
                        teamB = team;
                }
            }

            Team destToWin = teamA.getSeed() > teamB.getSeed() ? teamA : teamB;
            Team destToLose = destToWin == teamA ? teamB : teamA;

            Team winner = randomEarlyWinner(destToWin, destToLose);

            System.out.println("THE WIN: " + winner);

            System.out.println("\nNow for the " + destToWin.getSeed() + " seed and " + destToLose.getSeed() + " seed:");
            System.out.println("It's " + destToWin.getName() + " versus " + destToLose.getName() + " in the " + currRegion + " Region!");
            System.out.println("The winner is..." + winner.getName() + "!");

            winners.add(winner);
        }

        // Take winners and make them the remaining teams
        teams.clear();
        for (Team team : winners)
            teams.add(team);
        winners.clear();

        System.out.println("\nThat was the Region Finals! Let's see who remains!");
        System.out.println(teams);

        //////////////////////////////
        // The Final Four - 4 teams //
        //////////////////////////////
        System.out.println("\nIt's time for the Final Four!");

        // Find each region, slow, but gets the job done
        Team south = null;
        Team east = null;
        Team midwest = null;
        Team west = null;
        for (int region = 1; region <= REGION_COUNT; region++) {
            // Find teams of a region
            for (Team team : teams)
            {
                if (team.getRegion() == Team.Region.SOUTH)
                    south = team;
                else if (team.getRegion() == Team.Region.EAST)
                    east = team;
                else if (team.getRegion() == Team.Region.MIDWEST)
                    midwest = team;
                else
                    west = team;
            }
        }

        Team winner;

        // South vs East, equal win chances
        winner = rEngine.nextInt(10) > 4 ? south : east;

        System.out.println("\nNow for the southern team and eastern team:");
        System.out.println("It's " + south.getName() + " versus " + east.getName() + "!");
        System.out.println("The winner is..." + winner.getName() + "!");

        winners.add(winner);

        // Midwest vs West, equal win chances
        winner = rEngine.nextInt(10) > 4 ? midwest : west;

        System.out.println("\nNow for the midwestern team and western team:");
        System.out.println("It's " + midwest.getName() + " versus " + west.getName() + "!");
        System.out.println("The winner is..." + winner.getName() + "!");

        winners.add(winner);

        // Take winners and make them the remaining teams
        teams.clear();
        for (Team team : winners)
            teams.add(team);
        winners.clear();

        System.out.println("\nThat was the Final Four! Here are the final two!!");
        System.out.println(teams);

        //////////////////////////
        // The Finale - 2 teams //
        //////////////////////////
        System.out.println("\nIt's time for the grand finale!!!");

        Team teamA = teams.get(0);
        Team teamB = teams.get(1);

        System.out.println("Will " + teamA.getName() + " win, or will " + teamB.getName() + " win?");

        Team grandWinner = rEngine.nextInt(10) > 4 ? teams.get(0) : teams.get(1);

        System.out.println("The grand winner is.......THE " + grandWinner.getName() + " of the " + grandWinner.getRegion() + " region!!!");
        System.out.println("\nWhat a great mad march!!!");
    }

    public static Team findTeam(ArrayList<Team> teams, Team.Region theRegion, int seed)
    {
        for (int i = 0; i < teams.size(); i++)
        {
            Team currTeam = teams.get(i);

            if (currTeam.getRegion() == theRegion && currTeam.getSeed() == seed)
                return currTeam;
        }
        return null;
    }

    private static Team randomEarlyWinner(Team a, Team b)
    {
        int aChance = a.compareTo(b);

        // Give greater seed team a 15 / 20 chance of winning
        if (aChance < 0)
        {
            if (rEngine.nextInt(20) > 5)
                return a;
            else
                return b;
        }
        else if (aChance > 0)
        {
            if (rEngine.nextInt(20) > 5)
                return b;
            else
                return a;
        }

        return null;
    }
}
