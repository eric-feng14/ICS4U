package unit_0_review;
import java.util.*;

public class Unit3_handwritten_practice {

	public static void main(String[] args) {
		// constants
		final int MIN_IN_HOUR = 60;
		
		// variables
		int totalMinutes, hours, mins;
		String stringMins;
		
		// input
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the time in minutes: ");
		totalMinutes = input.nextInt();
		input.close();
		
		// Calculations
		hours = totalMinutes / MIN_IN_HOUR;
		mins = totalMinutes % MIN_IN_HOUR;
		
		/*
		 * Note: you cannot cast an int object to a String object. (e.g. primitive vs reference)
		 * As a solution, you can create a new String object and add an empty string to the integer as shown below
		 * Java will implicitly convert the integer to match with the string.
		 */
		stringMins = mins + "";
		
		// Check for single digit
		if (mins >= 0 && mins < 10) {
			stringMins = "0" + stringMins;
		}
		
		//Final output
		System.out.format("The time %d minutes is %d:%s.", totalMinutes, hours, stringMins);
	}
}
