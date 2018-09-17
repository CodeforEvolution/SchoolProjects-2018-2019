
public class RoachPopulation {
	private int roachPop; 
	
	public RoachPopulation(int initialSize)
	{
		 roachPop = initialSize;
	}
	
	public void breed()
	{
		roachPop *= 2;
	}
	
	public void spray()
	{
		roachPop *= 0.9;
	}
	
	public int getRoaches()
	{
		return roachPop;
	}
}
