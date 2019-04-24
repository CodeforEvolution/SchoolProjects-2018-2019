package Magpie;

import java.util.ArrayList;

public class User {
	private String firstName;
	private String lastName;
	private String gender;
	private int age;

	private ArrayList<String> previousResponses;
	private ArrayList<String> nickNames;

	private int repeats;

	public User(String name)
	{
		repeats = 0;

		gender = "???";
		age = -1;

		previousResponses = new ArrayList<String>();
		nickNames = new ArrayList<String>();

		int firstPos = name.indexOf(" ");

		if (firstPos < 0)
		{
			firstName = name;
			lastName = "???";

			return;
		}

		firstName = name.substring(0, firstPos);
		lastName = name.substring(firstPos);
	}

	public String getFirstName()
	{
		return firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public String getGender()
	{
		return gender;
	}

	public int getAge()
	{
		return age;
	}

	public void addNickName(String nickAtNight)
	{
		nickNames.add(nickAtNight);
	}

	public ArrayList<String> getNickNames()
	{
		return nickNames;
	}

	public void addPreviousResponse(String prevResponse)
	{
		previousResponses.add(prevResponse);
	}

	public ArrayList<String> getPreviousResponses()
	{
		return previousResponses;
	}
}
