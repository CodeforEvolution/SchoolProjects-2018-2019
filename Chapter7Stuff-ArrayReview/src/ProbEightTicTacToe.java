import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.font.FontRenderContext;
import java.util.Random;


public class ProbEightTicTacToe {
	enum grid_value {X, O, NONE};
	
	final static int GRID_LINE_THICKNESS = 10;
	final static int O_SIZE = 100;
	
	public static void main(String[] args)
	{
		/* Drawing test code
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
		*/
		
		grid_value[][] grid = new grid_value[3][3];
		resetBoard(grid);
		
		Canvas theBoard = new Canvas("The TTT", 500, 500, Color.BLACK);
		theBoard.setVisible(true);
		
		System.out.println("Tic tac toe start!");
		doIntro(theBoard);
		
		boolean again = false;
		do
		{
			//playGame();
			
			drawCenterText(theBoard, "Would you like to play again? (Answer y or n in terminal)");
		} while (again == true);
		
		System.out.println(gridToString(grid));
	}
	
	public static void doIntro(Canvas theSurface)
	{
		Color old = theSurface.getInkColor();
		
		theSurface.setInkColor(Color.ORANGE);
		theSurface.setFontSize(18);
		
		drawCenterText(theSurface, "Hello");
		theSurface.pause(3000);
		theSurface.erase();
		drawCenterText(theSurface, "Welcome to Tic Tac Toe!");
		theSurface.pause(3000);
		theSurface.erase();
		drawCenterText(theSurface, "Get ready to play!");
		theSurface.pause(3000);
		theSurface.erase();
		drawCenterText(theSurface, "You're X, go you!");
		theSurface.pause(3000);
		theSurface.erase();
		
		theSurface.setInkColor(old);
	}
	
	public static void drawCenterText(Canvas easel, String theText)
	{
		easel.drawString(theText, (easel.getWidth() / 2) - ((int)easel.getFont().getStringBounds(theText, easel.getFontContext()).getCenterX()), (easel.getHeight() / 2));
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
					case O:
						drawO(theBoard, x, y);
						break;
					case X:
						drawX(theBoard, x, y);
						break;
					case NONE:
//						drawNone(theBoard, x, y);
//						break;
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
		
		int[] xXs = new int[2];
		int[] xYs = new int[2];
		
		xXs[0] = xStart + (easel.getWidth() / 6);
		xYs[0] = yStart + (easel.getHeight() / 6);
		xXs[1] = xStart - (easel.getWidth() / 6) + GRID_LINE_THICKNESS;
		xYs[1] = yStart - (easel.getHeight() / 6) + GRID_LINE_THICKNESS;
		
		easel.drawPolygon(xXs, xYs, xXs.length);
		
		xXs[0] = xStart + (easel.getWidth() / 6);
		xYs[0] = yStart - (easel.getHeight() / 6) + GRID_LINE_THICKNESS;
		xXs[1] = xStart - (easel.getWidth() / 6) + GRID_LINE_THICKNESS;
		xYs[1] = yStart + (easel.getHeight() / 6);
		
		easel.drawPolygon(xXs, xYs, xXs.length);
		
		easel.setInkColor(old);
	}
	
	public static void drawO(Canvas easel, int xPos, int yPos)
	{
		Color old = easel.getInkColor();
		
		easel.setInkColor(Color.BLUE);
		int xWhere = ((xPos * (easel.getWidth() / 3)) + easel.getWidth() / 6) - (O_SIZE / 2);
		int yWhere = ((yPos * (easel.getHeight() / 3)) + easel.getHeight() / 6) - (O_SIZE /2);
		
		easel.drawOval(xWhere, yWhere, O_SIZE, O_SIZE);
		
		easel.setInkColor(old);
	}
	
	public static void drawNone(Canvas easel, int xPos, int yPos)
	{
		Color old = easel.getInkColor();
		
		easel.setInkColor(Color.WHITE);
		int xWhere = (xPos * (easel.getWidth() / 3)) + easel.getWidth() / 6;
		int yWhere = (yPos * (easel.getHeight() / 3)) + easel.getHeight() / 6;
		easel.drawFilledRectangle(xWhere, yWhere, 10, 10);
		
		easel.setInkColor(old);
	}
}
