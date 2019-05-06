package MoreLinkedList2;

public class Contacts {
	private String name;
	private String pNumber;
	private int age;

	public Contacts(String n, String numb, int yearsOld)
	{
		name = n;
		pNumber = numb;
		age = yearsOld;
	}

	public String getName()
	{
		return name;
	}

	public String getPhoneNumber()
	{
		return pNumber;
	}

	public int getAge()
	{
		return age;
	}

	public String toString()
	{
		String out = "";

		out += name + " ";

		String hyphenated = pNumber;

		if (hyphenated.length() == 10)
		{
			hyphenated = hyphenated.substring(0, 3) + "-" +
						 hyphenated.substring(3, 6) + "-" +
						 hyphenated.substring(6, 10);
		}

		out += hyphenated + " ";
		out += "age: " + age;

		return out;
	}

	public static void main (String[] args)
	{
		Contacts me = new Contacts("Jake", "4148282333", 17);

		System.out.println(me);
	}
}
