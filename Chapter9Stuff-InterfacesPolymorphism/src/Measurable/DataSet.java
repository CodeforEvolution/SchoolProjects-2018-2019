package Measurable;

/**
   Computes the average of a set of data values.
*/
public class DataSet
{
   /**
      Constructs an empty data set.
   */
   public DataSet()
   {
      sum = 0;
      count = 0;
      maximum = null;
      minimum = null;
   }

   /**
      Adds a data value to the data set.
      @param x a data value
   */
   public void add(Measurable x)
   {
      sum += x.getMeasure();

      if (count == 0)
      {
         maximum = x;
         minimum = x;
      }
      else if (maximum.getMeasure() < x.getMeasure())
      {
    	  maximum = x;
      }
      else if (minimum.getMeasure() > x.getMeasure())
      {
    	  minimum = x;
      }

      count++;
   }

   /**
      Gets the average of the added data.
      @return the average or 0 if no data has been added
   */
   public double getAverage()
   {
      if (count == 0) return 0;
      else return sum / count;
   }

   /**
      Gets the largest of the added data.
      @return the maximum or 0 if no data has been added
   */
   public Measurable getMaximum()
   {
      return maximum;
   }
   
   public Measurable getMinimum()
   {
	   return minimum;
   }

   private double sum;
   private Measurable maximum;
   private Measurable minimum;
   private int count;
}
