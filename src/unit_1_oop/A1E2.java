package unit_1_oop;
import java.util.*;

/**
 * prints a usable signature
 * @author Eric Feng
 * @version March 7 2025
 */
public class A1E2 {

	/**
	 * return email address based on a name
	 * @param name represents the full name
	 * @return modified email
	 */
	public static String getEmail(String name) {
		final String organization = "@hdsb.ca";
		int index = name.indexOf(" ");
		String firstChar = name.substring(0,1).toLowerCase();
		String lastName = name.substring(index+1).toLowerCase();
		String email = lastName + firstChar + organization;
		return email;
	}
	
	/**
	 * main
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String name, grade, school;
		
		//Collect input
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
