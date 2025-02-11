package unit_0_review;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		// Collect input
		System.out.print("Enter mark: ");
		int mark = input.nextInt();
		input.nextLine();
		System.out.print("Enter code and courses");
		String course = input.nextLine();
		input.close();
		
		// Output
		System.out.format("You got %d%% in %s.", mark, course);
	}
}
