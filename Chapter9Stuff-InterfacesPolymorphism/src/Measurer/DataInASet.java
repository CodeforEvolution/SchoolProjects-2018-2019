package Measurer;

/**
   Computes the average of a set of data values.
*/
public class DataInASet
{
   /**
      Constructs an empty data set.
   */
   public DataInASet(Measurer myMeasurer)
   {
      sum = 0;
      count = 0;
      maximum = null;
      theMagicRuler = myMeasurer;
   }

   /**
      Adds a data value to the data set.
      @param x a data value
   */
   public void add(Object x)
   {
      sum += theMagicRuler.measure(x);

      if (count == 0)
      {
         maximum = x;
         minimum = x;
      }
      else if (theMagicRuler.measure(maximum) < theMagicRuler.measure(x))
      {
    	  maximum = x;
      }
      else if (theMagicRuler.measure(minimum) > theMagicRuler.measure(x))
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
   public Object getMaximum()
   {
      return maximum;
   }
   
   public Object getMinimum()
   {
	   return minimum;
   }

   private double sum;
   private Object maximum;
   private Object minimum;
   private Measurer theMagicRuler;
   private int count;
}
