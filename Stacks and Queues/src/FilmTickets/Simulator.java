package FilmTickets;

public class Simulator {
	public static void main(String[] args)
	{
		final int TOTAL_BEATS = 30;
		final int MAX_LINE = 10;

		TheaterLine theLine = new TheaterLine(MAX_LINE);

		System.out.println("Welcome to the Film and Films Filmter");
		System.out.println("Let's go!");

		int beat = 0;
		// Also for while loop: beat <= TOTAL_BEATS
		while (true)
		{
			theLine.heartbeat();

			System.out.println("\nBeats: " + beat);
			System.out.println(theLine);
			System.out.println("-------------------------\n");

			beat++;

			try {
				Thread.sleep(750);
			} catch (InterruptedException e) {
				System.out.println("Sleep darn it!");
				e.printStackTrace();
			}
		}

		// System.out.println("\nThank you for visiting!");
	}
}
