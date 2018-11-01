import java.util.ArrayList;


public class ArrayOStrings {
	public static void main(String[] args)
	{
		ArrayList<String> nameParts = new ArrayList<String>();
		
		//Step 1
		nameParts.add("Jake");
		nameParts.add("BobRoss");
		nameParts.add("YEET");
		nameParts.add("oof");
		System.out.println("The original array: \n" + nameParts);
		System.out.println();
		
		//Step 2
		System.out.println("Some strings shorter than 4 characters: ");
		for (int i = 0; i < nameParts.size(); i++)
		{
			String temp = nameParts.get(i);
			if (temp.length() < 4)
			{
				System.out.println(temp);
			}
		}
		System.out.println();
		
		//Step 3
		nameParts.set(nameParts.indexOf("Jake"), "secunDA");
		
		//Step 4
		for (int i = 0; i < nameParts.size(); i++)
		{
			char[] temp = nameParts.get(i).toCharArray();
			temp[0] = Character.toUpperCase(temp[0]);
			nameParts.set(i, new String(temp));
		}
		
		//Step 5
		int shortI = 0;
		
		for (int i = 0; i < nameParts.size(); i++)
		{
			if (nameParts.get(shortI).length() > nameParts.get(i).length())
			{
				shortI = i;
			}
		}
		nameParts.remove(shortI);
		
		int longI = 0;
		for (int i = 0; i < nameParts.size(); i++)
		{
			if (nameParts.get(longI).length() < nameParts.get(i).length())
			{
				longI = i;
			}
		}
		nameParts.remove(longI);
		
		System.out.println("After doing some crazy stuff to your array: ");
		System.out.println(nameParts);
	}
}
