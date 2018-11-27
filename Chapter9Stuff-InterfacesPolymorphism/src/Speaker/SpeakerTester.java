package Speaker;

public class SpeakerTester {
	public static void main(String[] args)
	{
		byte hey = 9;
		Speaker ah = new TheScream("Scream", hey);
		ah.speak();

		Speaker honk = new LegoMyEgo("Bob");
		honk.speak();
	}
}
