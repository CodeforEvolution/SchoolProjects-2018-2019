package CreativeClass;

import java.awt.Color;

public class OYes {
	public static void main(String[] args)
	{
		OperatingSystem smack = new macOS(10, 8, Color.WHITE);
		OperatingSystem daemon = new FreeBSD(21, 6, Color.RED);
		OperatingSystem legacy = new Haiku(14, 7, Color.BLUE);
		OperatingSystem shark = new Windows(50, 10, Color.BLACK);
		
		System.out.println("The Operating Systems:\n");
		System.out.println(smack);
		System.out.println(daemon);
		System.out.println(legacy);
		System.out.println(shark);
	}
}
