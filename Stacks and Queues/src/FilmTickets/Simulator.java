package FilmTickets;

public class Simulator {
	public static void main(String[] args)
	{
		final int TOTAL_BEATS = 30;
		final int MAX_LINE = 10;

		TheaterLine theLine = new TheaterLine(MAX_LINE);

		System.out.println("Welcome to the Film and Films Filmter");
		System.out.println("Let's go!");

		int beat = 1;
		while (beat <= TOTAL_BEATS)
		{
			theLine.heartbeat();

			System.out.println("\nBeats: " + beat);
			System.out.println(theLine);
			System.out.println("-------------------------\n");

			beat++;
		}

		System.out.println("\nThank you for visiting!");
	}
}
