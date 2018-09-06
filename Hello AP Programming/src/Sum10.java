
public class Sum10 {

	public static void main(String[] args) {
		// no loops
		int sum = 1+2+3+4+5+6+7+8+9+10;
		
		System.out.println("Sum of 10 pos ints w/o loops: " + sum);
		// End no loops
		
		System.out.println();
		
		//loops
		sum = 0;
		for (int i = 0; i < 11; i++)
			sum += i;
		
		System.out.println("Sum of 10 pos ints w/ loops: " + sum);
		// End loops
	}

}
