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

        // We'll skip Round 1, only need 16 teams, 4 teams per region
        for (int count = 0; count < 16; count++) {
            teamNames.add(inEngine.nextLine());
        }
        inEngine.close();

        int teamsPerRegion = teamNames.size() / REGION_COUNT;

        // Fill team array with 4 teams for each of the 4 regions
        int loop = 0;
        for (Team.Region region : Team.Region.values())
        {
            for (int seed = 1; (seed - 1) < teamsPerRegion; seed++)
            {
                int nameIndex = (teamsPerRegion * loop) + seed - 1;
                teams.add(new Team(teamNames.get(nameIndex), region, seed));
            }
            loop++;
        }

        System.out.println("Here's our swell teams!");
        System.out.println(teams);

        // 1st Round - We skip, where do these non-nba teams come from?
        System.out.println("Round 1: Uh, something happened?\n");

        // 2nd Round - The "initial 16 teams"
        System.out.println("It's time for round 2!");

        //for (int count = 0; count < teams.size() / 2)
    }
}
