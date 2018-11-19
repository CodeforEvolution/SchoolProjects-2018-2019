
public class BarcodeTester {
	public static void main(String[] args)
	{
		Barcode bar = new Barcode(95014);
		System.out.println(bar);
		
		Barcode other = new Barcode("||:|:::|:|:||::::::||:|::|:::|||");
		System.out.println(other);
	}
}
