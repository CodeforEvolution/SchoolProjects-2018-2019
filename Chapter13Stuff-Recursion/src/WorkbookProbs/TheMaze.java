package WorkbookProbs;

import java.awt.Color;

public class TheMaze {
	public final static int WALL = 0;
	public final static int PATH = 1;
	public final static int DEADEND = 3;
	public final static int STEP = 4;
	public final static int STAND = 5;
	
	public static void main(String[] args)
	{	
		Canvas theMaze = new Canvas("THEMOUSE", 500, 500, Color.BLACK);
		theMaze.setVisible(true);

		int[][] theGrid = {	{1,1,1,0,1,1,0,0,0,1,1,1,1},
							{1,1,1,0,1,1,0,0,0,1,1,1,1},
							{1,1,1,1,1,1,0,0,0,1,1,1,1},
							{1,1,1,0,1,1,0,0,0,1,1,1,1},
							{1,1,1,0,1,1,1,1,1,1,1,1,1},
							{1,1,1,0,1,1,0,0,0,1,1,0,1},
							{1,0,1,0,1,1,0,0,0,1,0,1,1},
							{0,0,0,0,1,1,0,0,0,1,1,1,1}	};
		printGrid(theGrid);
		drawGrid(theMaze, theGrid);
	}
	
	private static boolean valid(int[][] baseGrid, int row, int column)
	{
		if (row >= baseGrid.length || row < 0)
		{
			return false;
		}
		else if (column >= baseGrid[0].length || column < 0)
		{
			return false;
		}
		
		if (baseGrid[row][column] == STEP)
		{
			return false;
		}
		
		return true;
	}
	
	private static boolean traverse(int[][] whatToTraverse, int row, int column)
	{
		boolean done = false;
		printGrid(whatToTraverse);
		
		if (valid(whatToTraverse, row, column))
		{
			whatToTraverse[row][column] = STEP;
			
			if (row == whatToTraverse.length - 1 && column == whatToTraverse[0].length - 1)
			{
				done = true;
			}
			else
			{
				done = traverse(whatToTraverse, row + 1, column);
				if (!done)
				{
					done = traverse(whatToTraverse, row, column + 1);
				}
				if (!done)
				{
					done = traverse(whatToTraverse, row - 1, column);
				}
				if (!done)
				{
					done = traverse(whatToTraverse, row, column - 1);
				}
			}
			
			if (done)
			{
				whatToTraverse[row][column] = STAND;
			}
		}
		
		return done;
	}
	
	private static void printGrid(int[][] toGrid)
	{
		for (int y = 0; y < toGrid.length; y++)
		{
			for (int x = 0; x < toGrid[y].length; x++)
			{
				System.out.print(toGrid[y][x] + " ");
			}
			System.out.println();
		}
	}
	
	private static void drawGrid(Canvas surface, int[][] toGrid)
	{
		for (int y = 0; y < toGrid.length; y++)
		{
			for (int x = 0; x < toGrid[y].length; x++)
			{
				switch(toGrid[y][x])
				{
					case WALL:
						drawWall(surface, x, y, toGrid);
						break;
					case PATH:
						drawPath(surface, x, y);
					default:
						break;
				}
			}
		}
	}
	
	private static void drawWall(Canvas surface, int theX, int theY, int[][] grid)
	{
		surface.pushState();
		
		surface.setInkColor(Color.BLUE);
		surface.drawFilledRectangle((surface.getWidth() / grid.length) * theX, (surface.getHeight() / grid[0].length) * theY, surface.getWidth() / grid.length, surface.getHeight() / grid[0].length);
		
		surface.pushState();
	}
	
	private static void drawPath(Canvas surface, int theX, int theY)
	{
		
	}
}
