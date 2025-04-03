package unit_0_review;
import java.util.*;

/**
 * This program takes in input for your address, and prints out
 * the complete mailing address surrounded by X's
 * @author Eric Feng
 * @version Feb 9 2025
 */
public class A3E1 {

	public static void main(String[] args) {
		// Instantiate scanner object and declare variables
		Scanner input = new Scanner(System.in);
		String name, address, city;
		
		// Collect input
		System.out.print("Please enter your name: ");
		name = input.nextLine();
		System.out.print("Please enter your address: ");
		address = input.nextLine();
		System.out.print("Please enter your city: ");
		city = input.nextLine();
		input.close();
		
		// print out information
		System.out.format("                                                           XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX\n");
		System.out.format("                                                           X%-30sX\n", name);
		System.out.format("                                                           X%-30sX\n", address);
		System.out.format("                                                           X%-30sX\n", city);
		System.out.format("                                                           XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
	}

}
