import java.util.ArrayList;

public class MyTest {
	public static void main(String[] args)
	{
		ArrayList<Integer> test = new ArrayList<Integer>();

		test.add(1);
		test.add(2);
		test.add(3);

		for (int i = 0; i < test.size(); i++)
		{
			if (i == 0)
			{
				test.remove(2);
			}
			System.out.println(i);
		}
	}
}
