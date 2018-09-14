
public class TeacherTester {
	public static void main(String[] args) {
		Student johnknee = new Student("Johnknee");
		Student bob = new Student("Bob");
		
		System.out.println("Its time to take some tests! Let's see how our students do!");
		
		johnknee.addQuiz(70);
		bob.addQuiz(80);
		johnknee.addQuiz(30);
		bob.addQuiz(50);
		johnknee.addQuiz(100);
		
		System.out.println();
		System.out.println(johnknee);
		System.out.println(bob);
		
		System.out.println("\nIt seems bob gave up after two tests...what a shame!");
		System.out.println("Congrats Johnknee!");
	}
}
