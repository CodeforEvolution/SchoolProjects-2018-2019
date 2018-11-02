import java.util.ArrayList;

//FlatScreenArrays: Jake, Savir

public class FlatScreenArrays {
	public static void main(String[] args)
	{
		//Array
		FlatScreen[] screens = {new FlatScreen(30, "Samsung"), 
								new FlatScreen(20, "Vizio"),
								new FlatScreen(50, "LG"),
								new FlatScreen(45, "Sonzy"),
								new FlatScreen(43, "Bose")};
		
		System.out.println("The Screens: ");
		for (int i = 0; i < screens.length; i++)
		{
			System.out.println(screens[i]);
		}
		System.out.println();
		
		int smallI = 0;
		for (int i = 0; i < screens.length; i++)
		{
			if (screens[smallI].getDiagonal() > screens[i].getDiagonal())
			{
				smallI = i;
			}
		}
		
		int largeI = 0;
		for (int i = 0; i < screens.length; i++)
		{
			if (screens[largeI].getDiagonal() < screens[i].getDiagonal())
			{
				largeI = i;
			}
		}
		
		FlatScreen temp = screens[smallI];
		screens[smallI] = screens[largeI];
		screens[largeI] = temp;
		
		System.out.println("\nPost swap screens: ");
		for (int i = 0; i < screens.length; i++)
		{
			System.out.println(screens[i]);
		}
		System.out.println();
		
		//ArrayLists
		
		ArrayList<FlatScreen> BestBuy = new ArrayList<FlatScreen>();
		for (int i = 0; i < 4; i++){
			BestBuy.add(new FlatScreen(i*50+20, "Case No. " + i));
		}
		
		BestBuy.add(new FlatScreen(20, "Case No. 0"));
		for (FlatScreen helpme: BestBuy){
			System.out.println(helpme);
		}
		System.out.println();
		int guillotine = -1; 
		for (int i = 0; i < 5; i++){
			for (int j = 0; j < 5; j++){
				
				if (BestBuy.get(i).equals(BestBuy.get(j))){
					
					if(i!=j){
					BestBuy.set(i, new FlatScreen(99, "Vizio FlatScreen"));
					guillotine = j;
					}
				}
			}
		}
		
		BestBuy.remove(guillotine);
		
		for (FlatScreen helpme: BestBuy){
			System.out.println(helpme);
		}
	}
}
