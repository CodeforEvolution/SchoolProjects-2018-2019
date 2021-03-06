package WorkbookProbs;

import java.awt.Color;
import java.util.Arrays;
import java.util.Random;

import javax.swing.JOptionPane;

public class TheMaze {
	public final static int WALL = 0;
	public final static int PATH = 1;
	public final static int DEADEND = 2;
	public final static int STEP = 3;
	public final static int STAND = 4;
	public static Random r = new Random();
	
	public static void main(String[] args)
	{	
		Canvas theMaze = new Canvas("THEMOUSE", 800, 800, Color.BLACK);
		theMaze.setVisible(true);

/*		int[][] theGrid = {	{1,1,1,0,1,1,0,0,0,1,1,1,1},
							{1,1,1,0,1,1,0,0,0,1,1,1,1},
							{1,1,1,1,1,1,0,0,0,1,1,1,1},
							{1,1,1,0,1,1,0,0,0,1,1,1,1},
							{1,1,1,0,1,1,1,1,1,1,1,1,1},
							{1,1,1,0,1,1,0,0,0,1,1,0,1},
							{1,0,1,0,1,1,0,0,0,1,0,1,1},
							{0,0,0,0,1,1,0,0,0,1,1,1,1}	}; */
		
		int[][] theGrid = randomGrid(250, 250);
		
		System.out.println("Before\n");
		printGrid(theGrid);
		drawGrid(theMaze, theGrid);
		
		traverse(theMaze, theGrid, 0, 0);
		
		System.out.println("\nAfter:\n");
		printGrid(theGrid);
		drawGrid(theMaze, theGrid);
	}
	
	private static int[][] randomGrid(int xSize, int ySize)
	{
		int[][] grid = new int[xSize][ySize];
		
		for (int x = 2; x < ySize; x += r.nextInt(4))
		{
			for (int i = 0; i < xSize; i++)
			{
				grid[i][x] = PATH;
			}
		}
		
		for (int y = 0; y < ySize; y += r.nextInt(4))
		{
			for (int i = 0; i < ySize; i++)
			{
				grid[y][i] = PATH;
			}
		}
		
		for (int i = 0; i < ySize; i++)
		{
			grid[xSize - 1][i] = PATH;
		}
		
		for (int i = 0; i < xSize; i++)
		{
			grid[r.nextInt(xSize - 4) + 4][r.nextInt(ySize - 2) + 2] = WALL;
		}
		
		// The start and end definitely can't be a wall...
		grid[0][0] = PATH;
		grid[xSize - 1][ySize - 1] = PATH;
		
		return grid;
	}

	private static boolean valid(int[][] grid, int row, int column)
	{
		boolean result = false;
		
		if (row >= 0 && row < grid.length &&
			column >= 0 && column < grid[row].length)
		{
			if (grid[row][column] == PATH)
				result = true;
		}

		return result;
	}
	
	private static boolean traverse(Canvas surface, int[][] grid, int row, int column)
	{
		surface.pause(150);
		drawGrid(surface, grid);
		
		boolean done = false;
		
		if (valid(grid, row, column))
		{
			grid[row][column] = STEP;
			
			if (row == grid.length - 1 && column == grid[0].length - 1)
			{
				done = true;
			}
			else
			{
				switch (r.nextInt(4))
				{
					case 0:
						done = traverse(surface, grid, row + 1, column); //down
						if (!done)
							done = traverse(surface, grid, row, column + 1); //right
						if (!done)
							done = traverse(surface, grid, row - 1, column); //up
						if (!done)
							done = traverse(surface, grid, row, column - 1); //left
						
						grid[row][column] = DEADEND;
						break;
					case 1:
						done = traverse(surface, grid, row, column - 1); //left
						if (!done)
							done = traverse(surface, grid, row + 1, column); //down
						if (!done)
							done = traverse(surface, grid, row, column + 1); //right
						if (!done)
							done = traverse(surface, grid, row - 1, column); //up
						grid[row][column] = DEADEND;
						break;
					case 2:
						done = traverse(surface, grid, row - 1, column); //up
						if (!done)
							done = traverse(surface, grid, row, column - 1); //left
						if (!done)
							done = traverse(surface, grid, row + 1, column); //down
						if (!done)
							done = traverse(surface, grid, row, column + 1); //right
						
						grid[row][column] = DEADEND;
						break;
					case 3:
						done = traverse(surface, grid, row, column + 1); //right
						if (!done)
							done = traverse(surface, grid, row - 1, column); //up
						if (!done)
							done = traverse(surface, grid, row, column - 1); //left
						if (!done)
							done = traverse(surface, grid, row + 1, column); //down
						
						grid[row][column] = DEADEND;
						break;
					default:
						break;
				}
			}
			
			if (done)
				grid[row][column] = STAND;
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
		
		//Wall
		surface.setInkColor(Color.BLUE);
		
		int height = surface.getHeight() / grid.length;
		int width = surface.getWidth() / grid[0].length;
		
		surface.drawFilledRectangle(width * theX, height * theY, width, height);
		
		//Stripes
		surface.setInkColor(Color.BLACK);
		surface.drawFilledRectangle(width * theX, (height * theY) + (height / 4), width, height / 6);
		surface.drawFilledRectangle(width * theX, (height * theY) + 2 * (height / 4), width, height / 6);
		
		surface.popState();
	}
	
	private static void drawPath(Canvas surface, int theX, int theY, int[][] grid)
	{
		surface.pushState();
		
		//Square
		surface.setInkColor(Color.ORANGE);
		
		int height = surface.getHeight() / grid.length;
		int width = surface.getWidth() / grid[0].length;
		
		surface.drawFilledRectangle(width * theX, height * theY, width, height);
		
		//Cool
		surface.setInkColor(Color.BLACK);
		surface.drawTriangle((width * theX) + (width / 2), (height * theY),
							(width * theX) + 5, (height * theY) + height,
							(width * theX) + width, (height * theY) + height);
		
		surface.popState();
	}
	
	private static void drawStep(Canvas surface, int theX, int theY, int[][] grid)
	{	
		surface.pushState();
		
		drawPath(surface, theX, theY, grid);
		
		surface.setInkColor(new Color(100, 100, 100));
		
		int height = surface.getHeight() / grid.length;
		int width = surface.getWidth() / grid[0].length;
		
		surface.drawFilledOval(width * theX, height * theY, width, height);
		
		surface.popState();
	}
	
	private static void drawStand(Canvas surface, int theX, int theY, int[][] grid)
	{
		surface.pushState();
		
		drawPath(surface, theX, theY, grid);
		
		surface.setInkColor(Color.GREEN);
		
		int height = surface.getHeight() / grid.length;
		int width = surface.getWidth() / grid[0].length;
		
		surface.drawFilledOval(width * theX, height * theY, width, height);
		
		surface.popState();
	}
	
	private static void drawDeadEnd(Canvas surface, int theX, int theY, int[][] grid)
	{
		surface.pushState();
		
		drawPath(surface, theX, theY, grid);
		
		surface.setInkColor(Color.RED);
		
		int height = surface.getHeight() / grid.length;
		int width = surface.getWidth() / grid[0].length;
		
		surface.drawFilledOval(width * theX, height * theY, width, height);
		
		surface.popState();
	}
	
	/* Jake's implementation (broken)
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
	
	private static boolean trapped(int[][] baseGrid, int row, int column)
	{
		if ((valid(baseGrid, row + 1, column) == false || baseGrid[row + 1][column] != PATH) &&
			(valid(baseGrid, row, column + 1) == false || baseGrid[row][column + 1] != PATH) &&
			(valid(baseGrid, row - 1, column) == false || baseGrid[row - 1][column] != PATH) &&
			(valid(baseGrid, row, column - 1) == false || baseGrid[row][column - 1] != PATH))		
		{
			return false;
		}
		return true;
	}
	
	private static boolean traverse(Canvas output, int[][] whatToTraverse, int row, int column)
	{
		System.out.println("\nSolving:\n");
		printGrid(whatToTraverse);
		output.pause(50);
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
						//Go Down
						done = traverse(output, whatToTraverse, row + 1, column);
						break;
					case 1:
						//Go Right
						done = traverse(output, whatToTraverse, row, column + 1);
						break;
					default:
						throw new Error("What?!?");
				}
				
				if (!done)
				{
					switch (r.nextInt(2))
					{
						case 0:
							//Go Up
							done = traverse(output, whatToTraverse, row - 1, column);
							if (valid(whatToTraverse, row, column) && trapped(whatToTraverse, row, column) == false)
							{
								whatToTraverse[row][column] = DEADEND;
							}
							break;
						case 1:
							//Go Left
							done = traverse(output, whatToTraverse, row, column - 1);
							if (valid(whatToTraverse, row, column) && trapped(whatToTraverse, row, column) == false)
									{
										whatToTraverse[row][column] = DEADEND;
									}
							break;
						default:
							throw new Error("What?!?");
					}
				}
				
				if (false)
				{
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
					}
				}
			}

			if (done)
			{
				whatToTraverse[row][column] = STAND;
			}
		}
		
		if (false)
		{	
			done = false;
			
			// Find our last step
			if (valid(whatToTraverse, row + 1, column) == true && whatToTraverse[row + 1][column] == STEP)
			{
				// We just stepped up
				if (valid(whatToTraverse, row, column) == false && trapped(whatToTraverse, row, column) == true)
				{
					whatToTraverse[row][column] = DEADEND;
				}
				traverse(output, whatToTraverse, row + 2, column);
			}
			else if (valid(whatToTraverse, row, column + 1) == true && whatToTraverse[row][column + 1] == STEP)
			{
				// We just stepped left
				if (valid(whatToTraverse, row, column) == false)
				{
					whatToTraverse[row][column] = DEADEND;
				}
				traverse(output, whatToTraverse, row, column - 2);

			}
			if (valid(whatToTraverse, row - 1, column) == true && whatToTraverse[row - 1][column] == STEP)
			{
				// We just stepped down
				if (valid(whatToTraverse, row, column) == false)
				{
					whatToTraverse[row][column] = DEADEND;
				}
				traverse(output, whatToTraverse, row + 2, column);
			}
			else if (valid(whatToTraverse, row, column - 1) == true  && whatToTraverse[row][column - 1] == STEP)
			{
				// Last step was left
				if (valid(whatToTraverse, row, column) == false)
				{
					whatToTraverse[row][column] = DEADEND;
				}
				traverse(output, whatToTraverse, row, column - 2);
			}
			//whatToTraverse[row][column] = PATH;
		}
		
		return done;
	}
*/
}
