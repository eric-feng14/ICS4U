package unit_0_review;
import java.util.Scanner;

/**
 * Calculates the tax for a given income
 * @author Eric Feng
 * @version Feb 10 2025
 */
public class A4E1 {

	public static void main(String[] args) {
		// Declare variables
		int income, tax = 0;
		double bracket1, bracket2, bracket3;
		bracket1 = 0.17;
		bracket2 = 0.24;
		bracket3 = 0.29;
		
		// Collect input
		Scanner input = new Scanner(System.in);
		income = input.nextInt();
		input.close();
		
		if (income >= bracket1) {
			tax += bracket1 * income;
		
		if (income >= bracket2) {
			tax += bracket2 * income;
		}
		
		
		}
		
	}

}
