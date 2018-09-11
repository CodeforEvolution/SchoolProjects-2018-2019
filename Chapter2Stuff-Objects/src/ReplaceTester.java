
public class ReplaceTester {
	public static void main(String[] args)
	{
		String test = "Mississippi".replace('i', '!').replace('s', '$');
		
		System.out.println("Expected: " + test);
		System.out.println("Actual: M!$$!$$!pp!");
	}
}
