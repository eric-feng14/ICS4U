package unit_0_review;
import java.util.*;

/**
 * Calculate the average of a set of numbers - reading from keyboard input
 * @author Eric Feng
 * @version Feb 19 2025
 */
public class A5E2_a {

	public static void main(String[] args) {
		// Declare constants
		final int lowerBound = 0, upperBound = 100;
		
		// Declare variables
		int numberOfMarks = 0, totalMark = 0;
		int counter = 0, n;
		double avg;
		
		// Collect input
		Scanner input = new Scanner(System.in);
		try {
			System.out.print("Enter the number of marks to input: ");
			numberOfMarks = input.nextInt();
			input.nextLine();
			if (numberOfMarks <= 0) { // catch invalid numbers
				System.out.println("Invalid number! Restart the program");
				System.exit(0);
			}
		} catch (InputMismatchException ex) { //catch input mismatch
			System.out.println("Invalid input! Run the program again");
			System.exit(0);
		} 
		
		// Loop until all input is taken
		while (counter < numberOfMarks) {
			try {
				System.out.print("Enter the mark: ");
				n = input.nextInt();
				input.nextLine();
				if (n >= lowerBound && n <= upperBound) { // if the mark is valid
					totalMark += n;
					counter++;
				} else {
					System.out.println("Invalid mark!");
				}
			}
			catch (InputMismatchException ex) { // catch input mismatch
				System.out.println("Invalid input!");
				input = new Scanner(System.in); //this is necessary to avoid infinite loop
			} 
		}
		input.close();
		
		//Final calculations and output
		avg = totalMark / numberOfMarks;
		System.out.format("The overall average was %.2f%%", avg);
	}

}
