import java.awt.Color;
import java.util.Random;


public class ProbEightTicTacToe {
	enum grid_value {X, O, NONE};
	
	final static int GRID_LINE_THICKNESS = 10;
	final static int O_SIZE = 50;
	
	public static void main(String[] args)
	{
		grid_value[][] grid = new grid_value[3][3];
		resetBoard(grid);
		
		Canvas theBoard = new Canvas("The TTT", 500, 500, Color.BLACK);
		theBoard.setVisible(true);
		
		Random r = new Random();
		
		for (int i = 0; i < 2; i++)
		{
			int x = 0;
			int y = 0;
			do
			{
				x = r.nextInt(3);
				y = r.nextInt(3);
				
			} while (locationTaken(grid, x, y) == true);
			grid[x][y] = grid_value.X;
		}
		
		for (int i = 0; i < 2; i++)
		{
			int x = 0;
			int y = 0;
			do
			{
				x = r.nextInt(3);
				y = r.nextInt(3);
				
			} while (locationTaken(grid, x, y) == true);
			grid[x][y] = grid_value.O;
		}
		
		System.out.println(gridToString(grid));
		drawBoard(theBoard, grid);
	}
	
	public static boolean locationTaken(grid_value[][] theGrid, int col, int row)
	{
		if (theGrid[col][row] != grid_value.NONE)
		{
			return true;
		}
		return false;
	}
	
	public static String gridToString(grid_value[][] theGrid)
	{
		String out = "";
		
		for (int x = 0; x < theGrid.length; x++)
		{
			for (int y = 0; y < theGrid.length; y++)
			{
				switch (theGrid[x][y])
				{
					case X:
						out += "X";
						break;
					case O:
						out += "O";
						break;
					case NONE:
						out += "_";
						break;
					default:
						out += "*";
						break;
				}
				out += " ";
			}
			out += "\n";
		}
		
		return out;
	}
	
	public static void resetBoard(grid_value[][] theGrid)
	{
		for (int x = 0; x < theGrid.length; x++)
		{
			for (int y = 0; y < theGrid.length; y++)
			{
				theGrid[x][y] = grid_value.NONE;
			}
		}
	}
	
	public static void drawBoard(Canvas theBoard, grid_value[][] theGrid)
	{
		theBoard.erase();
		
		//Draw Grid
		theBoard.setInkColor(Color.ORANGE);
		theBoard.drawRectangle(0, theBoard.getHeight() / 3, theBoard.getWidth() - 1, GRID_LINE_THICKNESS);
		theBoard.drawRectangle(0, 2 * (theBoard.getHeight() / 3), theBoard.getWidth() - 1, GRID_LINE_THICKNESS);
		theBoard.drawRectangle(theBoard.getWidth() / 3, 0, GRID_LINE_THICKNESS, theBoard.getHeight() - 1);
		theBoard.drawRectangle(2 * (theBoard.getWidth() / 3), 0, GRID_LINE_THICKNESS, theBoard.getHeight() - 1);
		
		//Draw Symbols
		for (int x = 0; x < theGrid.length; x++)
		{
			for (int y = 0; y < theGrid.length; y++)
			{
				switch (theGrid[y][x])
				{
					case NONE:
						drawNone(theBoard, x, y);
						break;
					case O:
						drawO(theBoard, x, y);
						break;
					case X:
						drawX(theBoard, x, y);
						break;
					default:
						break;
				}
			}
		}
	}
	
	public static void drawX(Canvas easel, int xPos, int yPos)
	{
		Color old = easel.getInkColor();
		
		easel.setInkColor(Color.RED);
		int xStart = (xPos * (easel.getWidth() / 3)) + easel.getWidth() / 6;
		int yStart = (yPos * (easel.getHeight() / 3)) + easel.getHeight() / 6;
		
		
		//easel.drawPolygon(xs, ys, size);
		
		easel.setInkColor(old);
	}
	
	public static void drawO(Canvas easel, int xPos, int yPos)
	{
		Color old = easel.getInkColor();
		
		easel.setInkColor(Color.BLUE);
		int xWhere = (xPos * (easel.getWidth() / 3)) + easel.getWidth() / 6;
		int yWhere = (yPos * (easel.getHeight() / 3)) + easel.getHeight() / 6;
		
		easel.drawOval(xWhere, yWhere, O_SIZE, O_SIZE);
		
		easel.setInkColor(old);
	}
	
	public static void drawNone(Canvas easel, int xPos, int yPos)
	{
		Color old = easel.getInkColor();
		
		easel.setInkColor(Color.WHITE);
		int xWhere = (xPos * (easel.getWidth() / 3)) + easel.getWidth() / 6;
		int yWhere = (yPos * (easel.getHeight() / 3)) + easel.getHeight() / 6;
		
		easel.setInkColor(old);
	}
}
