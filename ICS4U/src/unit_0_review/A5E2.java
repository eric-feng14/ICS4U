package unit_0_review;
import java.util.*;
import java.io.*;

/**
 * Calculate the average of a set of numbers
 * @author Eric Feng
 * @version Feb 19 2025
 */
public class A5E2 {

	public static void main(String[] args) {
		// Declare variables
		int numberOfMarks, totalMark = 0;
		int counter = 0;
		int n;
		
		// Collect input
		Scanner input = new Scanner(System.in);
		numberOfMarks = input.nextInt();
		
		// Loop until all input is taken
		while (counter < numberOfMarks) {
			try {
				n = input.nextInt();
				input.nextLine();
				totalMark += n;
				counter++;
			}
			catch (InputMismatchException ex) {
				System.out.println("Invalid input!");
			}
		}
		input.close();
		System.out.println(totalMark);
	}

}
