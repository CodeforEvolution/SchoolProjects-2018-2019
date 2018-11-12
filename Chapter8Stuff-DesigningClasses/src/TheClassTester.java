import java.util.Scanner;


public class TheClassTester {
	public static void main(String[] args)
	{
		//Geometry Class
		Scanner in = new Scanner(System.in);
		double r = 0.0;
		double h = 0.0;
		
		System.out.println("Heya! Please enter a radius and height to be used for some calculations: ");
		r = in.nextDouble();
		h = in.nextDouble();
		in.close();
		
		System.out.println("Sphere Volume: " + Geometry.sphereVolume(r));
		System.out.println("Sphere Surface Area: " + Geometry.sphereSurface(r));
		System.out.println("Cylinder Volume: " + Geometry.cylinderVolume(r, h));
		System.out.println("Cylinder Surface Area: " + Geometry.cylinderSurface(r, h));
		System.out.println("Cone Volume: " + Geometry.coneVolume(r, h));
		System.out.println("Cone Surface Area: " + Geometry.coneSurface(r, h));
		
		//Separate Shape Classes
		System.out.println();
		
		Sphere mySphere = new Sphere(r);
		Cylinder myCylinder = new Cylinder(r, h);
		Cone myCone = new Cone(r, h);
		
		System.out.println("Sphere Volume: " + mySphere.getVolume());
		System.out.println("Sphere Surface Area: " + mySphere.getSurfaceArea());
		System.out.println("Cylinder Volume: " + myCylinder.getVolume());
		System.out.println("Cylinder Surface Area: " + myCylinder.getSurfaceArea());
		System.out.println("Cone Volume: " + myCone.getVolume());
		System.out.println("Cone Surface Area: " + myCone.getSurfaceArea());
		
		
	}
}
