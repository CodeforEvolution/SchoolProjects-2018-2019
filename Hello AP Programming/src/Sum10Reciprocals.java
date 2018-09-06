
public class Sum10Reciprocals {

	public static void main(String[] args) {
		//non loops
		double sum = (1.0/1.0) + (1.0/2.0) + (1.0/3.0) + (1.0/4.0) + (1.0/5.0) + (1.0/6.0) + (1.0/7.0) + (1.0/8.0) + (1.0/9.0) + (1.0/10.0);
		System.out.println("Sum of reciprocals w/o loops: " + sum);
		//end non loops
		
		//loops
		sum = 0.0;
		for (int i = 1; i < 11; i++)
		{
			sum += (1.0 / i);
		}
		
		System.out.println("Sum of reciprocals w/ loops: " + sum);
		//end loops
	}

}
