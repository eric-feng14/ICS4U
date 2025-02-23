package unit_0_review;
import java.util.*;
import java.io.*;

/**
 * Calculate the average of a set of numbers - reading from a file
 * @author Eric Feng
 * @version Feb 20 2025
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
			if (numberOfMarks <= 0) { // Catch invalid number
				System.out.println("Invalid number! Restart the program");
				System.exit(0);
			}
			// Loop until all input is taken
			while (counter < numberOfMarks) {
				try {
					n = input.nextInt();
					if (n >= lowerBound && n <= upperBound) { // if the mark is valid
						totalMark += n;
						counter++;
					} else {
						System.out.println("Invalid number!");
					}
				}
				catch (InputMismatchException ex) { // catch invalid marks
					System.out.println("Invalid input!");
					input = new Scanner(System.in); //this is necessary to avoid infinite loop ?
				} 
			}
			input.close();
			
		} catch (FileNotFoundException ex) { // catch file not found
			System.out.println("File not Found!");
			System.exit(0);
		}
		
		// Final calculation and output
		avg = (double) totalMark / (double) numberOfMarks;
		System.out.format("The overall average was %.2f%%", avg);
	}

}
