import java.util.Scanner;


public class FacePainter {
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		System.out.println("Just a face: \n");
		
		drawFace();
		
		System.out.println("\nNow, give this man a mouth!: ");
		String face = in.next();
		in.close();
		
		System.out.println("\n\n\n");
		
		drawFace();
		System.out.println("|     " + face + "    |");
		
		drawChin();
	}
	
	private static void drawFace()
	{
		for (int x = 0; x < 3; x++)
		{
			for (int i = 0; i < 15; i++)
			{
				System.out.print("/W/");
			}
			System.out.println();
		}

		System.out.println("|      ---           ---       |");
		
		for (int i = 0; i < 3; i++)
			System.out.println("|     | [  |       |  ] |      |");
		
		for (int i = 0; i < 5; i++)
			System.out.println("|              l|              |");
		
		for (int i = 0; i < 2; i++)
			System.out.println("|          {~~~~~~~~}          |");
		
		System.out.println("|           o<____>o           |");
		
		for (int i = 0; i < 2; i++)
			System.out.println("|                              |");
	}
	
	private static void drawChin()
	{
		System.out.println("|                              |");
		System.out.println(" ______________________________");
	}

}
