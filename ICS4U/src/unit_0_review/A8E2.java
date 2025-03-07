package unit_0_review;
import java.util.*;

/**
 * prints a usable signature
 * @author Eric Feng
 * @version March 7 2025
 */
public class A8E2 {

	public static String getEmail(String name) {
		final String organization = "@hdsb.ca";
		int index = name.indexOf(" ");
		String firstChar = name.substring(0,1).toLowerCase();
		String lastName = name.substring(index+1).toLowerCase();
		String email = lastName + firstChar + organization;
		return email;
	}
	
	/**
	 * collect input and send to output function
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String name, grade, school;
		
		System.out.print("Enter name: ");
		name = input.nextLine();
		System.out.print("Enter grade: ");
		grade = input.nextLine();
		System.out.print("Enter school: ");
		school = input.nextLine();
		
		// Output
		String email = getEmail(name);
		System.out.println(name + ", Grade " + grade);
		System.out.println(email);
		System.out.println(school);
	}                                

}
