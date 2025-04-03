package unit_0_review;
import java.util.*;
import java.io.*;

/**
 * Calculate the average of a set of numbers - reading from file
 * @author Eric Feng
 * @version Feb 19 2025
 */
public class A5E2_b {

	public static void main(String[] args) {
		// Declare constants
		final int lowerBound = 0, upperBound = 100;
		
		// Declare variables
		int numberOfMarks = 0, totalMark = 0;
		int counter = 0, n;
		double avg;
		
		// Collect input
		try {
			Scanner input = new Scanner(new File("info.txt"));
			numberOfMarks = input.nextInt();
			if (numberOfMarks < 0) {
				System.out.println("No negative numbers");
				System.exit(0);
			}
			while (counter < numberOfMarks) {
				n = input.nextInt();
				if (n >= lowerBound && n <= upperBound) { // if the mark is valid
					totalMark += n;
					counter++;
				} else {
					System.out.println("Invalid mark! Make sure all values are between 1 and 100. Restart the program");
					System.exit(0);
				}
			}
		} catch (InputMismatchException ex) { //catch input mismatch
			System.out.println("Invalid input! Run the program again");
			System.exit(0);
		} catch (FileNotFoundException ex) {
			System.out.println("File not found! Run the program again");
			System.exit(0);
		}
		
		//Final calculations and output
		avg = (double) totalMark / (double) numberOfMarks;
		System.out.format("The overall average was %.2f%%", avg);
	}

}
