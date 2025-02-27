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
		final int LOWERBOUND = 0, UPPERBOUND = 100;

		// Declare variables
		int numberOfMarks = 0, totalMark = 0;
		int counter = 0, n;
		double avg;

		// Collect input
		try {
			Scanner input = new Scanner(System.in);
			System.out.print("Enter the number of marks to input: ");
			numberOfMarks = input.nextInt();
			if (numberOfMarks < 0) {
				System.out.println("No negative numbers. Restart the program");
				System.exit(0);
			}
			while (counter < numberOfMarks) {
				System.out.print("Enter the mark: ");
				n = input.nextInt();
				if (n >= LOWERBOUND && n <= UPPERBOUND) { // if the mark is valid
					totalMark += n;
					counter++;
				} else {
					System.out.println("Invalid mark!");
				}
			}
			input.close();
		} catch (InputMismatchException ex) { //catch input mismatch
			System.out.println("Invalid input! Run the program again");
			System.exit(0);
		} 

		//Final calculations and output
		avg = (double) totalMark / (double) numberOfMarks;
		System.out.format("The overall average was %.2f%%", avg);
	}

}
