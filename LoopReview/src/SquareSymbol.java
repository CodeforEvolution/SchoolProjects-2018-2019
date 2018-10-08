
public class SquareSymbol {
	public SquareSymbol()
	{}
	
	public static void PrintSquare(int len, char symb)
	{
		PrintSquare(len, symb, true);
	}
	
	public static void PrintSquare(int len, char symb, boolean fill)
	{
		if (fill == true)
		{
			for (int y = 0; y < len; y++)
			{
				for (int x = 0; x < len; x++)
				{
					System.out.print(symb);
				}
				System.out.println();
			}
		}
		else
		{
			for (int t = 0; t < len; t++)
			{
				System.out.print(symb);
			}
			System.out.println();
			
			for (int y = 0; y < len - 2; y++)
			{
				System.out.print(symb);
				for (int x = 0; x < len - 2; x++)
				{
					System.out.print(' ');
				}
				System.out.print(symb);
				System.out.println();
			}
			
			for (int b = 0; b < len; b++)
			{
				System.out.print(symb);
			}
		}
	}
}
