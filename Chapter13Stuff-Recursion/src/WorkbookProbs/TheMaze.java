package WorkbookProbs;

import java.awt.Color;
import java.util.Random;

import javax.swing.JOptionPane;

public class TheMaze {
	public final static int WALL = 0;
	public final static int PATH = 1;
	public final static int DEADEND = 3;
	public final static int STEP = 4;
	public final static int STAND = 5;
	public static Random r = new Random();
	
	public static void main(String[] args)
	{	
		Canvas theMaze = new Canvas("THEMOUSE", 700, 700, Color.BLACK);
		theMaze.setVisible(true);

		int[][] theGrid = {	{1,1,1,0,1,1,0,0,0,1,1,1,1},
							{1,1,1,0,1,1,0,0,0,1,1,1,1},
							{1,1,1,1,1,1,0,0,0,1,1,1,1},
							{1,1,1,0,1,1,0,0,0,1,1,1,1},
							{1,1,1,0,1,1,1,1,1,1,1,1,1},
							{1,1,1,0,1,1,0,0,0,1,1,0,1},
							{1,0,1,0,1,1,0,0,0,1,0,1,1},
							{0,0,0,0,1,1,0,0,0,1,1,1,1}	};

		System.out.println("Before\n");
		printGrid(theGrid);
		drawGrid(theMaze, theGrid);
		
		traverse(theMaze, theGrid, 0, 0);
		
		System.out.println("\nAfter:\n");
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
		
		if (baseGrid[row][column] == WALL || baseGrid[row][column] == DEADEND)
		{
			return false;
		}
		
		return true;
	}
	
	private static boolean traverse(Canvas output, int[][] whatToTraverse, int row, int column)
	{
		System.out.println("\nSolving:\n");
		printGrid(whatToTraverse);
		output.pause(300);
		drawGrid(output, whatToTraverse);
		
		boolean done = false;
		
		if (valid(whatToTraverse, row, column))
		{
			whatToTraverse[row][column] = STEP;
			
			if (row == whatToTraverse.length - 1 && column == whatToTraverse[0].length - 1)
			{
				done = true;
			}
			else
			{	
				switch (r.nextInt(2))
				{
					case 0:
						done = traverse(output, whatToTraverse, row + 1, column);
						break;
					case 1:
						done = traverse(output, whatToTraverse, row, column + 1);
						break;
					default:
						throw new Error("What?!?");
				}
				
				/*
				done = traverse(output, whatToTraverse, row + 1, column);
				if (!done)
				{
					done = traverse(output, whatToTraverse, row, column + 1);
				}
				if (!done)
				{
					done = traverse(output, whatToTraverse, row - 1, column);
				}
				if (!done)
				{
					done = traverse(output, whatToTraverse, row, column - 1);
				}*/
			}

			if (done)
			{
				whatToTraverse[row][column] = STAND;
			}
		}
		else
		{	
			done = false;
			
			// Find our last step
			if (valid(whatToTraverse, row + 1, column) == true && whatToTraverse[row + 1][column] == STEP)
			{
				// Last step was down
				if (anyWhereElse(whatToTraverse, row, column) == false)
				{
					whatToTraverse[row][column] = DEADEND;
				}
				traverse(output, whatToTraverse, row - 2, column);
			}
			else if (valid(whatToTraverse, row, column + 1) == true && whatToTraverse[row][column + 1] == STEP)
			{
				// Last step was right
				if (anyWhereElse(whatToTraverse, row, column) == false)
				{
					whatToTraverse[row][column] = DEADEND;
				}
				traverse(output, whatToTraverse, row, column - 2);

			}
			if (valid(whatToTraverse, row - 1, column) == true && whatToTraverse[row - 1][column] == STEP)
			{
				// Last step was up
				if (anyWhereElse(whatToTraverse, row, column) == false)
				{
					whatToTraverse[row][column] = DEADEND;
				}
				traverse(output, whatToTraverse, row + 2, column);
			}
			else if (valid(whatToTraverse, row, column - 1) == true  && whatToTraverse[row][column - 1] == STEP)
			{
				// Last step was left
				if (anyWhereElse(whatToTraverse, row, column) == false)
				{
					whatToTraverse[row][column] = DEADEND;
				}
				traverse(output, whatToTraverse, row, column - 2);
			}
			//whatToTraverse[row][column] = PATH;
			
		}
		
		return done;
	}
	
	private static boolean anyWhereElse(int[][] theGrid, int row, int column)
	{
		if (valid(theGrid, row, column) == false)
			return false;

		if (theGrid[row + 1][column] != WALL && theGrid[row + 1][column] == PATH ||
			theGrid[row - 1][column] != WALL && theGrid[row - 1][column] == PATH ||
			theGrid[row][column + 1] != WALL && theGrid[row][column + 1] == PATH ||
			theGrid[row][column - 1] != WALL && theGrid[row][column - 1] == PATH)
		{
			return true;
		}
		return false;
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
		surface.erase();
		
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
						drawPath(surface, x, y, toGrid);
						break;
					case STEP:
						drawStep(surface, x, y, toGrid);
						break;
					case STAND:
						drawStand(surface, x, y, toGrid);
						break;
					case DEADEND:
						drawDeadEnd(surface, x, y, toGrid);
						break;
					default:
						JOptionPane.showMessageDialog(null, "Unknown value in grid!", "Error", JOptionPane.ERROR_MESSAGE);
						break;
				}
			}
		}
	}
	
	private static void drawWall(Canvas surface, int theX, int theY, int[][] grid)
	{
		surface.pushState();
		
		surface.setInkColor(Color.BLUE);
		
		int height = surface.getHeight() / grid.length;
		int width = surface.getWidth() / grid[0].length;
		
		surface.drawFilledRectangle(width * theX, height * theY, width, height);
		
		surface.popState();
	}
	
	private static void drawPath(Canvas surface, int theX, int theY, int[][] grid)
	{
		surface.pushState();
		
		surface.setInkColor(Color.ORANGE);
		
		int height = surface.getHeight() / grid.length;
		int width = surface.getWidth() / grid[0].length;
		
		surface.drawFilledRectangle(width * theX, height * theY, width, height);
		
		surface.popState();
	}
	
	private static void drawStep(Canvas surface, int theX, int theY, int[][] grid)
	{
		surface.pushState();
		
		surface.setInkColor(Color.YELLOW);
		
		int height = surface.getHeight() / grid.length;
		int width = surface.getWidth() / grid[0].length;
		
		surface.drawOval(width * theX, height * theY, width, height);
		
		surface.popState();
	}
	
	private static void drawStand(Canvas surface, int theX, int theY, int[][] grid)
	{
		surface.pushState();
		
		surface.setInkColor(Color.GREEN);
		
		int height = surface.getHeight() / grid.length;
		int width = surface.getWidth() / grid[0].length;
		
		surface.drawFilledOval(width * theX, height * theY, width, height);
		
		surface.popState();
	}
	
	private static void drawDeadEnd(Canvas surface, int theX, int theY, int[][] grid)
	{
		surface.pushState();
		
		surface.setInkColor(Color.RED);
		
		int height = surface.getHeight() / grid.length;
		int width = surface.getWidth() / grid[0].length;
		
		surface.drawFilledOval(width * theX, height * theY, width, height);
		
		surface.popState();
	}
}
