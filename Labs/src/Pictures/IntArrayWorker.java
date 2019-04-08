package Pictures;

public class IntArrayWorker
{
  /** two dimensional matrix */
  private int[][] matrix = null;

  /** set the matrix to the passed one
    * @param theMatrix the one to use
    */
  public void setMatrix(int[][] theMatrix)
  {
    matrix = theMatrix;
  }

  /**
   * Method to find occurrences of passed in integer in array
   */


  /**
   * Method to return the total
   * @return the total of the values in the array
   */
  public int getTotal()
  {
    int total = 0;
    for (int row = 0; row < matrix.length; row++)
    {
      for (int col = 0; col < matrix[0].length; col++)
      {
        total = total + matrix[row][col];
      }
    }
    return total;
  }

  /**
   * Method to return the total using a nested for-each loop
   * @return the total of the values in the array
   */
  public int getTotalNested()
  {
    int total = 0;
    for (int[] rowArray : matrix)
    {
      for (int item : rowArray)
      {
        total = total + item;
      }
    }
    return total;
  }

  /**
   * Method to return the occurrences of a value in the array
   * @param toSearch the value to search for
   * @return the number if occurrences of {@code toSearch}
   */
  public int getCount(int toSearch)
  {
	  int count = 0;

	  for (int[] rowArray : matrix)
	  {
		  for (int box : rowArray)
		  {
			  if (box == toSearch)
				  count++;
		  }
	  }

	  return count;
  }

  /**
   * Method to get the largest value in the array
   * @return the largest value in the array
   */
  public int getLargest()
  {
	  int largest = 0;

	  for (int[] rowArray : matrix)
	  {
		  for (int box : rowArray)
		  {
			  if (box > largest)
				  largest = box;
		  }
	  }

	  return largest;
  }

  /**
   * Method to get the total of the values within a column
   * @param column the column to get the total of its values
   * @return the total of the values in the column
   */
  public int getColTotal(int column)
  {
	  int total = 0;

	  if (column >= matrix[0].length || column < 0)
		  throw new ArrayIndexOutOfBoundsException("Column doesn't exist.");

	  for (int count = 0; count < matrix.length; count++)
	  {
		  total += matrix[count][column];
	  }

	  return total;
  }

  /**
   * Method to fill with an increasing count
   */
  public void fillCount()
  {
    int numCols = matrix[0].length;
    int count = 1;
    for (int row = 0; row < matrix.length; row++)
    {
      for (int col = 0; col < numCols; col++)
      {
        matrix[row][col] = count;
        count++;
      }
    }
  }

  /**
   * print the values in the array in rows and columns
   */
  public void print()
  {
    for (int row = 0; row < matrix.length; row++)
    {
      for (int col = 0; col < matrix[0].length; col++)
      {
        System.out.print( matrix[row][col] + " " );
      }
      System.out.println();
    }
    System.out.println();
  }


  /**
   * fill the array with a pattern
   */
  public void fillPattern1()
  {
    for (int row = 0; row < matrix.length; row++)
    {
      for (int col = 0; col < matrix[0].length;
           col++)
      {
        if (row < col)
          matrix[row][col] = 1;
        else if (row == col)
          matrix[row][col] = 2;
        else
          matrix[row][col] = 3;
      }
    }
  }

}